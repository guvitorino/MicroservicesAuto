package com.vitorino.msboleto.controller;

import com.vitorino.msboleto.model.bo.PaymentSlipBO;
import com.vitorino.msboleto.model.projection.PaymentSlipProjection;
import com.vitorino.msboleto.repository.PaymentSlipRepository;
import com.vitorino.msboleto.service.PaymentSlipService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentSlipController {
    private final PaymentSlipRepository repository;

    public PaymentSlipController(PaymentSlipRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/boleto", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentSlipProjection create(@RequestBody PaymentSlipBO paymentSlip) {
        PaymentSlipService service = new PaymentSlipService();
        return service.save(paymentSlip, this.repository);
    }
}
