package com.education.backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.education.backend.models.Authentication;
import com.education.backend.models.Login;
import com.education.backend.models.UserDTO;
import com.education.backend.repositories.UserRepository;

@Service
public class LoginService {
	
	Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	
	@Autowired
	private UserRepository repository;

	public ResponseEntity<?> authenticateUser(Login login) {
		
		List<UserDTO> users = repository.findByName(login.getUsername());
		logger.debug("Users: " + users.toString());
		Authentication authentication = getAuthentication(users.get(0));
		logger.debug("authentication: " + authentication.toString());
		return ResponseEntity.ok(authentication);
	}

	private Authentication getAuthentication(UserDTO userDTO) {
		Authentication authentication = new Authentication();
		authentication.setUsername(userDTO.getUsername());
		authentication.setUserid(String.valueOf(userDTO.getId()));
		authentication.setAccessLevel("0");
		authentication.setSessionid("Dummy Session Id");
		return authentication;
	}

}
