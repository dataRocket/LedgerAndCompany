package com.example.geektrust.services;

import com.example.geektrust.models.Bank;
import com.example.geektrust.models.EmiEntity;
import com.example.geektrust.models.LoanEntity;
import com.example.geektrust.models.User;

import java.util.*;

public class BankServiceImpl implements BankService{

    Map<String, Bank> banks;

    public BankServiceImpl() {
        super();
        this.banks = new HashMap<>();
    }

    @Override
    public String loan(String bank, String user, Double amount, Integer numOfYear, Double interestRate) {
        banks.computeIfAbsent(bank, k -> new Bank(bank));
        Bank currbank = banks.get(bank);
        User usr = new User(user);
        LoanEntity loan = new LoanEntity(bank + UUID.randomUUID().toString(), amount, interestRate, numOfYear, usr);
        boolean result = currbank.addToLoans(usr, loan);
        return result == true ? "SUCCESS" : "FAILURE";
    }

    @Override
    public String payment(String bank, String user, Double amount, Integer emiNum) {
        Bank currBank = banks.get(bank);
        LoanEntity loan = currBank.getLoanFromUser(new User(user));
        if(loan != null) {
            loan.addPayment(amount, emiNum);
        }
        return "SUCCESS";
    }

    @Override
    public String balance(String bank, String user, Integer emiNum) {
        Bank currBank = banks.get(bank);
        LoanEntity currLoan = currBank.getLoanFromUser(new User(user));
        List<EmiEntity> currEmi = currLoan.getEmiList();
        double amountPaid = 0.0;
        for(EmiEntity e : currEmi) {
            if(e.getEmiNumber() <= emiNum.intValue()) {
                amountPaid += e.getAmount();
            }
        }

        System.out.println(amountPaid + "  emid etails " +  currLoan.getEmiLeft());
        return "SUCCESS";

    }
}
