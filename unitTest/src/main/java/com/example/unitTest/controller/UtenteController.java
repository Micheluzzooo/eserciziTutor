package com.example.unitTest.controller;

import com.example.unitTest.entity.Utente;
import com.example.unitTest.repository.UtenteRepository;
import com.example.unitTest.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteRepository utenteRepository;

    @PostMapping("/createUtente")
    public @ResponseBody Utente createUtente(@RequestBody Utente utente) {
        return utenteRepository.save(utente);
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    @GetMapping("/getUtente/{id}")
    public @ResponseBody Utente getUtenteById(@PathVariable Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    @PutMapping("/setUtente/{id}")
    public Utente updateUtente(@PathVariable Long id, @RequestBody Utente newUtente) {
        Utente utente = utenteRepository.findById(id).orElse(null);
        if (utente != null) {
            utente.setName(newUtente.getName());
            utente.setEmail(newUtente.getEmail());
            return utenteRepository.save(utente);
        }
        return null;
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteRepository.deleteById(id);
    }

}
