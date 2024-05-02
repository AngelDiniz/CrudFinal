package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "Pedidos")


public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idPedido;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idFornada")
    private Fornada fornada;

    @CreationTimestamp
    private Instant dataHora;

}
