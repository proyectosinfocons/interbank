package com.example.interbank.client;

import com.example.interbank.model.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "currencyClient", url = "https://open.er-api.com/v6/latest")
public interface CurrencyClient  {

    @GetMapping("/{baseCurrency}")
    Mono<ExchangeRateResponse> getExchangeRates(@PathVariable String baseCurrency);

}