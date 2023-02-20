package com.education.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.education.backend.models.Login;
import com.education.backend.services.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/authenticate", consumes = "application/json")
	public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
		return loginService.authenticateUser(login);
	}

}
