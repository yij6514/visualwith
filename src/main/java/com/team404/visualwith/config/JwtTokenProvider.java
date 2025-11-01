package com.team404.visualwith.config;

import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenProvider {
    private Key key;
}
