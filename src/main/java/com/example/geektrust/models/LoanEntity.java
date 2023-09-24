package com.example.geektrust.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoanEntity {
    private final String loanId;
    private final Double loadAmount;

    private final Double principal;
    
    private final Double rateOfInterest;
    
    private final Integer numOfYears;
    
    private final User user;

    private Integer emiLeft;

    private Double amountPaid;

    public LoanEntity(String loanId, Double principal, Double rateOfInterest, Integer numOfYears, User user) {
        this.loanId = loanId;
        this.principal = principal;
        this.loadAmount = (principal * rateOfInterest * numOfYears)/100 + principal;
        this.rateOfInterest = rateOfInterest;
        this.numOfYears = numOfYears;
        this.user = user;
        this.emiList = new ArrayList<>();
        this.emiLeft = (int) Math.ceil(this.loadAmount/12);// monthly emi
    }

    private List<EmiEntity> emiList;

    public String getLoanId() {
        return loanId;
    }

    public Double getLoadAmount() {
        return loadAmount;
    }

    public Double getRateOfInterest() {
        return rateOfInterest;
    }

    public Integer getNumOfYears() {
        return numOfYears;
    }

    public User getUser() {
        return user;
    }

    public List<EmiEntity> getEmiList() {
        return emiList;
    }

    public boolean addToEmiList(EmiEntity emi) {
        if(emiList != null) {
            emiList.add(emi);
        }
        return true;
    }

    public void addPayment(Double amount, Integer emiNum) {
        this.amountPaid += amount;
        this.emiList.add(new EmiEntity(UUID.randomUUID().toString(), amount, ))
    }
}
