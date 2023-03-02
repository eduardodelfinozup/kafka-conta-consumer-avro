package com.zupfood.conta;

import javax.persistence.*;
import java.awt.desktop.ScreenSleepEvent;
import java.math.BigDecimal;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private int agencia;

    private long numero;

    private BigDecimal valor;

    @Deprecated
    public Oferta() {
    }

    public Oferta(String tipo, int agencia, long numero, BigDecimal valor) {
        this.tipo = tipo;
        this.agencia = agencia;
        this.numero = numero;
        this.valor = valor;
    }

}