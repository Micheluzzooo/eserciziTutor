package com.example.esercizioSpringRepositories2.controller;


import com.example.esercizioSpringRepositories2.entity.ProgrammingLanguage;
import com.example.esercizioSpringRepositories2.repository.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/programmingLanguage")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @PostMapping("/addLanguage")
    public ResponseEntity<ProgrammingLanguage> createLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage savedLanguage = programmingLanguageRepository.save(programmingLanguage);
        return ResponseEntity.ok(savedLanguage);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProgrammingLanguage>> getAllLanguage() {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        return ResponseEntity.ok(languages);
    }

}
