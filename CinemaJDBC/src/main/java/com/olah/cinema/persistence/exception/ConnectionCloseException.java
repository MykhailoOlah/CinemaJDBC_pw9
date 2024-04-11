package com.olah.cinema.persistence.exception;
public class ConnectionCloseException extends RuntimeException {

	public ConnectionCloseException(String message) {
		super(message);
	}
}
