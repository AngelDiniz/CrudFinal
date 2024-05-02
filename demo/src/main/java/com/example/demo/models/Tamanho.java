package com.example.demo.models;

import jakarta.persistence.*;

@Table(name = "Tamanho")
@Entity
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdTamanho;
    private String nome;
    private float desconto;

    public Tamanho() {
    }

    public Tamanho(Long idTamanho, String nome, float desconto) {
        IdTamanho = idTamanho;
        this.nome = nome;
        this.desconto = desconto;
    }

    public Long getIdTamanho() {
        return IdTamanho;
    }

    public void setIdTamanho(Long idTamanho) {
        IdTamanho = idTamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
