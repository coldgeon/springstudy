package com.kakaoLogin.studyKakaoLogin.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthTokensGenerator {
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRES_IN_HOURS = 3600 * 1000; //1시간
    private static final long REFRESH_TOKEN_EXPIRES_IN_HOURS = 3600 * 1000 * 24 * 14; //14일

    private final JwtTokenProvider jwtTokenProvider;
    //id 받아 Access Token 생성
    public AuthTokens generate(String uid) {
        long now = (new Date()).getTime();
        Date accessTokenExpiredAt = new Date(now + ACCESS_TOKEN_EXPIRES_IN_HOURS);
        Date refreshTokenExpiredAt = new Date(now + REFRESH_TOKEN_EXPIRES_IN_HOURS);

        //String subject = email.toString();
        String accessToken = jwtTokenProvider.accessTokenGenerate(uid, accessTokenExpiredAt);
        String refreshToken = jwtTokenProvider.refreshTokenGenerate(refreshTokenExpiredAt);

        return AuthTokens.of(accessToken, refreshToken, BEARER_TYPE, ACCESS_TOKEN_EXPIRES_IN_HOURS / 1000L);
    }


}
