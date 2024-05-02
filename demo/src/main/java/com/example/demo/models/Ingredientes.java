package com.example.demo.models;

import jakarta.persistence.*;

@Table(name = "Ingredientes")
@Entity
public class Ingredientes {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idIngredientes;

    private String name;

    private float preco;

    public Ingredientes() {
    }

    public Ingredientes(Long idIngredientes, String name, float preco) {
        this.idIngredientes = idIngredientes;
        this.name = name;
        this.preco = preco;
    }

    public Long getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Long idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
