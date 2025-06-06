package com.example.weather_api.services;


import com.example.weather_api.domain.Day;
import com.example.weather_api.domain.WeatherProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static java.lang.Math.round;


@Service
@RequiredArgsConstructor
public class WeatherService {
    private final ApiService apiService;

    @Cacheable(value="WEATHER_CACHE", key="#location")
    public WeatherProperties getWeatherByLocation(String location) {
        var weatherProperties =  apiService.getData(location);
        for (Day day : weatherProperties.getDays()) {
            day.setTempmax(convertFahrenheitToCelsius(day.getTempmax()));
            day.setTempmin(convertFahrenheitToCelsius(day.getTempmin()));
            day.setTemp(convertFahrenheitToCelsius(day.getTemp()));
            day.setFeelslikemax(convertFahrenheitToCelsius(day.getFeelslikemax()));
            day.setFeelslikemin(convertFahrenheitToCelsius(day.getFeelslikemin()));
            day.setFeelslike(convertFahrenheitToCelsius(day.getFeelslike()));
        }
        return weatherProperties;
    }

    public static double convertFahrenheitToCelsius(double tempFahrenheit) {
        return round((tempFahrenheit-32)/1.8);
    }

}
