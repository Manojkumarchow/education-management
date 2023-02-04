package com.education.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.education.backend.models.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {

	List<UserDTO> findAll();

	@Query("select u from UserDTO u where u.username= :name")
	List<UserDTO> findByName(@Param("name") String name);
}