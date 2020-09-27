package com.vitorino.msboleto.model.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

public class PaymentSlipBO {
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

    private Date generateVecimento() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(today);
        calendar.add(Calendar.DATE, 3);

        return calendar.getTime();
    }

    public PaymentSlipBO(String marca, String modelo, Double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.vencimento = this.generateVecimento();
    }
}
