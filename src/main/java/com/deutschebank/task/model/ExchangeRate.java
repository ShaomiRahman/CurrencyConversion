package com.deutschebank.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExchangeRate {
    private LocalDateTime timestamp;
    private String fromCurrency;
    private String toCurrency;
    private double rate;
}
