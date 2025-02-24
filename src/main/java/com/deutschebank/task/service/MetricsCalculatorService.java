package com.deutschebank.task.service;

import com.deutschebank.task.model.Payment;

import java.util.*;
import java.util.stream.Collectors;

public class MetricsCalculatorService {
    public static void calculateMetrics(List<Payment> payments, CurrencyConverterService converter) {
        List<Double> convertedAmounts = payments.stream()
                .map(converter::convertToEUR)
                .filter(amount -> !Double.isNaN(amount))
                .toList();

        double highest = convertedAmounts.stream().max(Double::compare).orElse(0.0);
        double lowest = convertedAmounts.stream().map(Math::abs).min(Double::compare).orElse(0.0);
        double totalVolume = convertedAmounts.stream().mapToDouble(Math::abs).sum();
        Map<String, Double> outstandingAmountsPerCurrency = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCurrency,
                        Collectors.summingDouble(Payment::getAmount)
                ));
        Map<String, Double> outstandingAmountsPerCompany = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCompany,
                        Collectors.summingDouble(converter::convertToEUR)
                ));

        System.out.println("Highest EUR value (for a single payment): " + highest);
        System.out.println("Lowest EUR value (for a single payment): " + lowest);
        System.out.println("Outstanding amounts per company in EUR:");
        outstandingAmountsPerCompany.forEach((company, amount) ->
                System.out.println("  - " + company + ": " + amount)
        );
        System.out.println("Transaction volume in EUR: " + totalVolume);
        System.out.println("Outstanding Amounts per currency:");
        outstandingAmountsPerCurrency.forEach((currency, amount) ->
                System.out.println("  - " + currency + ": " + amount)
        );
    }
}
