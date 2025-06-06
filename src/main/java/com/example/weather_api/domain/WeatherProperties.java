package com.example.weather_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherProperties {

    private String address;
    private String resolvedAddress;
    private String description;
    @JsonProperty("days")
    private List<Day> days;
}
