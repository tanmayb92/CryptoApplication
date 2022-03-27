package com.cryptoapp.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cryptoapp.portfolio.dto.User;
import com.cryptoapp.portfolio.service.UserDaoService;

@RestController
public class AppController {
	
	@Autowired
	private UserDaoService userDaoService;

	@PostMapping(path = "/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		userDaoService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable Long id) {
		return userDaoService.findById(id).get();
	}
	
	
	
}
