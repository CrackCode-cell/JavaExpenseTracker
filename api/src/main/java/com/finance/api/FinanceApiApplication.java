package com.finance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Personal Finance REST API.
 */
@SpringBootApplication
public class FinanceApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                FinanceApiApplication.class,
                args
        );
    }
}
