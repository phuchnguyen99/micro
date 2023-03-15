package com.pnguye38.apigw.security;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("fake")
public class FakeApiAuthorizationChecker implements ApiKeyAuthorizationChecker{

    private final static Map<String, List<String>> KEYS = Map.of(
            "supersecurekey", List.of("fraud")
    );
    @Override
    public boolean isAuthorized(String key, String application) {
        return KEYS.getOrDefault(key, List.of())
                .stream()
                .anyMatch(k -> k.contains(application));
    }
}
