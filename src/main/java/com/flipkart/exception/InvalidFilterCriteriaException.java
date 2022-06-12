package com.flipkart.exception;

public class InvalidFilterCriteriaException extends Exception {

	public InvalidFilterCriteriaException() {
		super();
	}

	public InvalidFilterCriteriaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidFilterCriteriaException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFilterCriteriaException(String message) {
		super(message);
	}

	public InvalidFilterCriteriaException(Throwable cause) {
		super(cause);
	}

	
}
