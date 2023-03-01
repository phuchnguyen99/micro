package com.pnguye38.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FraudService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public boolean checkFraudulentCustomer(Long customerId) {
        final FraudCheckHistory fraudCheckHistory =  FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
