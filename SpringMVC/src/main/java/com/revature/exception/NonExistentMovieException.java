package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Spring Web allows you to create handlers for exceptions by using the @ResponseStatus
 * annotation and providing the response code to send back with a reason.
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="These are not the droids you're looking for.")
public class NonExistentMovieException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
