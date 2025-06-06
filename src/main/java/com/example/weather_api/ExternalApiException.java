package com.example.weather_api;

import lombok.Getter;
@Getter
public class ExternalApiException extends RuntimeException {
    private final String message;

    public ExternalApiException(String message) {
        this.message = message;
    }
}
