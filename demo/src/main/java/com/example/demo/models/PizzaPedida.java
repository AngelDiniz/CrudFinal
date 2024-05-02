package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PizzaPedida")
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizzaPedida;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pizza pizza;

    private int idTamanho;
    private int quantidade;

    public PizzaPedida(Pedido pedido, Pizza pizza, int idTamanho, int quantidade, List<Ingredientes> ingredientes) {
        this.pedido = pedido;
        this.pizza = pizza;
        this.idTamanho = idTamanho;
        this.quantidade = quantidade;
        this.ingredientes = ingredientes;
    }

    public PizzaPedida() {
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "PizzaPadida_has_Ingredientes",
            joinColumns = @JoinColumn(name = "idPizzaPedida"),
            inverseJoinColumns = @JoinColumn(name = "idIngredientes")

    )


    private List<Ingredientes> ingredientes;

    public Long getIdPizzaPedida() {
        return idPizzaPedida;
    }

    public void setIdPizzaPedida(Long idPizzaPedida) {
        this.idPizzaPedida = idPizzaPedida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
