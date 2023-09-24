package com.example.geektrust.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoanEntity {
    private final String loanId;
    private final Double loanAmount;

    private final Double principal;

    private final Double rateOfInterest;

    private final Integer numOfYears;

    private final User user;
    private Double emiAmount;

    private Integer emiLeft;

    private Double amountPaid;

    @Override
    public String toString() {
        return "LoanEntity{" +
                "loanAmount=" + loanAmount +
                ", principal=" + principal +
                ", rateOfInterest=" + rateOfInterest +
                ", numOfYears=" + numOfYears +
                ", emiAmount=" + emiAmount +
                ", emiLeft=" + emiLeft +
                ", amountPaid=" + amountPaid +
                '}';
    }

    public LoanEntity(String loanId, Double principal, Double rateOfInterest, Integer numOfYears, User user) {
        this.loanId = loanId;
        this.principal = principal;
        this.loanAmount = (principal * rateOfInterest * numOfYears) / 100 + principal;
        this.rateOfInterest = rateOfInterest;
        this.numOfYears = numOfYears;
        this.user = user;
        this.emiList = new ArrayList<>();
        this.emiAmount = Math.ceil(this.loanAmount * this.numOfYears / 12);
        this.emiLeft = this.numOfYears * 12;// monthly emi
        // intialize all the emi's list
        System.out.println(this);
        initializeEmiList();
    }

    private void initializeEmiList() {
        this.emiList = new ArrayList<>();
        for (int i = 0; i< this.emiLeft; i++) {
            System.out.println("Setting emi amount for nyum : " + this.emiAmount + " for nyum : " + (i+1));
            EmiEntity e = new EmiEntity(UUID.randomUUID().toString(), this.emiAmount, false, (i+1));
            this.emiList.add(e);
            System.out.println("adding emi to load" + e );

        }
    }

    private List<EmiEntity> emiList;

    public String getLoanId() {
        return loanId;
    }

    public Double getLoanAmount() {
        return loanAmount;
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
        if (emiList != null) {
            emiList.add(emi);
        }
        return true;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Double getEmiAmount() {
        return emiAmount;
    }

    public Integer getEmiLeft() {
        return emiLeft;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void addPayment(Double amount, Integer emiNum) {
        this.amountPaid += amount;
        this.emiLeft -= (int)Math.ceil(amount/this.emiAmount);
        if(amount > this.emiAmount) {
            updateEmi(emiNum, amountPaid);
            updateEmiList(emiNum);
        }
        //TODO validate if emiLeft is a valida functional value
        if(this.emiLeft <= this.emiAmount) {
            this.emiAmount = (double)this.emiLeft;
        }
    }

    private void updateEmiList(Integer emiNum) {
        double newEmiAmount = ((double) (this.emiLeft * this.numOfYears) / 12.0);
        for (int i = emiNum; i < this.emiList.size(); i++) {
            EmiEntity e = this.emiList.get(i); //compensating for index
            if(amountPaid > e.getAmount()) {
                e.setAmount(newEmiAmount);
            }
            this.emiList.set(i , e);
        }
    }

    private void updateEmi(Integer emiNum, Double amountPaid) {
        EmiEntity e = this.emiList.get(emiNum - 1); //compensating for index
        if(amountPaid > e.getAmount()) {
            e.setLumpSum(true);
            e.setAmount(amountPaid);
        }
        this.emiList.set(emiNum -1 , e);
    }
}
