package com.example.weather_api.services;

import com.example.weather_api.ExternalApiException;
import com.example.weather_api.domain.WeatherProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiService {
    private final WebClient webClient;

    @Value("${apiKey}")
    private String API_KEY;

    public WeatherProperties getData(String location) {
        String formattedLocation= StringUtils.capitalize(location);
        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                            .path("/{location}")
                            .queryParam("key", API_KEY)
                            .build(location)
                )
                .retrieve()
                .bodyToMono(WeatherProperties.class)
                .onErrorMap(WebClientResponseException.class, e -> {
                    return new ExternalApiException("City with name %s was not found".formatted(formattedLocation));
                })
                .doOnError(e -> {
                    if (e instanceof WebClientResponseException apiException) {
                        log.error("Weather API error: {}", apiException.getResponseBodyAsString());
                    }
                })
                .block();
    }
}
