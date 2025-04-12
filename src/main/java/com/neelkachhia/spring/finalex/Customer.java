package com.neelkachhia.spring.finalex;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customers")
public class Customer {
	@Id
	private String id;
	private String address;
	private String reservation;
	private String details;

	public Customer(String id, String address, String reservation, String details) {
		super();
		this.id = id;
		this.address = address;
		this.reservation = reservation;
		this.details = details;
	}

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", address=" + address + ", reservation=" + reservation + ", details=" + details
				+ "]";
	}

}