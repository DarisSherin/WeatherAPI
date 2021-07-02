package com.example.WeatherAPIApp.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WeatherAPIApp.dto.Main;
import com.example.WeatherAPIApp.dto.Response;
import com.example.WeatherAPIApp.dto.TimeResponse;
import com.example.WeatherAPIApp.dto.Weather;
import com.example.WeatherAPIApp.dto.WeatherAPIResponse;
import com.example.WeatherAPIApp.dto.WeatherDetails;
import com.example.WeatherAPIApp.dto.Wind;
import com.example.WeatherAPIApp.model.WeatherAPIModel;
import com.example.WeatherAPIApp.repository.WeatherAPIRepository;
import com.example.WeatherAPIApp.restClient.WeatherAPIClient;
import com.example.WeatherAPIApp.service.WeatherAPIServiceImpl;

@ExtendWith(SpringExtension.class)
public class WeatherAPIServiceTest {

	private static final Object INTERNAL_SERVER_ERROR = null;

	@InjectMocks
	WeatherAPIServiceImpl weatherService;

	@Mock
	WeatherDetails weatherDetails;

	@Mock
	WeatherAPIClient weatherClient;

	@Mock
	WeatherAPIRepository weatherRepository;

	static Response response;

	static TimeResponse timeResponse;

	static WeatherAPIResponse weatherAPIResponse;

	static List<WeatherAPIModel> WeatherAPIModelList;

	@BeforeEach
	public void setup() {

		WeatherDetails weatherDetails = new WeatherDetails();
		List<Weather> weatherList = new ArrayList<Weather>();
		Weather weather = new Weather();
		Main main = new Main();
		Wind wind = new Wind();
		main.setTemp(287.72);
		main.setHumidity(88);
		main.setPressure(1017);
		main.setTemp_min(284.69);
		main.setTemp_max(289.25);

		wind.setDeg(0);
		wind.setSpeed(1.03);

		weather.setId(804);
		weather.setDescription("overcast clouds");
		weather.setIcon("04d");

		weatherList.add(weather);

		weatherAPIResponse.setMain(main);
		weatherAPIResponse.setWeather(weatherList);
		weatherAPIResponse.setWind(wind);
		weatherAPIResponse.setCod(200);
		weatherAPIResponse.setName("London");
		weatherAPIResponse.setDate("2021-07-02 10:24:18.166");

		response.setWeatherResponse(weatherAPIResponse);

	}

	@DisplayName("Test weather By city name service")
	@Test
	public void testCharacterById() {

		Mockito.when(weatherClient.getWeatherInfo(Mockito.anyString())).thenReturn(weatherDetails);
		Mockito.when(weatherRepository.save(Mockito.any())).thenReturn(null);
		assertEquals(weatherDetails.getCod(), weatherService.getWeatherInfo("London").getWeatherResponse().getCod());
	}
	
	@DisplayName("Test weather By wrong city name service")
	@Test
	public void testCharacterByIdException() {

		Mockito.when(weatherClient.getWeatherInfo(Mockito.anyString())).thenReturn(weatherDetails);
		Mockito.when(weatherRepository.save(Mockito.any())).thenReturn(null);
		response = weatherService.getWeatherInfo("car");
		assertEquals(response.getHttpStatus(), INTERNAL_SERVER_ERROR);
	}

}
