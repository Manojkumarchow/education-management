package com.education.backend.repositories;

import com.education.backend.models.ProfessorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//You need to create the repository that holds professor records
public interface ProfessorRepository extends JpaRepository<ProfessorDTO, Integer> {
    List<ProfessorDTO> findAll();

    @Query("SELECT p FROM ProfessorDTO AS p WHERE p.professorUsername= :name")
    List<ProfessorDTO> findByName(@Param("name") String name);


}
