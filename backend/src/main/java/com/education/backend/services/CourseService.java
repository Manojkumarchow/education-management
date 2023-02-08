package com.education.backend.services;

import com.education.backend.models.CourseDTO;
import com.education.backend.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getCourses() {
        return courseRepository.findAll();
    }

    public List<CourseDTO> getCourseByName(String courseName) {
        return courseRepository.findByName(courseName);
    }

    public ResponseEntity<CourseDTO> createCourse(CourseDTO course) {
        CourseDTO createdCourse = courseRepository.save(course);
        return ResponseEntity.ok(createdCourse);
    }

    public ResponseEntity<String> deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
        return ResponseEntity.ok("Course Deleted");
    }

    public List<CourseDTO> getCourseById(String id) {
        return courseRepository.findAllById(Collections.singleton(id));
    }

    public List<CourseDTO> getCourseByCourseId(String courseId) {
        return courseRepository.findCourseByCourseId(courseId);
    }
}
