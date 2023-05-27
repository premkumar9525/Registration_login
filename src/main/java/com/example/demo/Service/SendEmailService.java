package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SendEmails;
import com.example.demo.repository.SendEmailRepository;
import com.example.demo.utility.Constants;

@Service
public class SendEmailService {
  @Autowired
  private SendEmailRepository sendEmailRepo;



public void save(SendEmails sendemail) {
	sendemail.setCreatedDate(Constants.getDateAndTime());
	sendEmailRepo.save(sendemail);
	
}
}
