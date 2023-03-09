package com.pnguye38.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.pnguye38.customer",
                "com.pnguye38.client",
                "com.pnguye38.amqp"
        }
)
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
