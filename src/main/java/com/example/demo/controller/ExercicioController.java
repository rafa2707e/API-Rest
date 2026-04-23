package com.example.demo.controller;

import com.example.demo.model.Exercicio; // Import correto
import com.example.demo.repository.ExercicioRepository; // Import correto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository;

    @GetMapping
    public List<Exercicio> listarTodos() {
        return repository.findAll();
    } // FECHA o listarTodos aqui!

    @PostMapping
    public Exercicio criar(@RequestBody Exercicio exercicio) {
        return repository.save(exercicio);
    }
} // FECHA a classe aqui!