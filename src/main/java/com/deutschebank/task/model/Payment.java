package com.deutschebank.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Payment {
    private LocalDateTime timestamp;
    private String company;
    private String currency;
    private double amount;
}
