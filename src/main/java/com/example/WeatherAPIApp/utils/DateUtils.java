package com.example.WeatherAPIApp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.example.WeatherAPIApp.constants.GlobalConstant;

public class DateUtils {

	DateUtils() {

	}

	public static String convertDateToString(Date conversionDate, String format) {
		String dateString = null;
		if (null != conversionDate) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateString = sdf.format(conversionDate);
		}
		return dateString;
	}

	public static String convertTimeZoneToString(String zoneName, String format) {
		String timeZone = null;
		if (null != zoneName) {
			TimeZone tz = TimeZone.getTimeZone(zoneName);
			DateFormat df = new SimpleDateFormat(format);
			df.setTimeZone(tz);
			timeZone = df.format(new Date());
		}
		return timeZone;
	}
}
