package com.example.interbank.serviceImpl;

import com.example.interbank.Repository.ExchangeRecordRepository;
import com.example.interbank.model.ExchangeRateResponse;
import com.example.interbank.model.ExchangeRecord;
import com.example.interbank.model.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CurrencyService {


    private final WebClient webClient;


    private final ExchangeRecordRepository repository;

    @Autowired
    public CurrencyService(WebClient.Builder webClientBuilder, ExchangeRecordRepository repository) {
        this.webClient = webClientBuilder.baseUrl("https://open.er-api.com/v6/latest").build();
        this.repository = repository;
    }

    public Mono<ExchangeResponse> convertCurrency(Double amount, String sourceCurrency, String targetCurrency) {
        return webClient.get()
                .uri("/{baseCurrency}", sourceCurrency)
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .flatMap(response -> {
                    Double exchangeRate = response.getRates().get(targetCurrency);
                    Double exchangedAmount = amount * exchangeRate;

                    ExchangeRecord record = new ExchangeRecord(amount, sourceCurrency, targetCurrency, exchangedAmount, exchangeRate);
                    return repository.save(record)
                            .map(savedRecord -> new ExchangeResponse(amount, exchangedAmount, sourceCurrency, targetCurrency, exchangeRate));
                });
    }





    public Flux<ExchangeRecord> findAll() {
        return repository.findAll();
    }
}