package com.smilegate.server.global.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerUrlGenerator implements UrlGenerator{

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    @Override
    public String generateUrl(String path){
        return "http://" + host + ":" + port + "/api/" + path;
    }
}
