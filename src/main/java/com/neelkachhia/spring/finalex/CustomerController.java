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
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.orElse(null);
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable String id, @RequestBody Customer updatedCustomer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setAddress(updatedCustomer.getAddress());
			customer.setReservation(updatedCustomer.getReservation());
			customer.setDetails(updatedCustomer.getDetails());
			return customerRepository.save(customer);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable String id) {
		customerRepository.deleteById(id);
		return "Customer with ID " + id + " has been deleted.";
	}
}
