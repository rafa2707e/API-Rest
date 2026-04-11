package com.example.demo.model; // O nome do seu pacote aqui

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_exercicios") // Define o nome da tabela no banco
@Data
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