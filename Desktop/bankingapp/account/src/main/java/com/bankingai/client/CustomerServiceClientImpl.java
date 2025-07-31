package com.bankingai.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
@RequiredArgsConstructor
public class CustomerServiceClientImpl implements CustomerServiceClient {

    @Value("${customer-service.url}")
    private String customerServiceUrl;

    private final WebClient.Builder webClientBuilder;

    @Override
    public boolean existsById(Long customerId) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri(customerServiceUrl + "/" + customerId + "/exists")
                    .retrieve()
                    .toBodilessEntity()
                    .block();
            return true;
        } catch (WebClientResponseException.NotFound ex) {
            return false;
        }
    }
}