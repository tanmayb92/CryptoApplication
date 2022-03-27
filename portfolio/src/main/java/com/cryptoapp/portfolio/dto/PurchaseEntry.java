package com.cryptoapp.portfolio.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseEntry extends RepresentationModel<PurchaseEntry>{

	@Id
	@GeneratedValue
	private Long id;

	private String coinName;

	private String purchaseDate;

	private Long orderId;

	private Double amount;

	private Double price;

	private Double transactionFee;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;

	public PurchaseEntry() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(Double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "PurchaseEntry [id=" + id + ", coinName=" + coinName + ", purchaseDate=" + purchaseDate + ", orderId="
				+ orderId + ", amount=" + amount + ", price=" + price + ", transactionFee=" + transactionFee + "]";
	}

}
