package com.banking.siigroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.siigroup.entity.Role;
import com.banking.siigroup.service.RoleService;

@RequestMapping("/role")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/")
	public ResponseEntity<List<Role>> getAll() {
		List<Role> roles = roleService.getAll();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}

}
