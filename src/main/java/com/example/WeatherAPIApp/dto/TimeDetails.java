package com.example.WeatherAPIApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeDetails {
	@JsonProperty("lat")
	private double lat;
	@JsonProperty("lon")
	private double lon;
	@JsonProperty("timezone")
	private String timezone;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public TimeDetails(double lat, double lon, String timezone) {
		this.lat = lat;
		this.lon = lon;
		this.timezone = timezone;
	}

	public TimeDetails() {
	}

}
