package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Long> {

}
