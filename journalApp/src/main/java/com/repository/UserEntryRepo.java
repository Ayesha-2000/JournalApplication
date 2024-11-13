package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.entry.User;

public interface UserEntryRepo extends MongoRepository<User,String>{
User findByUserName(String userName);
}
