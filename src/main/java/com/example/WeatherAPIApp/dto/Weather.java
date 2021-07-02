package com.example.WeatherAPIApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
	@JsonProperty("id")
	private int id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("icon")
	private String icon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Weather() {
	}

	public Weather(int id, String description, String icon) {

		this.id = id;
		this.description = description;
		this.icon = icon;
	}

}
