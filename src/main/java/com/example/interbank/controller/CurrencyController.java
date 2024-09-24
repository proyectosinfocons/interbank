package com.example.interbank.controller;


import com.example.interbank.model.ExchangeRecord;
import com.example.interbank.model.ExchangeRequest;
import com.example.interbank.model.ExchangeResponse;
import com.example.interbank.serviceImpl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public Mono<ExchangeResponse> convert(@RequestBody ExchangeRequest request, final ServerHttpRequest req) {
        return currencyService.convertCurrency(request.getAmount(), request.getSourceCurrency(), request.getTargetCurrency());
    }


}