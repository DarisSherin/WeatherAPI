package com.example.WeatherAPIApp.dto;

import org.springframework.http.HttpStatus;

public class Response {

	private WeatherAPIResponse weatherResponse;
	private HttpStatus httpStatus;

	public WeatherAPIResponse getWeatherResponse() {
		return weatherResponse;
	}

	public void setWeatherResponse(WeatherAPIResponse weatherResponse) {
		this.weatherResponse = weatherResponse;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
