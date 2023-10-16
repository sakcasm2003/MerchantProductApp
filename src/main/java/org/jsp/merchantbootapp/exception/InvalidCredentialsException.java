package org.jsp.merchantbootapp.exception;

public class InvalidCredentialsException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Merchant phone or email or password";
	}
}
