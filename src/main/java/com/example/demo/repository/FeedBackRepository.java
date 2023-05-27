package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {


	List<FeedBack> findByStatus(boolean b);

}
