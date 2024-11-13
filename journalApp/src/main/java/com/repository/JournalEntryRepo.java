package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.entry.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String>{

}
