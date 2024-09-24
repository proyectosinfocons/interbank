package com.example.interbank.serviceImpl;

import com.example.interbank.Repository.ExchangeRecordRepository;
import com.example.interbank.client.CurrencyClient;
import com.example.interbank.model.ExchangeRateResponse;
import com.example.interbank.model.ExchangeRecord;
import com.example.interbank.model.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class CurrencyService {

    @Autowired
    private CurrencyClient currencyClient;

    @Autowired
    private ExchangeRecordRepository repository;

    public Mono<ExchangeResponse> convertCurrency(Double amount, String sourceCurrency, String targetCurrency) {
        return currencyClient.getExchangeRates(sourceCurrency)
                .flatMap(response -> {
                    Double exchangeRate = response.getRates().get(targetCurrency);
                    Double exchangedAmount = amount * exchangeRate;

                    ExchangeRecord record = new ExchangeRecord(amount, sourceCurrency, targetCurrency, exchangedAmount, exchangeRate);
                    return repository.save(record).map(savedRecord -> new ExchangeResponse(amount, exchangedAmount, sourceCurrency, targetCurrency, exchangeRate));
                });
    }
}