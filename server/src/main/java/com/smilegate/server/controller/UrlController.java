package com.smilegate.server.controller;

import com.smilegate.server.controller.dto.ShortenUrlRequest;
import com.smilegate.server.controller.dto.ShortenUrlResponse;
import com.smilegate.server.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UrlController {

    private final UrlService urlService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shorten")
    public ShortenUrlResponse shortenUrl(@Valid @RequestBody final ShortenUrlRequest dto){
        String shortUrl = urlService.shortenUrl(dto);
        return ShortenUrlResponse.builder()
                .shortUrl(shortUrl)
                .build();
    }

    @GetMapping("/{shortPath}")
    public void redirectToOriginUrl(@PathVariable("shortPath") String shortPath, HttpServletResponse httpServletResponse) throws IOException {
        String originUrl = urlService.getOriginUrl(shortPath);
        httpServletResponse.sendRedirect(originUrl);
    }
}
