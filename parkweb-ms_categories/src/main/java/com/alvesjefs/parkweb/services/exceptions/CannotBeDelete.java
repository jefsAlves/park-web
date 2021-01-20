package com.alvesjefs.parkweb.services.exceptions;

import java.io.Serializable;

public class CannotBeDelete extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public CannotBeDelete() {
	}

	public CannotBeDelete(String msg) {
		super(msg);
	}
}
