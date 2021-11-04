package com.smilegate.server.service;

import com.smilegate.server.controller.dto.ShortenUrlRequest;
import com.smilegate.server.domain.Url;
import com.smilegate.server.global.util.DecoderUtil;
import com.smilegate.server.global.util.EncoderUtil;
import com.smilegate.server.global.util.UrlGenerator;
import com.smilegate.server.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final EncoderUtil encoder;
    private final DecoderUtil decoder;
    private final UrlGenerator urlGenerator;


    @Transactional
    public String shortenUrl(ShortenUrlRequest dto){
        Optional<Url> savedUrl = urlRepository.findByOriginUrl(dto.getOriginUrl());
        if (savedUrl.isPresent()) {
            long id = savedUrl.get().getId();
            String encodedPath = encoder.encode(String.valueOf(id));
            return urlGenerator.generateUrl(encodedPath);
        }

        Url url = urlRepository.save(dto.toEntity());
        long id = url.getId();

        String encodedPath = encoder.encode(String.valueOf(id));
        return urlGenerator.generateUrl(encodedPath);
    }

}
