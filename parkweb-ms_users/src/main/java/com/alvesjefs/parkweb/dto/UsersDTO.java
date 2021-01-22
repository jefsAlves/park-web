package com.alvesjefs.parkweb.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.parkweb.domain.Users;

public class UsersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String password;

	private Set<RolesDTO> rolesDTO = new HashSet<>();

	public UsersDTO() {
	}

	public UsersDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UsersDTO(Users users) {
		name = users.getName();
		email = users.getEmail();
		password = users.getPassword();
		rolesDTO = users.getRoles().stream().map(x -> new RolesDTO(x)).collect(Collectors.toSet());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RolesDTO> getRolesDTO() {
		return rolesDTO;
	}

}