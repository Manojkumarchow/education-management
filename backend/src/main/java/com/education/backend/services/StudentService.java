package com.education.backend.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.education.backend.models.StudentDTO;
import com.education.backend.repositories.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {
	
	Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;
    
    public List<StudentDTO> getAllStudents() {
    	return studentRepository.findAll();
    }
    
    public List<StudentDTO> getStudentByName(String name) {
    	return studentRepository.findByName(name);
    }
    
    public ResponseEntity<StudentDTO> createStudent(StudentDTO studentDTO) {
    	StudentDTO student = studentRepository.save(studentDTO);
    	return student != null? ResponseEntity.ok(student) : (ResponseEntity<StudentDTO>) ResponseEntity.badRequest();
    }
    
    public ResponseEntity<String> deleteStudent(Long id) {
    	studentRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));
    	return ResponseEntity.ok("Student record Deleted");
    }
}