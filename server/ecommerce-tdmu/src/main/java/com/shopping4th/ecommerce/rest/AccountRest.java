package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.UserDto;
import com.shopping4th.ecommerce.service.AccountService;
import com.shopping4th.ecommerce.service.AccountServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Api(value = "Controller handles different messages")
//@Api(value="Account Management System", description="Operations pertaining to account in Account Management System")
public class AccountRest {

	private AccountService accountService;
	@Autowired
	public AccountRest(AccountServiceImpl accountService) {
		this.accountService = accountService;
	}

	//@PreAuthorize("hasRole('USER')")
//	@ApiOperation(value = "View a list of available account", response = List.class)
//	@ApiResponses(value = {
//
//		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
//
//		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//
//		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//
//		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//
//		})
	@GetMapping("/accounts")
	@ApiOperation(value = "Returns list account")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<Accounts> getAllAccounts(){
		return this.accountService.findALl();
	}
	
//	@PostMapping("/login")
//	public String login(@RequestBody @Valid Accounts accounts) {
//		
//	
//		if(!accountService.existsByEmail(accounts.getEmail())) {
//			return "Not found user with this email!";
//		}
//		
//		Accounts loginAccount = this.accountService.findByEmail(accounts.getEmail());
//		if(loginAccount.getEmail().equals(accounts.getEmail()) && checkHashPasswd(accounts.getPassword(), loginAccount.getPassword())) {
//			return "Login succesfully with email " + loginAccount.getEmail();
//		}
//		
//		return "Login falied!";
//		
//	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<Accounts> createAccount(@Valid @RequestBody Accounts accounts) {
		boolean isAccount = this.accountService.existsByEmail(accounts.getEmail());
		if(isAccount) 
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		else {
			accounts.setCreatedAt(new Date());
			this.accountService.save(accounts);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
	}
	
	public boolean checkHashPasswd(String passwd, String hashPasswd) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		boolean valuate = bCryptPasswordEncoder.matches(passwd, hashPasswd);
		return valuate;
	}
	
}
