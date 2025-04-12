package com.neelkachhia.spring.finalex;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("payments")
public class Payment {
	@Id
	private String id;
	private int amount;
	private String date;

	public Payment() {
		super();
	}

	public Payment(String id, int amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", date=" + date + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}