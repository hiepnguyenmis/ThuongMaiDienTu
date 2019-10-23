package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.service.AccountServiceImpl;

@RestController
@RequestMapping("/api")
public class AccountRest {

	private AccountServiceImpl accountService;
	@Autowired
	public AccountRest(AccountServiceImpl accountService) {
		super();
		this.accountService = accountService;
	}

	
	@GetMapping("/accounts")
	public List<Accounts> getAllAccounts(){
		return this.accountService.findALl();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody @Valid Accounts accounts) {
		
	
		if(!accountService.existsByEmail(accounts.getEmail())) {
			return "Not found user with this email!";
		}
		
		Accounts loginAccount = this.accountService.findByEmail(accounts.getEmail());
		if(loginAccount.getEmail().equals(accounts.getEmail()) && checkHashPasswd(accounts.getPassword(), loginAccount.getPassword())) {
			return "Login succesfully with email " + loginAccount.getEmail();
		}
		
		return "Login falied!";
		
	}
	
	@PostMapping("/signup")
	public Accounts createAccount(@Valid @RequestBody Accounts accounts) {
		accounts.setCreatedAt(new Date());
		this.accountService.save(accounts);
		
		return this.accountService.findById(accounts.getId());

	}
	
	public boolean checkHashPasswd(String passwd, String hashPasswd) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		boolean valuate = bCryptPasswordEncoder.matches(passwd, hashPasswd);
		return valuate;
	}
	
}
