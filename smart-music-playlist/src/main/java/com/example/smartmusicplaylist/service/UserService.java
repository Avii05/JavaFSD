package com.example.smartmusicplaylist.service;


import com.example.smartmusicplaylist.model.User;
import com.example.smartmusicplaylist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}
}
