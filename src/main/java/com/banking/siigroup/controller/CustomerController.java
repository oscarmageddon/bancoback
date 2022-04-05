package com.banking.siigroup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.siigroup.entity.Customer;
import com.banking.siigroup.entity.ECategory;
import com.banking.siigroup.service.CustomerService;

@RequestMapping("/customer")
@RestController

public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
		Customer obj = customerService.save(customer);
		return new ResponseEntity<Customer>(obj, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomer() {
		List<Customer> customers = customerService.getCustomer();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		Customer customer = customerService.getById(id);
		customerService.deleteLogical(customer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable String id) {
		Customer customerFind = customerService.getById(id);
		if (customerFind != null) {
			customer.setId(id);
			customerService.save(customer);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@GetMapping("/category/")
	public ResponseEntity<ECategory[]> getAllCategory() {
		ECategory[] categories = ECategory.values();
		return new ResponseEntity<ECategory[]>(categories, HttpStatus.OK);
	}

}
