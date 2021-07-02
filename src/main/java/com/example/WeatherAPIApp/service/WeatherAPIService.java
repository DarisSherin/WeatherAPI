package com.example.WeatherAPIApp.service;

import java.util.List;

import com.example.WeatherAPIApp.dto.Response;
import com.example.WeatherAPIApp.dto.TimeResponse;
import com.example.WeatherAPIApp.model.WeatherAPIModel;

public interface WeatherAPIService {

	Response getWeatherInfo(String q);

	TimeResponse getTimeInfo(String lat, String lon);

	List<WeatherAPIModel> getWeatherLastSearches();

}
