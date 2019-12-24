package com.shopping4th.ecommerce.rest;

import com.shopping4th.ecommerce.config.TokenProvider;
import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.AuthToken;
import com.shopping4th.ecommerce.entity.LoginUser;
import com.shopping4th.ecommerce.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.shopping4th.ecommerce.entity.Constants.TOKEN_PREFIX;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {


    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private AccountService accountService;

    @Autowired
	public AuthenticationController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, AccountService accountService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.accountService=accountService;
	}
    

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    @RequestMapping(value = "admin/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> registerAdmin(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        Accounts admin = this.accountService.findByEmail(loginUser.getEmail());
        if(admin.getRoles().size()==2) {
        	 SecurityContextHolder.getContext().setAuthentication(authentication);
             final String token = jwtTokenUtil.generateToken(authentication);
             return ResponseEntity.ok(new AuthToken(token));
        }
       return (ResponseEntity<?>) ResponseEntity.badRequest();
    }




}
