package com.vitorino.msboleto.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@EqualsAndHashCode
public class PaymentSlip {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long codigo;

    @Getter
    @Setter
    private String marca;

    @Getter
    @Setter
    private String modelo;

    @Getter
    @Setter
    private Double valor;

    @Getter
    @Setter
    private Date vencimento;

    public PaymentSlip(String marca, String modelo, Double valor, Date vencimento) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.vencimento = vencimento;
    }
}
