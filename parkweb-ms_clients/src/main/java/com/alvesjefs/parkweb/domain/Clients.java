package com.alvesjefs.parkweb.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTS")
public class Clients implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private Double incomeMouth;
	private Instant birthDate;
	private Integer children;

	@ManyToMany
	@JoinTable(
	name = "TB_CLIENTS_PRODUCTS", 
	joinColumns = @JoinColumn(name = "CLIENT_ID"), 
	inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private Set<Products> products = new HashSet<>();

	public Clients() {
	}

	public Clients(Long id, String name, String cpf, Double incomeMouth, Instant birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.incomeMouth = incomeMouth;
		this.birthDate = birthDate;
		this.children = children;
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

	@JoinColumn(unique = true)
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

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Set<Products> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clients [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", incomeMouth=");
		builder.append(incomeMouth);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", children=");
		builder.append(children);
		builder.append("]");
		return builder.toString();
	}

}
