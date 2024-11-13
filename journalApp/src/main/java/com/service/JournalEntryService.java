package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entry.JournalEntry;
import com.repository.JournalEntryRepo;
@Component
public class JournalEntryService {

	@Autowired
	private JournalEntryRepo repo;
	public void saveEntry(JournalEntry entry) {
		repo.save(entry);
	}
	
	public List<JournalEntry> getAll(){
		return repo.findAll();
	}
	
	public Optional<JournalEntry> findById(String id) {
		return repo.findById(id);
	}
	
	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	
	
}

//controller--->service----->repository
