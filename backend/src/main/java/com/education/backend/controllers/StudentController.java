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

import com.education.backend.models.StudentDTO;
import com.education.backend.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<StudentDTO> getStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{name}")
	public List<StudentDTO> getStudentByName(@PathVariable(value = "name") String name) {
		return studentService.getStudentByName(name);
	}
	
	@PostMapping(value = "/students/createStudent", consumes = "application/json")
	public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.createStudent(studentDTO);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") Long id) {
		return studentService.deleteStudent(id);
	}
}
