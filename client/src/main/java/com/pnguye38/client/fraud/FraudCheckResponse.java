package com.pnguye38.client.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FraudCheckResponse {
    boolean isFraudulentCustomer;
}
