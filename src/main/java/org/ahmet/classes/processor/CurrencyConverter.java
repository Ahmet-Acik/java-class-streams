// CurrencyConverter.java
package org.ahmet.classes.processor;

import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        double rate = exchangeRates.getOrDefault(fromCurrency + "_" + toCurrency, 0.0);
        if (rate == 0.0) {
            throw new IllegalArgumentException("Exchange rate not found.");
        }
        return amount * rate;
    }
}