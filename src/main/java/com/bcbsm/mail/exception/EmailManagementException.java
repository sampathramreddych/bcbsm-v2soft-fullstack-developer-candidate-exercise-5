package com.bcbsm.mail.exception;

public class EmailManagementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailManagementException() {
		super();
	}

	public EmailManagementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailManagementException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailManagementException(String message) {
		super(message);
	}

	public EmailManagementException(Throwable cause) {
		super(cause);
	}

}
