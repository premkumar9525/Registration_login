package com.example.demo.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveuser(User user) {
		// TODO Auto-generated method stub

		return userRepository.save(user);

	}

	

	public Optional<User> findByid(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public void updateuser(User user, Optional<User> udata) {
	
		User userDetails = udata.get();
		userDetails.setFirstname(user.getFirstname());
		userDetails.setLastname(user.getLastname());
		userDetails.setEmail(user.getEmail());
	
		userRepository.save(user);

	}

	public void deleteuserByid(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}



	public List<User> findByUser(Long id, PageRequest pageable) {
         
		return null;
	}



	



	}


