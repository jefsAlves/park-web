package com.alvesjefs.parkweb.dto;

import java.io.Serializable;

import com.alvesjefs.parkweb.domain.Roles;

public class RolesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String roleName;

	public RolesDTO() {
	}

	public RolesDTO(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public RolesDTO(Roles roles) {
		id = roles.getId();
		roleName = roles.getRoleName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
