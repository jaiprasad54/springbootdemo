package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

@Transactional
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findOneByName(String name);
	
}
