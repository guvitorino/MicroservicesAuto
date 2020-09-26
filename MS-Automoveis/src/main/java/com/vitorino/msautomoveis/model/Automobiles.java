package com.vitorino.msautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Automobiles {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

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
    @CreationTimestamp
    private Date dataDeCadastro;
}
