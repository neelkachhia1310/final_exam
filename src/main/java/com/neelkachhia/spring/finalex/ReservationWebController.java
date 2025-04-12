package com.neelkachhia.spring.finalex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ReservationWebController {

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping("/reservation-form")
	public String showForm(Model model) {
		model.addAttribute("reservation", new Reservation());
		return "reservation_form";
	}

	@PostMapping("/submit-reservation")
	public String submitReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "reservation_form";
		}

		reservationRepository.save(reservation);
		model.addAttribute("message", "Reservation saved successfully!");
		model.addAttribute("reservation", new Reservation());
		return "reservation_form";
	}

}