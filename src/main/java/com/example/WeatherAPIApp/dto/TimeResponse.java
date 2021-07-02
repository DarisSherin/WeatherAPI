package com.example.WeatherAPIApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResponse {
	@JsonProperty("lat")
	private double lat;
	@JsonProperty("lon")
	private double lon;
	@JsonProperty("timezone")
	private String timezone;
	@JsonProperty("userTime")
	private String userTime;
	@JsonProperty("cityTime")
	private String cityTime;
	@JsonProperty("time_difference")
	private long time_difference;
	@JsonProperty("days_difference")
	private long days_difference;
	@JsonProperty("hours_difference")
	private long hours_difference;
	@JsonProperty("minutes_difference")
	private long minutes_difference;
	@JsonProperty("seconds_difference")
	private long seconds_difference;

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

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public String getCityTime() {
		return cityTime;
	}

	public void setCityTime(String cityTime) {
		this.cityTime = cityTime;
	}

	public long getTime_difference() {
		return time_difference;
	}

	public void setTime_difference(long time_difference) {
		this.time_difference = time_difference;
	}

	public long getDays_difference() {
		return days_difference;
	}

	public void setDays_difference(long days_difference) {
		this.days_difference = days_difference;
	}

	public long getHours_difference() {
		return hours_difference;
	}

	public void setHours_difference(long hours_difference) {
		this.hours_difference = hours_difference;
	}

	public long getMinutes_difference() {
		return minutes_difference;
	}

	public void setMinutes_difference(long minutes_difference) {
		this.minutes_difference = minutes_difference;
	}

	public long getSeconds_difference() {
		return seconds_difference;
	}

	public void setSeconds_difference(long seconds_difference) {
		this.seconds_difference = seconds_difference;
	}

	public TimeResponse() {
	}

	public TimeResponse(double lat, double lon, String timezone, String userTime, String cityTime, long time_difference,
			long days_difference, long hours_difference, long minutes_difference, long seconds_difference) {
		this.lat = lat;
		this.lon = lon;
		this.timezone = timezone;
		this.userTime = userTime;
		this.cityTime = cityTime;
		this.time_difference = time_difference;
		this.days_difference = days_difference;
		this.hours_difference = hours_difference;
		this.minutes_difference = minutes_difference;
		this.seconds_difference = seconds_difference;
	}

}
