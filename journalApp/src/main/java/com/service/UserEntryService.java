package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entry.User;
import com.repository.UserEntryRepo;

@Component
public class UserEntryService {
	@Autowired
	private UserEntryRepo userEntryRepo;

	public void saveEntry(User user) {
		userEntryRepo.save(user);
	}
	
	public List<User> getAll(){
		return userEntryRepo.findAll();
	}
	
	public Optional<User> findById(String id) {
		return userEntryRepo.findById(id);
	}
	
	public void deleteById(String id) {
		userEntryRepo.deleteById(id);
	}
	
	public User findByUserName(String userName) {
		return userEntryRepo.findByUserName(userName);
	}
	
}
