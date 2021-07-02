package com.example.WeatherAPIApp.configuration;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom Annotation for Caching weather Information
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Cacheable(cacheNames = "weatherdetails", sync = true)
public @interface CacheAnnotation {

}
