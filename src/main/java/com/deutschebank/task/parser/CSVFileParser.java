package com.deutschebank.task.parser;

import com.deutschebank.task.model.Payment;
import com.deutschebank.task.model.ExchangeRate;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;

import static com.deutschebank.task.constant.AppConstant.*;
import static com.deutschebank.task.constant.AppConstant.TableHeaders.*;

public class CSVFileParser {
    public static List<Payment> parsePayments(String filePath) throws IOException {
        List<Payment> payments = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = CSVFormat.DEFAULT.builder()
                     .setDelimiter(CSV_DELIMITER)
                     .setHeader()
                     .setSkipHeaderRecord(true)
                     .build()
                     .parse(reader)) {

            for (CSVRecord record : csvParser) {
                payments.add(new Payment(
                        LocalDateTime.parse(record.get(DATE_TIME.get()), DATE_TIME_FORMATTER),
                        record.get(COMPANY.get()),
                        record.get(CURRENCY.get()),
                        Double.parseDouble(record.get(AMOUNT.get()))
                ));
            }
        }
        return payments;
    }

    public static List<ExchangeRate> parseExchangeRates(String filePath) throws IOException {
        List<ExchangeRate> rates = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = CSVFormat.DEFAULT.builder()
                     .setDelimiter(CSV_DELIMITER)
                     .setHeader()
                     .setSkipHeaderRecord(true)
                     .build()
                     .parse(reader)) {

            for (CSVRecord record : csvParser) {
                rates.add(new ExchangeRate(
                        LocalDateTime.parse(record.get(DATE_TIME.get()), DATE_TIME_FORMATTER),
                        record.get(CCY1.get()),
                        record.get(CCY2.get()),
                        Double.parseDouble(record.get(RATE.get()))
                ));
            }
        }
        return rates;
    }
}
