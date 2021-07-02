package com.example.WeatherAPIApp.configuration;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import com.example.WeatherAPIApp.utils.DateUtils;
import com.example.WeatherAPIApp.constants.GlobalConstant;

public class ClearCache {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(ClearCache.class);

	/** Cache clear time maintained in milli seconds. */

	@CacheEvict(value = "weatherdetails", allEntries = true)
	@Scheduled(fixedDelayString = "${cache-clear-interval}")
	public void cacheEvict() {
		logger.info("Cache Cleared at {} ",
				DateUtils.convertDateToString(new Date(), GlobalConstant.DD_MM_YYYY_HH_MM_SS));
	}

}
