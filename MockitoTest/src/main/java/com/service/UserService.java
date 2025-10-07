package com.service;

import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
 
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		// TODO Auto-generated constructor stub
	}
	public String getUserNameById(Long id) {
		return userRepository.findById(id).map(User::getName).orElse("Unknown");
	}
}
