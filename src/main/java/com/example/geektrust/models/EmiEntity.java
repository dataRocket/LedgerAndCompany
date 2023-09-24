package com.example.geektrust.models;

public class EmiEntity {
    private final String emiId;
    private final Double amount;

    private final boolean isLumpSum;

    public EmiEntity(String emiId, Double amount, boolean isLumpSum) {
        this.emiId = emiId;
        this.amount = amount;
        this.isLumpSum = isLumpSum;
    }
}
