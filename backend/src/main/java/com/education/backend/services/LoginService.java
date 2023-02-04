package com.education.backend.services;

import com.education.backend.models.Authentication;
import com.education.backend.models.Login;
import com.education.backend.models.UserDTO;
import com.education.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {


    @Autowired
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> authenticateUser(Login login) {
        List<UserDTO> users = userRepository.authenticateUser(login.getUsername(), login.getPassword());
        Authentication authentication = users.size() > 0 ? getAuthentication(users.get(0)) : null;
        return authentication != null ? ResponseEntity.ok(authentication) : new ResponseEntity("Wrong Credentials", HttpStatus.UNAUTHORIZED);
    }

    private Authentication getAuthentication(UserDTO user) {
        Authentication authentication = new Authentication();
        authentication.setUsername(user.getUsername());
        authentication.setUserid(String.valueOf(user.getId()));
        authentication.setAccessLevel("0");
        authentication.setSessionid("Dummy Session Id");
        return authentication;
    }

}
