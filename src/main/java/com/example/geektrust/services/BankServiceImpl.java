package com.example.geektrust.services;

import com.example.geektrust.models.Bank;
import com.example.geektrust.models.LoanEntity;
import com.example.geektrust.models.User;

import java.util.Map;
import java.util.UUID;

public class BankServiceImpl implements BankService{

    Map<String, Bank> banks;

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
        LoanEntity loan = currBank.getLoanFromUser(user);
        if(loan != null) {
            loan.addPayment(amount, emiNum);
        }
    }

    @Override
    public String balance(Bank bank, User user, Integer emiNum) {
        return null;
    }
}
