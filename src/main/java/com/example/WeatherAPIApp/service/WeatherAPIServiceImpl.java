package com.example.WeatherAPIApp.service;

import org.slf4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.WeatherAPIApp.constants.GlobalConstant;
import com.example.WeatherAPIApp.dto.Response;
import com.example.WeatherAPIApp.dto.TimeDetails;
import com.example.WeatherAPIApp.dto.TimeResponse;
import com.example.WeatherAPIApp.dto.WeatherAPIResponse;
import com.example.WeatherAPIApp.dto.WeatherDetails;
import com.example.WeatherAPIApp.exception.SearchException;
import com.example.WeatherAPIApp.model.WeatherAPIModel;
import com.example.WeatherAPIApp.repository.WeatherAPIRepository;
import com.example.WeatherAPIApp.restClient.WeatherAPIClient;
import com.example.WeatherAPIApp.restClient.WeatherAPIDetails;
import com.example.WeatherAPIApp.utils.DateUtils;

@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherAPIServiceImpl.class);

	@Autowired
	WeatherAPIDetails details;

	@Autowired
	WeatherAPIClient weatherClient;

	@Autowired
	WeatherAPIRepository weatherRepository;

	@Override
	public Response getWeatherInfo(String q) throws SearchException {

		logger.info("Service to get weather details by entered city name");

		WeatherDetails weatherDetails;
		WeatherAPIResponse weatherResponse = new WeatherAPIResponse();
		Response response = new Response();

		try {

			weatherDetails = details.getWeatherInfo(q, new Date());

			if (weatherDetails != null) {
				weatherResponse.setName(weatherDetails.getName());
				weatherResponse.setCod(weatherDetails.getCod());
				weatherResponse.setMain(weatherDetails.getMain());
				weatherResponse.setWeather(weatherDetails.getWeather());
				weatherResponse.setWind(weatherDetails.getWind());
				String date = DateUtils.convertDateToString(new Date(), GlobalConstant.DD_MM_YYYY_HH_MM_SS);
				weatherResponse.setDate(date);
				populateSearchDetails(weatherResponse);
			}

		} catch (SearchException e) {
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.setWeatherResponse(weatherResponse);
		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

	@Override
	public TimeResponse getTimeInfo(String lat, String lon) throws SearchException {

		TimeDetails timeDetails;
		TimeResponse timeResponse = new TimeResponse();
		String zoneName;

		try {
			timeDetails = weatherClient.getWeatherInfo(lat, lon);

			if (timeDetails != null) {
				timeResponse.setLat(timeDetails.getLat());
				timeResponse.setLon(timeDetails.getLon());
				timeResponse.setTimezone(timeDetails.getTimezone());
				zoneName = timeDetails.getTimezone();
				String cityTime = DateUtils.convertTimeZoneToString(zoneName, GlobalConstant.DD_MM_YYYY_HH_MM_SS);
				String userTime = DateUtils.convertDateToString(new Date(), GlobalConstant.DD_MM_YYYY_HH_MM_SS);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

				Date userDate = sdf.parse(userTime);
				Date cityDate = sdf.parse(cityTime);
				if (null != userDate && null != cityDate) {
					long time_difference = userDate.getTime() - cityDate.getTime();
					long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
					long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
					long minutes_difference = (time_difference / (1000 * 60)) % 60;
					long seconds_difference = (time_difference / 1000) % 60;
					timeResponse.setUserTime(userTime);
					timeResponse.setCityTime(cityTime);
					timeResponse.setTime_difference(time_difference);
					timeResponse.setDays_difference(days_difference);
					timeResponse.setHours_difference(hours_difference);
					timeResponse.setMinutes_difference(minutes_difference);
					timeResponse.setSeconds_difference(seconds_difference);
				}

			}
		} catch (ParseException e) {
			throw new SearchException(e.getMessage());

		} catch (SearchException e) {
			throw new SearchException(e.getMessage());

		}
		return timeResponse;
	}

	@Override
	public List<WeatherAPIModel> getWeatherLastSearches() {
		int pageNo = 0;
		return weatherRepository.getWeatherSearch(PageRequest.of(pageNo, GlobalConstant.NO_OF_LAST_SEARCHES));
	}

	private void populateSearchDetails(WeatherAPIResponse weatherResponse) throws SearchException {
		logger.info("Service method to save the weather details in the table");
		WeatherAPIModel weatherAPIModel = new WeatherAPIModel();

		try {
			weatherAPIModel.setName(weatherResponse.getName());
			weatherAPIModel.setCod(weatherResponse.getCod());
			weatherAPIModel.setTemp(weatherResponse.getMain().getTemp());
			weatherAPIModel.setPressure(weatherResponse.getMain().getPressure());
			weatherAPIModel.setHumidity(weatherResponse.getMain().getHumidity());
			weatherAPIModel.setTemp_min(weatherResponse.getMain().getTemp_min());
			weatherAPIModel.setTemp_max(weatherResponse.getMain().getTemp_max());
			weatherRepository.save(weatherAPIModel);
		} catch (Exception e) {
			throw new SearchException(e.getMessage());
		}

	}

}