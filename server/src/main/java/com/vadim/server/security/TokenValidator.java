package com.vadim.server.security;

public interface TokenValidator {

    boolean validateAccessToken(String accessToken);

    boolean validateRefreshToken(String refreshToken);
}
