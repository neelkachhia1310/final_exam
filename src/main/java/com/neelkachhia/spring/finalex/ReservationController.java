package com.neelkachhia.spring.finalex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable String id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		return reservation.orElse(null);
	}

	@PostMapping
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@PutMapping("/{id}")
	public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation updatedReservation) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		if (optionalReservation.isPresent()) {
			Reservation reservation = optionalReservation.get();
			reservation.setDetails(updatedReservation.getDetails());
			reservation.setTicketNumber(updatedReservation.getTicketNumber());
			reservation.setDate(updatedReservation.getDate());
			return reservationRepository.save(reservation);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public String deleteReservation(@PathVariable String id) {
		reservationRepository.deleteById(id);
		return "Reservation with ID " + id + " deleted.";
	}
}
