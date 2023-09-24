package com.example.geektrust.services;

import com.example.geektrust.models.Bank;
import com.example.geektrust.models.User;

public interface BankService {

    String loan(String bank, String user, Double amount, Integer numOfYear, Double interestRate);
    String payment(String bank, String user, Double amount, Integer emiNum);

    public String balance(Bank bank, User user, Integer emiNum);

}
