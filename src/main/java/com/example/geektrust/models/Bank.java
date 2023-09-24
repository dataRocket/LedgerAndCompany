package com.example.geektrust.models;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final String bankName;
    //TODO : make user map compaitble
    Map<User, LoanEntity> ledger;

    public Bank(String bankName) {
        this.bankName = bankName;
        ledger = new HashMap<>();
    }


    public boolean addToLoans(User usr, LoanEntity loan) {
        // we are assuming a user can avail a single loan at any point in time
        this.ledger.put(usr, loan);
        return true;
    }

    public LoanEntity getLoanFromUser(User user) {
        return ledger.get(user);
    }
}
