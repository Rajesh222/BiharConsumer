package com.db.exception;
/**
 * @author Satyam Kumar
 *
 */
public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException() {
	}

}
