package com.pnguye38.client.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class FraudCheckResponse {
    boolean isFraudulentCustomer;
}
