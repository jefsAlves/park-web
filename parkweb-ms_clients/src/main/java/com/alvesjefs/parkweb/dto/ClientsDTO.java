package com.alvesjefs.parkweb.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.parkweb.domain.Clients;

public class ClientsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private Double incomeMouth;
	private Instant birthDate;
	private Integer children;

	private Set<ProductsDTO> products = new HashSet<>();

	public ClientsDTO() {
	}

	public ClientsDTO(Long id, String name, String cpf, Double incomeMouth, Instant birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.incomeMouth = incomeMouth;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientsDTO(Clients clients) {
		id = clients.getId();
		name = clients.getName();
		cpf = clients.getCpf();
		incomeMouth = clients.getIncomeMouth();
		birthDate = clients.getBirthDate();
		children = clients.getChildren();
		products = clients.getProducts().stream().map(x -> new ProductsDTO(x)).collect(Collectors.toSet());
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncomeMouth() {
		return incomeMouth;
	}

	public void setIncomeMouth(Double incomeMouth) {
		this.incomeMouth = incomeMouth;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public Set<ProductsDTO> getProducts() {
		return products;
	}

}
