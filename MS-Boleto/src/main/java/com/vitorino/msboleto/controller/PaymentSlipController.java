package com.vitorino.msboleto.controller;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import com.vitorino.msboleto.model.bo.PaymentSlipBO;
import com.vitorino.msboleto.model.projection.PaymentSlipProjection;
import com.vitorino.msboleto.repository.PaymentSlipRepository;
import com.vitorino.msboleto.service.PaymentSlipService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public PaymentSlipProjection create(@Valid @RequestBody PaymentSlipBO paymentSlip) {
        PaymentSlipService service = new PaymentSlipService();
        return service.save(paymentSlip, this.repository);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
