package com.example.demo.controller;

import com.exemplo.strongmind.model.Exercicio;
import com.exemplo.strongmind.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios") // A URL será http://localhost:8080/exercicios
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository; // O Spring "injeta" o repository aqui

    @GetMapping
    public List<Exercicio> listarTodos() {
        // Como o professor explicou, o repository já tem métodos prontos.
        // Qual método do 'repository' você usaria para buscar TODOS os exercícios?
        return repository.findAll();

        @PostMapping
        public Exercicio criar(@RequestBody Exercicio exercicio) {
            return repository.save(exercicio);
        }
    }



}