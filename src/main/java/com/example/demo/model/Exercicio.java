package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_exercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;          // Ex: "Supino"
    private String grupoMuscular; // Ex: "Peito"
    private double carga;         // Ex: 80.0
    private int series;           // Ex: 4
    private int repeticoes;       // Ex: 10
}