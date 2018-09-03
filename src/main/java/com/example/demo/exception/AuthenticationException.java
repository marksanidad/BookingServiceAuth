package com.example.demo.exception;

public class AuthenticationException extends RuntimeException {

	private final String message;

	public AuthenticationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
