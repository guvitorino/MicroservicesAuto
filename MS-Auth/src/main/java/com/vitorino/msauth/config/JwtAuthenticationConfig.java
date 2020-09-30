package com.vitorino.msauth.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("/login")
    private String url;

    @Value("Authorization")
    private String header;

    @Value("Bearer")
    private String prefix;

    @Value("${msauth.expiration}")
    private int expiration; // default 24 hours

    @Value("V1tTo3009")
    private String secret;
}