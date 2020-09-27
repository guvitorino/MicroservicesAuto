package com.vitorino.msautomoveis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vitorino.msautomoveis.model.Automobiles;
import com.vitorino.msautomoveis.repository.AutomobilesRepository;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@RestController
public class AutomobilesController {

    private final AutomobilesRepository repository;

    public AutomobilesController(AutomobilesRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/cadastroAutomoveis", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Automobiles create(@Valid @RequestBody Automobiles automobiles) {
        return this.repository.save(automobiles);
    }

    @GetMapping(path = "/automoveis", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Automobiles> get() {
        return this.repository.findAll();
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
