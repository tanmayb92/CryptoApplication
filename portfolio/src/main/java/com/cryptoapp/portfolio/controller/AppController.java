package com.cryptoapp.portfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cryptoapp.portfolio.dto.Portfolio;
import com.cryptoapp.portfolio.dto.User;
import com.cryptoapp.portfolio.service.PortfolioDaoService;
import com.cryptoapp.portfolio.service.UserDaoService;

@RestController
public class AppController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private PortfolioDaoService portfolioDaoService;

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
	
	@PostMapping(path = "/users/{id}/portfolio")
	public ResponseEntity<User> savePortfolio(@RequestBody Portfolio portfolio, @PathVariable Long id) {
		User user = userDaoService.findById(id).get();
		portfolio.setUser(user);
		portfolioDaoService.save(portfolio);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/users/{id}/portfolio")
	public List<Portfolio> getAllUserPortfolio(@PathVariable Long id) {
		User user = userDaoService.findById(id).get();
		return user.getPortfolios();
	}
	
	@GetMapping(path = "/users/{id}/portfolio/{pid}")
	public Portfolio getUserById(@PathVariable Long id, @PathVariable Long pid) {
		return portfolioDaoService.findById(pid).get();
	}
	
	
	
}
