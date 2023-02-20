package com.education.backend.services;

import com.education.backend.models.ProfessorDTO;
import com.education.backend.repositories.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorService {

    Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorDTO> getAllProfessors() {
        try {
            return professorRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while fetching the professors/staff list");
            return null;
        }
    }

    public List<ProfessorDTO> getProfessorByName(String name) {
        try {
            return professorRepository.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while fetching the professors/staff list");
            return null;
        }
    }

    public ResponseEntity<?> createProfessor(ProfessorDTO professorDTO) {
        try {

            ProfessorDTO professor = professorRepository.save(professorDTO);
            return ResponseEntity.ok(professor);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while creating/saving the professor", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteProfessor(Long id) {
        try {
            professorRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));
            return ResponseEntity.ok("Professor record Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while deleting the professor", HttpStatus.BAD_REQUEST);
        }


    }
}
