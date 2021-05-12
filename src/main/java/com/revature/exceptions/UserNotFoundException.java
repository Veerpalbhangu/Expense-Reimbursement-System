package com.revature.exceptions;

public class UserNotFoundException extends AbstractHttpException  {
	
	public UserNotFoundException(String message, int statusCode) {
		super("User not found", 404);
		
	}

}
