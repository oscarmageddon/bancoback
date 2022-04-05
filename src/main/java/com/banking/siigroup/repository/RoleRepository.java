package com.banking.siigroup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.banking.siigroup.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	public Role findByName(String name);
}
