package com.example.demo.models;

import jakarta.persistence.*;

@Table(name = "Bebida")
@Entity
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBebidas;
    private String nome;
    private float preco;

    public Bebida(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Bebida() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
