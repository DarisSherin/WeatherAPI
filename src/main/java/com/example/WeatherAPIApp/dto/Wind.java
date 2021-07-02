package com.example.WeatherAPIApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
	@JsonProperty("speed")
	private double speed;
	@JsonProperty("deg")
	private double deg;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	public Wind() {
	}

	public Wind(double speed, double deg) {
		this.speed = speed;
		this.deg = deg;
	}

}
