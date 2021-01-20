package com.alvesjefs.parkweb.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alvesjefs.parkweb.services.exceptions.CannotBeDelete;
import com.alvesjefs.parkweb.services.exceptions.IdNotFoundException;
import com.alvesjefs.parkweb.services.exceptions.NameNotFoundExceptions;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<StandardError> idNotfound(IdNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not found!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(NameNotFoundExceptions.class)
	public ResponseEntity<StandardError> nameNotFound(NameNotFoundExceptions e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not fond!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(CannotBeDelete.class)
	public ResponseEntity<StandardError> deleteCategory(CannotBeDelete e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Category cannot be delete!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
