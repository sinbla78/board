package com.example.socket.global.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor
@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String secretKey;
    private final Long accessExp = 10000L;
    private final Long refreshExp = 604800L;//리프레쉬 토큰의 만료시간은 1주일
    private final String header;
    private final String prefix;


}
