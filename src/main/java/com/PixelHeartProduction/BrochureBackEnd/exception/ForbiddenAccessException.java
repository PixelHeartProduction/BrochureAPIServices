package com.PixelHeartProduction.BrochureBackEnd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class ForbiddenAccessException extends Exception{
	private static final long serialVersionUID = 1L;
	public ForbiddenAccessException(String message) {
		super(message);
	}
}
