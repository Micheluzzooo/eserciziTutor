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

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> setInventor(@PathVariable Long id, @RequestParam String inventor) {
        Optional<ProgrammingLanguage> optionalLanguage = programmingLanguageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            ProgrammingLanguage existingLanguage = optionalLanguage.get();
            existingLanguage.setInventor(inventor);
            programmingLanguageRepository.save(existingLanguage);
            return ResponseEntity.ok(existingLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getTwo")
    public ResponseEntity<Page> getList() {
        Page languages = programmingLanguageRepository.findAll(PageRequest.of(0, 2));
        return ResponseEntity.ok(languages);
    }

}
