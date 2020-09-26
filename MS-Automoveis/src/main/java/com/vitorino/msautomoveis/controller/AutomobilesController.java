package com.vitorino.msautomoveis.controller;
import com.vitorino.msautomoveis.model.Automobiles;
import com.vitorino.msautomoveis.repository.AutomobilesRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

@RestController
public class AutomobilesController {

    private final AutomobilesRepository repository;

    public AutomobilesController(AutomobilesRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/cadastroAutomoveis", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Automobiles create(@RequestBody Automobiles automobiles) {
        return this.repository.save(automobiles);
    }
}
