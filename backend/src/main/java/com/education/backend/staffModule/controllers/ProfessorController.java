package com.education.backend.staffModule.controllers;


//  @Controller annotation indicates that the class is a “controller” like a
//  web controller. @RestController annotation indicates that class is a
//  controller where @RequestMapping methods assume @ResponseBody
//  semantics by default. In @Controller, we need to use @ResponseBody on
//  every handler method.

import com.education.backend.staffModule.models.ProfessorDTO;
import com.education.backend.staffModule.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/professors")
    public List<ProfessorDTO> getProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/professors/{name}")
    public List<ProfessorDTO> getProfessorByName(@PathVariable(value = "name") String name) {
        return professorService.getProfessorByName(name);
    }

    @PostMapping(value = "/professors/createProfessor", consumes = "application/json")
	public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO professorDTO) {
		return professorService.createProfessor(professorDTO);
	}

    @DeleteMapping("/professors/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable(value = "id") Long id) {
        return professorService.deleteProfessor(id);
    }
}
