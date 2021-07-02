package com.example.WeatherAPIApp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weatherdetails")
public class WeatherAPIModel {
	
	@Id
	private String name;
	private Integer cod;
	private double temp;
	private int pressure;
	private int humidity;
	private double temp_min;
	private double temp_max;
    public Date searchTimestamp;
	 
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
	public Date getSearchTimestamp() {
		return searchTimestamp;
	}
	public void setSearchTimestamp(Date searchTimestamp) {
		this.searchTimestamp = searchTimestamp;
	}
	public WeatherAPIModel() {
	}
	
	public WeatherAPIModel(String name, Integer cod, double temp, int pressure, int humidity, double temp_min,
			double temp_max) {
		this.name = name;
		this.cod = cod;
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	
	
}
