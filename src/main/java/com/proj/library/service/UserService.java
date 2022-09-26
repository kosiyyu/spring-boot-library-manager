package com.proj.library.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proj.library.model.User;
import com.proj.library.repository.IUserRepository;

@Service
public class UserService {

	IUserRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(IUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User saveAndEncode(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}
	
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	
	
	
	
	
}
