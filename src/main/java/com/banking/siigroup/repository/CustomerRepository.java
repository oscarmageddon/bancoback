package com.banking.siigroup.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.banking.siigroup.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public List<Customer> findByDeleted(boolean valor);

}
