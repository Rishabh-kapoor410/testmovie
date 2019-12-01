package com.movie.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "theatreId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cost;
	private LocalDateTime purchasedOn;
	private int validTime;
	private String purchasedBy;

	public Long getId() {
		return id;
	}

	public Long getCost() {
		return cost;
	}

	public LocalDateTime getPurchasedOn() {
		return purchasedOn;
	}

	public int getValidTime() {
		return validTime;
	}

	public String getPurchasedBy() {
		return purchasedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public void setPurchasedOn(LocalDateTime purchasedOn) {
		this.purchasedOn = purchasedOn;
	}

	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}

	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}

}
