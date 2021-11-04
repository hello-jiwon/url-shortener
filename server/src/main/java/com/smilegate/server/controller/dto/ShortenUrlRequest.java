package com.smilegate.server.controller.dto;

import com.smilegate.server.domain.Url;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ShortenUrlRequest {

    private String originUrl;

    @Builder
    public ShortenUrlRequest(String originUrl) {
        this.originUrl = originUrl;
    }

    public Url toEntity(){
        return Url.builder()
                .originUrl(originUrl)
                .build();
    }
}
