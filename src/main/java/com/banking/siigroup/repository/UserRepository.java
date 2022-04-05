package com.banking.siigroup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.banking.siigroup.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findUserByUsername(String username);

}
