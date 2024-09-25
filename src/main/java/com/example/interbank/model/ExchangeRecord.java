package com.example.interbank.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "exchange_rates")
public class ExchangeRecord {
    @Id
    private String id;
    private Double amount;
    private String sourceCurrency;
    private String targetCurrency;
    private Double exchangedAmount;
    private Double exchangeRate;


    public ExchangeRecord(Double amount, String sourceCurrency, String targetCurrency, Double exchangedAmount, Double exchangeRate) {
        this.amount = amount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangedAmount = exchangedAmount;
        this.exchangeRate = exchangeRate;
    }


    public ExchangeRecord(String id, Double amount, String sourceCurrency, String targetCurrency, Double exchangedAmount, Double exchangeRate) {
        this.id = id;
        this.amount = amount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangedAmount = exchangedAmount;
        this.exchangeRate = exchangeRate;
    }

    public ExchangeRecord() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getExchangedAmount() {
        return exchangedAmount;
    }

    public void setExchangedAmount(Double exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}