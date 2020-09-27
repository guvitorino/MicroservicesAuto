package com.vitorino.msboleto.repository;

import com.vitorino.msboleto.model.entity.PaymentSlip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSlipRepository extends JpaRepository<PaymentSlip, Long> {
    
}
