package com.smilegate.server.controller;

import com.smilegate.server.controller.dto.ShortenUrlRequest;
import com.smilegate.server.controller.dto.ShortenUrlResponse;
import com.smilegate.server.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public ShortenUrlResponse shortenUrl(@Valid @RequestBody final ShortenUrlRequest dto){
        String shortUrl = urlService.shortenUrl(dto);
        return ShortenUrlResponse.builder()
                .shortUrl(shortUrl)
                .build();
    }

    @GetMapping("/{url}")
    public String redirectToOriginUrl(@PathVariable("url") String url){
        return "origin url";
    }
}
