package com.smilegate.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class Controller {

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String originUrl){
        return "shorten url";
    }

    @GetMapping("/{url}")
    public String redirectToOriginUrl(@PathVariable("url") String url){
        return "origin url";
    }
}
