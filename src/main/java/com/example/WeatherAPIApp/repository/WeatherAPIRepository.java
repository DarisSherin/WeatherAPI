package com.example.WeatherAPIApp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.WeatherAPIApp.model.WeatherAPIModel;

@Repository
public interface WeatherAPIRepository extends JpaRepository<WeatherAPIModel,String> {
	 @Query("select NEW com.example.WeatherAPIApp.model.WeatherAPIModel( " +
	            "name,cod,temp,pressure,humidity,temp_min,temp_max) from WeatherAPIModel order by searchTimestamp desc")
	    public List<WeatherAPIModel> getWeatherSearch(Pageable pageable);
}
