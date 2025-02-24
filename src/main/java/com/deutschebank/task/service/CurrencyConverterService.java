package com.deutschebank.task.service;

import com.deutschebank.task.model.ExchangeRate;
import com.deutschebank.task.model.Payment;

import java.time.LocalDateTime;
import java.util.*;

import static com.deutschebank.task.constant.AppConstant.*;

public class CurrencyConverterService {
    private final Map<String, NavigableMap<LocalDateTime, Double>> ratesByCurrency = new HashMap<>();

    public CurrencyConverterService(List<ExchangeRate> exchangeRates) {
        for (ExchangeRate rate : exchangeRates) {
            if (rate.getToCurrency().equals(EURO)) {
                ratesByCurrency
                        .computeIfAbsent(rate.getFromCurrency(), k -> new TreeMap<>())
                        .put(rate.getTimestamp(), rate.getRate());
            }
        }
    }

    public double convertToEUR(Payment payment) {
        if (payment.getCurrency().equals(EURO)) return payment.getAmount();

        NavigableMap<LocalDateTime, Double> currencyRates = ratesByCurrency.get(payment.getCurrency());
        Map.Entry<LocalDateTime, Double> rateEntry = (currencyRates != null) ? currencyRates.floorEntry(payment.getTimestamp()) : null;

        return (rateEntry != null) ? payment.getAmount() * rateEntry.getValue() : DEFAULT_EXCHANGE_RATE;
    }
}
