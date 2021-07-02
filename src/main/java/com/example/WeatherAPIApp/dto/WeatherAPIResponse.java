package com.example.WeatherAPIApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherAPIResponse {
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private Integer cod;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("date")
	private String date;
	private List<Weather> weather;

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

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public WeatherAPIResponse() {
	}

	@SuppressWarnings("unchecked")
	public WeatherAPIResponse(String name, Integer cod, String date, double temp, int pressure, int humidity,
			double temp_min, double temp_max, double speed, double deg,int id, String description, String icon) { 
		this.name = name;
		this.cod = cod;
		this.date = date;
		this.main = new Main();
		this.main.setTemp(temp);
		this.main.setHumidity(pressure);
		this.main.setPressure(pressure);
		this.main.setTemp_max(temp_max);
		this.main.setTemp_min(temp_min);
		this.wind = new Wind();
		this.wind.setDeg(deg);
		this.wind.setSpeed(speed);
		this.weather = (List<Weather>) new Weather();
		this.weather.get(0).setId(id);
		this.weather.get(0).setDescription(description);
		this.weather.get(0).setIcon(icon);

	}

}
