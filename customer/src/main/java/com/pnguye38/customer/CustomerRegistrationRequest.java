package com.pnguye38.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
