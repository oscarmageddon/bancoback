package com.banking.siigroup.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.siigroup.entity.Role;
import com.banking.siigroup.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role getByName(String name) {
		return roleRepository.findByName(name);
	}

	public List<Role> getAll() {
		List<Role> listRole = roleRepository.findAll();
		return listRole;
	}

}
