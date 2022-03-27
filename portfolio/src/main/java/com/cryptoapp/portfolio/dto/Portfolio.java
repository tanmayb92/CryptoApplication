package com.cryptoapp.portfolio.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Portfolio  extends RepresentationModel<Portfolio>{

	@Id
	@GeneratedValue
	private Long id;

	private String portfolioName;

	private String creationDate;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "portfolio")
	private List<PurchaseEntry> purchaseEntry;

	public Portfolio() {
		// TODO Auto-generated constructor stub
	}

	public List<PurchaseEntry> getPurchaseEntry() {
		return purchaseEntry;
	}

	public void setPurchaseEntry(List<PurchaseEntry> purchaseEntry) {
		this.purchaseEntry = purchaseEntry;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
