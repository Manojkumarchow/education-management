package com.education.backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.education.backend.models.UserDTO;
import com.education.backend.repositories.UserRepository;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getUsers() {

		return userRepository.findAll();

	}

	public List<UserDTO> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
		UserDTO user = userRepository.save(userDTO);
		return user != null ? ResponseEntity.ok(user) : (ResponseEntity<UserDTO>) ResponseEntity.badRequest();
	}

	public ResponseEntity<String> deleteUser(Long id) {

		userRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));

		return ResponseEntity.ok("User Deleted");
	}

}
