package com.education.backend.services;

import com.education.backend.models.ProfessorDTO;
import com.education.backend.repositories.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorDTO> getAllProfessors() {

        return professorRepository.findAll();
    }

    public List<ProfessorDTO> getProfessorByName(String name) {

        return professorRepository.findByName(name);
    }

    public ResponseEntity<ProfessorDTO> createProfessor(ProfessorDTO professorDTO) {
        ProfessorDTO professor = professorRepository.save(professorDTO);
        return professor != null? ResponseEntity.ok(professor) : (ResponseEntity<ProfessorDTO>) ResponseEntity.badRequest();
    }

    public ResponseEntity<String> deleteProfessor(Long id) {
        professorRepository.deleteById(Integer.parseUnsignedInt(String.valueOf(id)));
        return ResponseEntity.ok("Professor record Deleted");
    }
}
