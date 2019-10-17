package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.AccountRepo;
import com.shopping4th.ecommerce.entity.Accounts;

@Service
public class AccountServiceImpl implements IAccountService{

	private AccountRepo accountRepo;
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Accounts> findALl() {
		return this.accountRepo.findAll();
	}

	@Override
	public void save(Accounts accounts) {
		//String hashPassword = BCrypt.hashpw(accounts.getPassword(), BCrypt.gensalt(12));
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hash = bCryptPasswordEncoder.encode(accounts.getPassword());
		accounts.setPassword(hash);

		accounts.setEmail(accounts.getEmail());
		accounts.setRole_name(accounts.getRole_name());
		//accounts.setPassword(hashPassword);
	
		this.accountRepo.save(accounts);
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
