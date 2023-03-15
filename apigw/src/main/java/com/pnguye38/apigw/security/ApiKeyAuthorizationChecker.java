package com.pnguye38.apigw.security;

public interface ApiKeyAuthorizationChecker {
    boolean isAuthorized(String key, String application);
}
