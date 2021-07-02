package com.example.WeatherAPIApp.restClient;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.WeatherAPIApp.configuration.CacheAnnotation;
import com.example.WeatherAPIApp.dto.WeatherDetails;

@Component
public class WeatherAPIDetails {
	private static final Logger logger = LoggerFactory.getLogger(WeatherAPIDetails.class);
	@Autowired
	WeatherAPIClient weatherClient;

	@CacheAnnotation
	public WeatherDetails getWeatherInfo(String q, Date currentDate) {
		logger.info("Method to cache the response");
		return weatherClient.getWeatherInfo(q);
	}
}
