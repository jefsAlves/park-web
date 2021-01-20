package com.alvesjefs.parkweb.services.exceptions;

import java.io.Serializable;

public class IdNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
	}

	public IdNotFoundException(String msg) {
		super(msg);
	}

}
