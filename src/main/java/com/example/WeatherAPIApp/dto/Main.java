package com.example.WeatherAPIApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Main {
	@JsonProperty("temp")
	private double temp;
	@JsonProperty("pressure")
	private int pressure;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("temp_min")
	private double temp_min;
	@JsonProperty("temp_max")
	private double temp_max;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public Main() {
	}

	public Main(double temp, int pressure, int humidity, double temp_min, double temp_max) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}

}
