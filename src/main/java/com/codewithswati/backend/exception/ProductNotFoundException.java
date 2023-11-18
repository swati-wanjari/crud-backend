package com.codewithswati.backend.exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Long id) {
		super("Could not found user with the id "+id);
	}
}
