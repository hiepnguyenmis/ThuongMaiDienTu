package com.shopping4th.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.AccountRepo;
import com.shopping4th.ecommerce.dao.RoleRepo;
import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.Role;
import com.shopping4th.ecommerce.entity.UserDto;

@Service(value="userService")
public class AccountServiceImpl implements IAccountService, UserDetailsService{

	private AccountRepo accountRepo;
	private RoleRepo roleRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo, RoleRepo roleRepo) {
		super();
		this.accountRepo = accountRepo;
		this.roleRepo=roleRepo;
		
	}

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Accounts user = accountRepo.findByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(Accounts user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public List<Accounts> findALl() {
		return this.accountRepo.findAll();
	}

	@Override
	public void save(Accounts user) {
		//String hashPassword = BCrypt.hashpw(accounts.getPassword(), BCrypt.gensalt(12));
		Accounts newUser= new Accounts();
		bcryptEncoder = new BCryptPasswordEncoder();
		String hash = bcryptEncoder.encode(user.getPassword());

		//accounts.setRole_name(accounts.getRole_name());
		//accounts.setPassword(hashPassword);
		newUser.setEmail(user.getEmail());
		newUser.setPassword(hash);
		Date created = new Date();
		
		newUser.setCreatedAt(created);
		
		newUser.setRoles(this.roleRepo.findByName("USER"));
		this.accountRepo.save(newUser);
	}

	@Override
	public boolean existsById(Long id) {
		return this.accountRepo.existsById(id);
	}

	@Override
	public Accounts findById(Long id) {
		Optional<Accounts> account = this.accountRepo.findById(id);
		if(account.isPresent()) {
			return account.get();
		}
		else {
			throw new EntityNotFoundException();
		}
		
	}

	@Override
	public Accounts findByEmail(String email) {
		return this.accountRepo.findByEmail(email);
	}

	@Override
	public boolean existsByEmail(String email) {
		return this.accountRepo.existsByEmail(email);
	}

}
