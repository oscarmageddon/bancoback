package com.banking.siigroup.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

public class SignupDto {

	@NotBlank
	// @Size(min = 3, max = 20)
	private String username;

	private Set<String> roles;

	@NotBlank
	// @Size(min = 6, max = 40)
	private String password;

	@NotBlank
	private String fullname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Set<String> getRoles() {
		return this.roles;
	}

	public void setRole(Set<String> roles) {
		this.roles = roles;
	}

}