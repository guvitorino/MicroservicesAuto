package com.vitorino.msautomoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vitorino.msautomoveis.model.Automobiles;

public interface AutomobilesRepository extends JpaRepository<Automobiles, Long> {
    
}
