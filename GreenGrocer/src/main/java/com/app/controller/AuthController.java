package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepo;
import com.app.entities.JwtRequest;
import com.app.entities.JwtResponse;
import com.app.entities.UserEntity;
import com.app.security.JwtHelper;
import com.app.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtHelper helper;
	
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
		this.doAuthenticate(request.getEmail(), request.getPassword());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.helper.generateToken(userDetails);
		
		JwtResponse response = JwtResponse.builder()
				.jwtToken(token)
				.username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	private void doAuthenticate(String email, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			authManager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new RuntimeException("Invalid Username or password");
		}
	}
	@PostMapping("/createUser")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}
}
