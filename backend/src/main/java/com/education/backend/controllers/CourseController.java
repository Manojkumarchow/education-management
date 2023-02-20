package com.education.backend.controllers;

import com.education.backend.models.CourseDTO;
import com.education.backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/all/{id}")
    public List<CourseDTO> getCourseById(@PathVariable(value = "id") String id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/courses/courseid/{id}")
    public List<CourseDTO> getCourseByCourseId(@PathVariable(value = "id") String courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

    @GetMapping("/courses/{name}")
    public List<CourseDTO> getCourseByName(@PathVariable(value = "name") String name) {
        return courseService.getCourseByName(name);
    }

    @PostMapping(value = "/courses/createCourse", consumes = "application/json")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(value = "id") String courseId) {
        return courseService.deleteCourse(courseId);
    }
}

