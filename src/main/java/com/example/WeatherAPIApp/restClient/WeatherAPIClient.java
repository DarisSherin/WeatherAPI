package com.example.WeatherAPIApp.restClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.WeatherAPIApp.dto.TimeDetails;
import com.example.WeatherAPIApp.dto.WeatherDetails;
import com.example.WeatherAPIApp.exception.SearchException;

@Service
public class WeatherAPIClient {

	private static final Logger logger = LoggerFactory.getLogger(WeatherAPIClient.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${weather.v1.url}")
	private String weatherAPIUrl;

	@Value("${time.v1.url}")
	private String timeAPIUrl;

	@Value("${weather.api.key}")
	private String apiKey;

	public WeatherDetails getWeatherInfo(String q) throws SearchException {

		WeatherDetails weatherDetails = new WeatherDetails();

		logger.info("RestClient to get weather details by name");
		try {
			weatherDetails = restTemplate.getForObject(weatherAPIUrl + "?q=" + q + "&appid=" + apiKey,
					WeatherDetails.class);
		} catch (Exception e) {

			throw new SearchException(e.getMessage());

		}
		return weatherDetails;
	}

	public TimeDetails getWeatherInfo(String lat, String lon) throws SearchException {
		
		logger.info("RestClient to get timezone value for the given latitude and longitude");
		
		TimeDetails timeDetails = new TimeDetails();

		try {
			timeDetails = restTemplate.getForObject(timeAPIUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey,
					TimeDetails.class);
		} catch (Exception e) {

			throw new SearchException(e.getMessage());

		}
		return timeDetails;

	}
}
