package com.alvesjefs.parkweb.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.parkweb.domain.Products;

public class ProductsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private Double price;

	private Set<CategoryDTO> categories = new HashSet<>();

	public ProductsDTO() {
	}

	public ProductsDTO(Long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public ProductsDTO(Products products) {
		id = products.getId();
		name = products.getName();
		description = products.getDescription();
		price = products.getPrice();
		categories = products.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toSet());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<CategoryDTO> getCategories() {
		return categories;
	}

}
