package com.cryptoapp.portfolio.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cryptoapp.portfolio.dto.Portfolio;
import com.cryptoapp.portfolio.dto.PurchaseEntry;
import com.cryptoapp.portfolio.dto.User;
import com.cryptoapp.portfolio.service.PortfolioDaoService;
import com.cryptoapp.portfolio.service.PurchaseEntryDaoService;
import com.cryptoapp.portfolio.service.UserDaoService;

@RestController
public class AppController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private PortfolioDaoService portfolioDaoService;
	
	@Autowired
	private PurchaseEntryDaoService entryDaoService;

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
		
		Link newlyCreatedLink = linkTo(methodOn(AppController.class).getAllUserPortfolio(id)).withRel("user_all_portfolios");
		portfolio.add(newlyCreatedLink);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/users/{id}/portfolio")
	public List<Portfolio> getAllUserPortfolio(@PathVariable Long id) {
		User user = userDaoService.findById(id).get();
		return user.getPortfolios();
	}
	
	@GetMapping(path = "/users/{id}/portfolio/{pid}")
	public Portfolio getPortfolioById(@PathVariable Long id, @PathVariable Long pid) {
		return portfolioDaoService.findById(pid).get();
	}
	
	@PostMapping(path = "/users/{id}/portfolio/{pid}/entry")
	public ResponseEntity<PurchaseEntry> savePurchase(@RequestBody PurchaseEntry purchaseEntry, @PathVariable Long id,@PathVariable Long pid) {
		Portfolio portfolio = portfolioDaoService.findById(pid).get();
		purchaseEntry.setPortfolio(portfolio);
		entryDaoService.save(purchaseEntry);
		
		Link newlyCreatedLink = linkTo(methodOn(AppController.class).getAllPortfolioEntries(id,pid)).withRel("all_portfolio_entries");
//		return ResponseEntity.created(new URI(newlyCreatedLink.getHref())).build();
		purchaseEntry.add(newlyCreatedLink);
		
		return new ResponseEntity<PurchaseEntry>(purchaseEntry, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/users/{id}/portfolio/{pid}/entry")
	public List<PurchaseEntry> getAllPortfolioEntries(@PathVariable Long id, @PathVariable Long pid) {
		return portfolioDaoService.findById(pid).get().getPurchaseEntry();
	}
	
	@GetMapping(path = "/users/{id}/portfolio/{pid}/entry/{eid}")
	public PurchaseEntry getEntryById(@PathVariable Long id, @PathVariable Long pid, @PathVariable Long eid) {
		return entryDaoService.findById(eid).get();
	}
	
	
	
}
