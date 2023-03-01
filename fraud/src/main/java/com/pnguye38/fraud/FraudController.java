package com.pnguye38.fraud;

import com.pnguye38.client.fraud.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/fraud-check")
public class FraudController {
    private final FraudService fraudService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudulentCustomer(@PathVariable("customerId") Long customerId){
        log.info("Fraudulent check for customer {} ", customerId);
        return new FraudCheckResponse(fraudService.checkFraudulentCustomer(customerId));
    }
}
