package com.alvesjefs.parkweb.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.parkweb.domain.Users;

public class UsersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;

	private Set<RolesDTO> roles = new HashSet<>();

	public UsersDTO() {
	}

	public UsersDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UsersDTO(Users users) {
		id = users.getId();
		name = users.getName();
		email = users.getEmail();
		password = users.getPassword();
		roles = users.getRoles().stream().map(x -> new RolesDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<RolesDTO> getRoles() {
		return roles;
	}

}
