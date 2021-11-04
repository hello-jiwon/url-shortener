package com.smilegate.server.global.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FailResponse {

    private String ErrorMessage;

    @Builder
    public FailResponse(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
