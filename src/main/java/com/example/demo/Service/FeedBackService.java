package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FeedBack;
import com.example.demo.repository.FeedBackRepository;
import com.example.demo.utility.Constants;

@Service
public class FeedBackService {
	@Autowired
	FeedBackRepository feedBackRepo;

	public void save(FeedBack feedback) {
		feedback.setStatus(true);
		feedback.setCreatedDate(Constants.getDateAndTime());
		
		feedBackRepo.save(feedback);
		
	}

	public List<FeedBack> findAll() {
		return feedBackRepo.findAll();
	}


}
