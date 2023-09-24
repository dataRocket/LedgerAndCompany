package com.example.geektrust.models;

public class User {
    private String userName;
    private Double creditScore;

    public String getUserName() {
        return userName;
    }
    public Double getCreditScore() {
        return creditScore;
    }

    public User(String userName) {
        this.userName = userName;
        this.creditScore = 0.0;
    }
    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        } else {
            return this.userName.equals(((User)object).getUserName());
        }
    }

    @Override
    public int hashCode(){
        return this.userName.hashCode();
    }

}
