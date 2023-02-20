package com.education.backend.repositories;

import com.education.backend.models.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseDTO, String> {

    List<CourseDTO> findAll();

    @Override
    List<CourseDTO> findAllById(Iterable<String> strings);

    @Query("select c from CourseDTO c where c.courseName= :name")
    List<CourseDTO> findByName(@Param("name") String name);

    @Query("select c from CourseDTO c where c.courseId= :courseId")
    List<CourseDTO> findCourseByCourseId(@Param("courseId") String courseId);
}
