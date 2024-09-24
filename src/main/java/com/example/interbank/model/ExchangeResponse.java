package com.example.interbank.model;

public class ExchangeResponse {
    private Double amount;
    private Double exchangedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private Double exchangeRate;

    // Constructor
    public ExchangeResponse(Double amount, Double exchangedAmount, String sourceCurrency, String targetCurrency, Double exchangeRate) {
        this.amount = amount;
        this.exchangedAmount = exchangedAmount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }

    // Getters y Setters
    public Double getAmount() {
        return amount;
    }

    public Double getExchangedAmount() {
        return exchangedAmount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }
}