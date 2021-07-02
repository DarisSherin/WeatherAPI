package com.example.WeatherAPIApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.example.WeatherAPIApp.constants.GlobalConstant;

@Configuration
public class ApplicationConfig {
	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean(name = "restTemplate")
	RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> mc = restTemplate.getMessageConverters();
		// Add JSON message Converter
		MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(new MediaType(GlobalConstant.MEDIA_TYPE, GlobalConstant.TYPE_JSON,
				Charset.forName(GlobalConstant.FOR_NAME)));
		supportedMediaTypes.add(new MediaType(GlobalConstant.MEDIA_TYPE, GlobalConstant.TYPE_STREAM,
				Charset.forName(GlobalConstant.FOR_NAME)));
		mappingJacksonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		mc.add(mappingJacksonHttpMessageConverter);
		restTemplate.setMessageConverters(mc);
		return restTemplate;
	}
}
