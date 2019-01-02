package com.db.exception;

public class DigitalServiceException extends BaseException {

	private static final long serialVersionUID = 2873933102762584428L;

	public DigitalServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DigitalServiceException(String message) {
		super(message);
	}

	public DigitalServiceException(Throwable cause) {
		super(cause);
	}

	public DigitalServiceException() {
	}
}
