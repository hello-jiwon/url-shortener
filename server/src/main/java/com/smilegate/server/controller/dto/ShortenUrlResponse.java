package com.smilegate.server.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ShortenUrlResponse {

    private String shortUrl;

    @Builder
    public ShortenUrlResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
