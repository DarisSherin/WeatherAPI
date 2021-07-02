package com.example.WeatherAPIApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDetails {

	private List<Weather> weather;
	@JsonProperty("base")
	private String base;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private Integer cod;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public WeatherDetails() {
	}

	public WeatherDetails(List<Weather> weather, String base, Main main, Wind wind, String name, Integer cod) {
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.wind = wind;
		this.name = name;
		this.cod = cod;
	}

}
