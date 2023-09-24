package com.example.geektrust.models;

public class EmiEntity {
    private final String emiId;
    private  Double amount;

    private  boolean isLumpSum;

    private final Integer emiNumber;

    public EmiEntity(String emiId, Double amount, boolean isLumpSum, Integer emiNumber) {
        this.emiId = emiId;
        this.amount = amount;
        this.emiNumber = emiNumber;
        this.isLumpSum = isLumpSum;
    }

    public String getEmiId() {
        return emiId;
    }

    public Double getAmount() {
        return amount;
    }

    public boolean isLumpSum() {
        return isLumpSum;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setLumpSum(boolean lumpSum) {
        isLumpSum = lumpSum;
    }

    @Override
    public String toString() {
        return "EmiEntity{" +
                "emiId='" + emiId + '\'' +
                ", amount=" + amount +
                ", isLumpSum=" + isLumpSum +
                ", emiNumber=" + emiNumber +
                '}';
    }
}
