package com.example.weather_api.controller;

import com.example.weather_api.domain.WeatherProperties;
import com.example.weather_api.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{location}")
    public WeatherProperties getWeather(@PathVariable String location) {
        return weatherService.getWeatherByLocation(location.toLowerCase());
    }
}
