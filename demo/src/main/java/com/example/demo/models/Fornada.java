package com.example.demo.models;

import jakarta.persistence.*;

@Table
@Entity
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornada;
    private int numFornada;
    private int qunatPizzas;

    public Fornada(Long idFornada, int numFornada, int qunatPizzas) {
        this.idFornada = idFornada;
        this.numFornada = numFornada;
        this.qunatPizzas = qunatPizzas;
    }


    public Long getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Long idFornada) {
        this.idFornada = idFornada;
    }

    public int getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(int numFornada) {
        this.numFornada = numFornada;
    }

    public int getQunatPizzas() {
        return qunatPizzas;
    }

    public void setQunatPizzas(int qunatPizzas) {
        this.qunatPizzas = qunatPizzas;
    }
}
