package com.vitorino.msboleto.service;

import com.vitorino.msboleto.model.bo.PaymentSlipBO;
import com.vitorino.msboleto.model.entity.PaymentSlip;
import com.vitorino.msboleto.model.projection.PaymentSlipProjection;
import com.vitorino.msboleto.repository.PaymentSlipRepository;

public class PaymentSlipService {
    public PaymentSlipProjection save(PaymentSlipBO paymentSlip, PaymentSlipRepository repository) {
        PaymentSlip newPaymentSlip = new PaymentSlip(
            paymentSlip.getMarca(),
            paymentSlip.getModelo(),
            paymentSlip.getValor(),
            paymentSlip.getVencimento()
        );
        
        PaymentSlip createdPaymentSlip = repository.save(newPaymentSlip);

        return new PaymentSlipProjection(
            createdPaymentSlip.getCodigo(), 
            createdPaymentSlip.getValor(), 
            createdPaymentSlip.getVencimento()
        );
    }
}
