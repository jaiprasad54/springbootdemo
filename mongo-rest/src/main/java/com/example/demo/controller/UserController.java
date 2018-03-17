package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> getAll() {
		List<User> usersList = userRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("total", usersList.size());
		dataMap.put("status", "1");
		dataMap.put("statusCode", "200");
		dataMap.put("data", usersList);
		return dataMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> create(@RequestBody User user) {
		try {
		User userInst = userRepository.insert(user);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", userInst);
		dataMap.put("status", "1");
		dataMap.put("statusCode", "200");
		return ResponseEntity.ok(dataMap);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Map<String, Object>> get(@PathVariable String id) {
		User userInst = userRepository.findOne(id);
		
		if(userInst==null) {			
			return ResponseEntity.notFound().build();			
		}
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", userInst);
		dataMap.put("status", "1");
		dataMap.put("statusCode", "200");
		return ResponseEntity.ok(dataMap);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> update(@PathVariable String id, @RequestBody User user) {
		if(!userRepository.exists(id)) {
			return ResponseEntity.notFound().build();	
		}
		user.setId(id);
		User userInst = userRepository.save(user);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", userInst);
		dataMap.put("status", "1");
		dataMap.put("statusCode", "200");
		return ResponseEntity.ok(dataMap);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		if(!userRepository.exists(id)) {
			return ResponseEntity.notFound().build();	
		}
		
		try {
		userRepository.delete(id);
		return ResponseEntity.noContent().build();
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();			
		}
	}
	
}
