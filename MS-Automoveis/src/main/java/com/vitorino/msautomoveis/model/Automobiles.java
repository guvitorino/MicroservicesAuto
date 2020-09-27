package com.vitorino.msautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "marca é obrigatório")
    private String marca;

    @Getter
    @Setter
    @NotBlank(message = "modelo é obrigatório")
    private String modelo;

    @Getter
    @Setter
    @NotNull(message = "valor é obrigatório")
    private Double valor;

    @Getter
    @Setter
    @CreationTimestamp
    private Date dataDeCadastro;
}
