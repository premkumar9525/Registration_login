package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SendEmails;

public interface SendEmailRepository extends JpaRepository<SendEmails, Long> {

}
