package com.banking.siigroup.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.siigroup.dto.LoginDto;
import com.banking.siigroup.dto.SignupDto;
import com.banking.siigroup.entity.Role;
import com.banking.siigroup.entity.User;
import com.banking.siigroup.exception.MessageResponse;
import com.banking.siigroup.service.RoleService;
import com.banking.siigroup.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
		User user = null;
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			user = userService.getByUsername(userDetails.getUsername());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username o password incorrectos!"));
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@Valid @RequestBody SignupDto signupDto) {
		User userExists = userService.getByUsername(signupDto.getUsername());
		if (userExists != null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username ya existe!"));
		}

		User user = new User();
		user.setUsername(signupDto.getUsername());
		user.setPassword(signupDto.getPassword());
		user.setFullname(signupDto.getFullname());

		Set<String> strRoles = signupDto.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role executiveRole = roleService.getByName("EXECUTIVE");
			roles.add(executiveRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ADMIN":
					Role adminRole = roleService.getByName("ADMIN");
					roles.add(adminRole);
					break;
				default:
					Role executiveRole = roleService.getByName("EXECUTIVE");
					roles.add(executiveRole);
				}
			});
		}
		user.setRoles(roles);
		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
