package com.example.WeatherAPIApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeatherAPIApp.dto.Response;
import com.example.WeatherAPIApp.dto.TimeResponse;
import com.example.WeatherAPIApp.dto.WeatherAPIResponse;
import com.example.WeatherAPIApp.model.WeatherAPIModel;
import com.example.WeatherAPIApp.service.WeatherAPIService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * The Class WeatherAPIController
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/weatherapi")
public class WeatherAPIController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherAPIController.class);

	@Autowired
	WeatherAPIService weatherService;

	@ApiOperation(value = "Get weather information for the given city", notes = "This API retrieves weather information from OpenWeatherMap")
	@GetMapping(value = "/weather")
	public ResponseEntity<WeatherAPIResponse> getWeatherInformation(
			@ApiParam(value = "city name", example = "London") @RequestParam("q") String q) {
		logger.info("Controller to get weather details by entered city name");
		Response response;
		response = weatherService.getWeatherInfo(q);
		return new ResponseEntity<>(response.getWeatherResponse(), response.getHttpStatus());
	}

	@ApiOperation(value = "Display time difference between local and entered city", notes = "This API displays time difference between user local time and entered city time from OpenWeatherMap. The time difference is calculated in parameters like milliseconds, days, hours, minutes, seconds")
	@GetMapping(value = "/time")
	public ResponseEntity<TimeResponse> getTimeInformation(
			@ApiParam(value = "Latitue", example = "33.44") @RequestParam("lat") String lat,
			@ApiParam(value = "Longitude", example = "-94.04") @RequestParam("lon") String lon) {
		logger.info("Controller to get weather details by entered city name");
		TimeResponse timeResponse;
		timeResponse = weatherService.getTimeInfo(lat, lon);
		return new ResponseEntity<>(timeResponse, HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieves weather details saved in repository", notes = "This API retrieves last 3 searches performed in weather API")
	@GetMapping(value = "/weather/lastsearches")
	public ResponseEntity<List<WeatherAPIModel>> getWeatherLastSearches() {
		logger.info("Controller to get last three searches");
		return new ResponseEntity<>(weatherService.getWeatherLastSearches(), HttpStatus.OK);
	}

}
