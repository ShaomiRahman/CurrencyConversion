package com.deutschebank.task.constant;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public final class AppConstant {

    public static final char CSV_DELIMITER = ';';
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public enum TableHeaders {
        DATE_TIME("date+time"),
        COMPANY("company"),
        CURRENCY("currency"),
        AMOUNT("amount"),
        CCY1("ccy1"),
        CCY2("ccy2"),
        RATE("rate");

        private final String columnName;

        TableHeaders(String columnName) {
            this.columnName = columnName;
        }

        public String get() {
            return columnName;
        }
    }

    public static final double DEFAULT_EXCHANGE_RATE = Double.NaN;
    public static final String EURO = "EUR";

    private void AppConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
