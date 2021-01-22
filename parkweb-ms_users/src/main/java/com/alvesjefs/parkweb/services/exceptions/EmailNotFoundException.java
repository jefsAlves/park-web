package com.alvesjefs.parkweb.services.exceptions;

import java.io.Serializable;

public class EmailNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public EmailNotFoundException() {
	}

	public EmailNotFoundException(String msg) {
		super(msg);
	}

}
