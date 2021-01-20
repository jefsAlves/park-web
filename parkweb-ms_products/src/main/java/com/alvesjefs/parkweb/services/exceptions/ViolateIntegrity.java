package com.alvesjefs.parkweb.services.exceptions;

import java.io.Serializable;

public class ViolateIntegrity extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public ViolateIntegrity() {
	}

	public ViolateIntegrity(String msg) {
		super(msg);
	}

}
