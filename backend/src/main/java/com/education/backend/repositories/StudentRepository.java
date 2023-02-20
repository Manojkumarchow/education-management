package com.education.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.education.backend.models.StudentDTO;

public interface StudentRepository extends JpaRepository<StudentDTO, Integer> {
	List<StudentDTO> findAll();
	
	@Query("SELECT s FROM StudentDTO AS s WHERE s.studentName= :name")
	List<StudentDTO> findByName(@Param("name") String name);

	@Query("SELECT s FROM StudentDTO AS s WHERE s.studentId= :id")
	List<StudentDTO> findById(@Param("id") String id);
}
