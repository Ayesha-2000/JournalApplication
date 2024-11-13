package com.controller;


import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entry.JournalEntry;
import com.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	/*
	 * private Map<Long,JournalEntry> journalEntries=new HashMap<>();
	 * 
	 * @GetMapping public List<JournalEntry> getAll(){ return new
	 * ArrayList<>(journalEntries.values()); }
	 * 
	 * @PostMapping public boolean creatEntry(@RequestBody JournalEntry myEntry) {
	 * journalEntries.put(myEntry.getId(), myEntry); return true; }
	 * 
	 * @GetMapping("id/{myId}") public JournalEntry
	 * getJournalEntryById(@PathVariable Long myId) { return
	 * journalEntries.get(myId);
	 * 
	 * }
	 * 
	 * @DeleteMapping("id/{myId}") public JournalEntry
	 * deleteJournalEntryById(@PathVariable Long myId) { return
	 * journalEntries.remove(myId);
	 * 
	 * }
	 * 
	 * @PutMapping("id/{myId}") public JournalEntry
	 * updateJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry
	 * myEntry) { return journalEntries.put(myId,myEntry);
	 * 
	 * }
	 */
	
	@Autowired
	private JournalEntryService jes;
	
	/*
	 * @GetMapping public List<JournalEntry> getAll() { return jes.getAll(); }
	 */
	
	@GetMapping 
	public ResponseEntity<?> getAll()
	{
		List<JournalEntry> all=jes.getAll();
		if(all != null && !all.isEmpty()) {
			return new ResponseEntity<>(all,HttpStatus.OK);
		}
		return new ResponseEntity<>(all,HttpStatus.NOT_FOUND);
	}
			  
	/*
	 * @PostMapping public JournalEntry creatEntry(@RequestBody JournalEntry
	 * myEntry) { myEntry.setDate(LocalDateTime.now()); jes.saveEntry(myEntry);
	 * 
	 * return myEntry; }
	 */
	
	
	@PostMapping 
	public  ResponseEntity<JournalEntry> creatEntry(@RequestBody JournalEntry myEntry)
    {
		try {
    	myEntry.setDate(LocalDateTime.now());
    	jes.saveEntry(myEntry);
    	
	    return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(myEntry,HttpStatus.BAD_REQUEST);
		}
	}
			  
	/*
	 * @GetMapping("id/{myId}") public JournalEntry
	 * getJournalEntryById(@PathVariable String myId) { return
	 * jes.findById(myId).orElse(null);
	 * 
	 * }
	 */
	 
	 
	 @GetMapping("id/{myId}") 
	 public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String myId)
	 { 
		 Optional<JournalEntry> j=jes.findById(myId);
			 if(j.isPresent()) {
				 return new ResponseEntity<>(j.get(),HttpStatus.OK);
			 }
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
			 
		/*
		 * @DeleteMapping("id/{myId}") public boolean
		 * deleteJournalEntryById(@PathVariable String myId) { jes.deleteById(myId);
		 * return true;
		 * 
		 * 
		 * }
		 */
	 
	 
	 @DeleteMapping("id/{myId}") 
		public  ResponseEntity<?> deleteJournalEntryById(@PathVariable String myId) 
		{ 
			jes.deleteById(myId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
				 
		}
	/*
	 * @PutMapping("id/{myId}") public JournalEntry
	 * updateJournalEntryById(@PathVariable String myId,@RequestBody JournalEntry
	 * myEntry) { JournalEntry j=JournalEntryService.findById(id).orElse(null);
	 * if(j!=null) {
	 * 
	 * } jes.saveEntry(myEntry);
	 * 
	 * return myEntry; }
	 */
	
}
