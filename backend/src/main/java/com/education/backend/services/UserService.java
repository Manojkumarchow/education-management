package com.education.backend.services;

import com.education.backend.models.UserDTO;
import com.education.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while fetching the users");
            return null;
        }
    }

    public List<UserDTO> getUserByName(String name) {
        try {
            return userRepository.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while fetching the user by name");
            return null;
        }
    }

    public ResponseEntity<?> createUser(UserDTO userDTO) {
        try {
            UserDTO user = userRepository.save(userDTO);
            return ResponseEntity.ok(user);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            dataIntegrityViolationException.printStackTrace();
            logger.error("Error while saving the user");
            return new ResponseEntity<>("Error while saving the user to the database", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception while saving the user");
            return new ResponseEntity<>("Exception while saving the user", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> deleteUser(Long id) {
        try {
            userRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));
            return ResponseEntity.ok("User Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while deleting the user", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> updateUserAccessLevel(UserDTO user) {
        try {
            return ResponseEntity.ok(userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while updating the user", HttpStatus.BAD_REQUEST);
        }
    }
}
