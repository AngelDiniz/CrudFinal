package com.example.demo.models;

import jakarta.persistence.*;

@Table(name = "BebidaPedida")
@Entity
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdBebidaPedida;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "IdPedido")
    private Pedido pedido;

    public BebidaPedida(Long idBebidaPedida, int quantidade, Pedido pedido) {
        IdBebidaPedida = idBebidaPedida;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }

    public BebidaPedida() {
    }

    public Long getIdBebidaPedida() {
        return IdBebidaPedida;
    }

    public void setIdBebidaPedida(Long idBebidaPedida) {
        IdBebidaPedida = idBebidaPedida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
