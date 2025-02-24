package com.deutschebank.task;

import com.deutschebank.task.model.Payment;
import com.deutschebank.task.model.ExchangeRate;
import com.deutschebank.task.parser.CSVFileParser;
import com.deutschebank.task.service.CurrencyConverterService;
import com.deutschebank.task.service.MetricsCalculatorService;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        String paymentsFile = getFilePathFromResources("data/payments.csv");
        String ratesFile = getFilePathFromResources("data/rates.csv");

        List<Payment> payments = CSVFileParser.parsePayments(paymentsFile);
        List<ExchangeRate> rates = CSVFileParser.parseExchangeRates(ratesFile);

        CurrencyConverterService converter = new CurrencyConverterService(rates);

        MetricsCalculatorService.calculateMetrics(payments, converter);
    }

    private static String getFilePathFromResources(String fileName) throws Exception {
        ClassLoader classLoader = Main.class.getClassLoader();
        if (classLoader.getResource(fileName) == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        return Paths.get(Objects.requireNonNull(classLoader.getResource(fileName)).toURI()).toString();
    }
}
