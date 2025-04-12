package com.neelkachhia.spring.finalex;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Document("reservations")
public class Reservation {
	@Id
	private String id;

	@NotEmpty(message = "Customer details cannot be empty")
	private String details;

	@NotEmpty(message = "Ticket number is required")
	@Pattern(regexp = "\\d{5,10}", message = "Ticket number must be 5-10 digits")
	private String ticketNumber;

	@NotEmpty(message = "Date is required")
	private String date;

	public Reservation() {
		super();
	}

	public Reservation(String id, String details, String ticketNumber, String date) {
		super();
		this.id = id;
		this.details = details;
		this.ticketNumber = ticketNumber;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", details=" + details + ", ticketNumber=" + ticketNumber + ", date=" + date
				+ "]";
	}

}