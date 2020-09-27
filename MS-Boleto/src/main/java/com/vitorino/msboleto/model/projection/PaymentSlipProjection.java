package com.vitorino.msboleto.model.projection;

import java.util.Date;

import lombok.Value;

@Value
public class PaymentSlipProjection {
    private final Long codigo;
    private final Double valor;
    private final Date vencimento;
}
