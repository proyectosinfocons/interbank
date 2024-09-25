package com.example.interbank.controller;


import com.example.interbank.model.ExchangeRecord;
import com.example.interbank.model.ExchangeRequest;
import com.example.interbank.model.ExchangeResponse;
import com.example.interbank.serviceImpl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public Mono<ExchangeResponse> convert(@RequestBody ExchangeRequest request, ServerWebExchange exchange) {
        return currencyService.convertCurrency(request.getAmount(), request.getSourceCurrency(), request.getTargetCurrency());
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<ExchangeRecord>>> listar(){

        Flux<ExchangeRecord> rateFlux = currencyService.findAll();

        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rateFlux)
        );
    }
}