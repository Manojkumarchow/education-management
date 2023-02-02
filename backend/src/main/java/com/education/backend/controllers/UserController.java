package com.education.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.education.backend.models.UserDTO;
import com.education.backend.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{name}")
	public List<UserDTO> getUserByName(@PathVariable(value = "name") String name) {
		return userService.getUserByName(name);
	}

	@PostMapping(value = "/users/createUser", consumes = "application/json")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		return userService.createUser(userDTO);
	}

	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
		return userService.deleteUser(id);

	}

}
