package com.banking.siigroup.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.siigroup.entity.Customer;
import com.banking.siigroup.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getCustomer() {
		List<Customer> customers = customerRepository.findByDeleted(false);
		return customers;
	}

	public void deleteLogical(Customer customer) {
		customer.setDeleted(true);
		customerRepository.save(customer);
	}

	public Customer getById(String id) {
		Optional<Customer> obj = customerRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

}
