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
@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentRepository;

	@GetMapping
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Payment getPaymentById(@PathVariable String id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return payment.orElse(null);
	}

	@PostMapping
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}

	@PutMapping("/{id}")
	public Payment updatePayment(@PathVariable String id, @RequestBody Payment updatedPayment) {
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isPresent()) {
			Payment payment = optionalPayment.get();
			payment.setAmount(updatedPayment.getAmount());
			payment.setDate(updatedPayment.getDate());
			return paymentRepository.save(payment);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public String deletePayment(@PathVariable String id) {
		paymentRepository.deleteById(id);
		return "Payment with ID " + id + " has been deleted.";
	}
}
