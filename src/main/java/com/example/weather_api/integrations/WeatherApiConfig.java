package com.example.weather_api.integrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherApiConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
            return builder
                    .baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/")
                    .build();
    }
}
