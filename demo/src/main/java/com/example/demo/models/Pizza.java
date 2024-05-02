package com.example.demo.models;

import jakarta.persistence.*;

@Table(name = "pizzas")
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizza;
    private String nome;
    private float precoBase;
    private boolean personalizada;

    public Pizza() {
    }

    public Pizza(Long idPizza, String nome, boolean personalizada, float precoBase) {
        this.idPizza = idPizza;
        this.nome = nome;
        this.personalizada = personalizada;
        this.precoBase = precoBase;
    }


    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(boolean personalizada) {
        this.personalizada = personalizada;
    }
}
