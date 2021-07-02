package com.example.WeatherAPIApp.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.WeatherAPIApp.controller.WeatherAPIController;
import com.example.WeatherAPIApp.dto.Main;
import com.example.WeatherAPIApp.dto.Response;
import com.example.WeatherAPIApp.dto.TimeResponse;
import com.example.WeatherAPIApp.dto.WeatherAPIResponse;
import com.example.WeatherAPIApp.dto.Wind;
import com.example.WeatherAPIApp.model.WeatherAPIModel;
import com.example.WeatherAPIApp.service.WeatherAPIService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherAPIController.class)
public class WeatherAPIControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	WeatherAPIService weatherService;

	static WeatherAPIModel WeatherAPIModel;

	static TimeResponse timeResponse;

	static WeatherAPIResponse weatherAPIResponse;

	static List<WeatherAPIModel> WeatherAPIModelList;

	@BeforeEach
	public void setup() {

		weatherAPIResponse = new WeatherAPIResponse();
		weatherAPIResponse.setName("London");
		weatherAPIResponse.setCod(200);
		weatherAPIResponse.setMain(new Main(288.64, 1017, 86, 287.42, 289.64));
		weatherAPIResponse.setWind(new Wind(0.45, 62));
		weatherAPIResponse.setDate("2021-06-30 01:46:54.365");

		timeResponse.setLat(33.44);
		timeResponse.setLon(-94.04);
		timeResponse.setTimezone("America/Chicago");
		timeResponse.setUserTime("2021-06-30 01:45:22.247");
		timeResponse.setCityTime("2021-06-29 15:15:22.246");
		timeResponse.setTime_difference(37800001);
		timeResponse.setDays_difference(0);
		timeResponse.setHours_difference(10);
		timeResponse.setMinutes_difference(30);
		timeResponse.setSeconds_difference(0);

		WeatherAPIModelList = new ArrayList<WeatherAPIModel>();
		WeatherAPIModelList.add(WeatherAPIModel);
	}

	@DisplayName("Display Weather details for city entered")
	@Test
	public void testGetWeatherInformation() throws Exception {

		Response response = new Response();
		response.setHttpStatus(HttpStatus.OK);
		response.setWeatherResponse(weatherAPIResponse);

		Mockito.when(weatherService.getWeatherInfo("London")).thenReturn(response);

		this.mockMvc.perform(get("/weatherapi/weather?q=London").with(httpBasic("user", "password"))).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("Cod").value("300"))
				.andExpect(jsonPath("name").value("London"));

	}

	@DisplayName("Display time difference for city entered and user local time")
	@Test
	public void testGetTimeInformation() throws Exception {

		TimeResponse timeRes = new TimeResponse();
		Mockito.when(weatherService.getTimeInfo("33.44", "-94.04")).thenReturn(timeRes);

		this.mockMvc.perform(get("/weatherapi/time?lat33.44=&lon=-94.04").with(httpBasic("user", "password")))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("timezone").value("America/Chicago"))
				.andExpect(jsonPath("cityTime").value("2021-06-29 15:15:22.246"));
	}

	@DisplayName("Test last search weather details fetched from weather api")
	@Test
	public void testLastSearchResultsAPI() throws Exception {

		Mockito.when(weatherService.getWeatherLastSearches()).thenReturn(WeatherAPIModelList);

		this.mockMvc.perform(get("/weatherapi/weather/lastsearches").with(httpBasic("user", "password"))).andDo(print())
				.andExpect(status().isOk());
	}

}
