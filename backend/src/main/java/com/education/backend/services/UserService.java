package com.education.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.education.backend.models.UserDTO;
import com.education.backend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserDTO> getUsers() {

		return userRepository.findAll();

	}

	public List<UserDTO> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
		UserDTO user = userRepository.save(userDTO);
		return ResponseEntity.ok(user);
	}

	public ResponseEntity<String> deleteUser(Long id) {

		userRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));

		return ResponseEntity.ok("User Deleted");
	}

}
