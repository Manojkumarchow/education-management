package com.education.backend.controllers;

import com.education.backend.models.UserDTO;
import com.education.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getProfessors() {
        return userService.getUsers();
    }

    @GetMapping("/users/{name}")
    public List<UserDTO> getProfessorByName(@PathVariable(value = "name") String name) {
        return userService.getUserByName(name);
    }

    @PostMapping(value = "/users/createUser", consumes = "application/json")
    public ResponseEntity<UserDTO> createProfessor(@RequestBody UserDTO professorDTO) {
        return userService.createUser(professorDTO);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable(value = "id") Long id) {
        return userService.deleteUser(id);
    }
}