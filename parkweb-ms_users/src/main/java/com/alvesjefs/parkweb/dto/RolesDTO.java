package com.alvesjefs.parkweb.dto;

import java.io.Serializable;

import com.alvesjefs.parkweb.domain.Roles;

public class RolesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String roleName;

	public RolesDTO() {
	}

	public RolesDTO(String roleName) {
		this.roleName = roleName;
	}

	public RolesDTO(Roles roles) {
		roleName = roles.getRoleName();
	}

	public String getroleName() {
		return roleName;
	}

	public void setName(String roleName) {
		this.roleName = roleName;
	}

}
