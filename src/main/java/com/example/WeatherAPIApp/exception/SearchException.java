package com.example.WeatherAPIApp.exception;

import java.io.Serializable;

public class SearchException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchException(String message) {
		super(message);
	}
}
