package com.smilegate.server.controller.dto;

import com.smilegate.server.domain.Url;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Getter
public class ShortenUrlRequest {


    @URL
    @Length(min=1, max=1000)
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
