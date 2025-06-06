package com.example.weather_api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Day {
        private String datetime;
        private double tempmax;
        private double tempmin;
        private double temp;
        private double feelslikemax;
        private double feelslikemin;
        private double feelslike;
        private double humidity;
        private double snow;
        private double snowdepth;
        private double windgust;
        private double windspeed;
        private double winddir;
        private double uvindex;
        private String conditions;
        private String description;
}
