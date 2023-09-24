package com.example.geektrust;

import com.example.geektrust.services.BankService;
import com.example.geektrust.services.BankServiceImpl;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = null;
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            BankService bankService = new BankServiceImpl();
            s = new Scanner(fis);
            while (s.hasNextLine()) {
                String command = s.nextLine();
                String[] commandArgs = command.split(" ");
                String bank = "";
                String user = "";
                double principal = 0.0;
                int numOfYears = 0;
                double roi = 0.0;
                int emiNum = 0;
                switch (commandArgs[0]) {
                    case "LOAN":
                        bank = commandArgs[1];
                        user = commandArgs[2];
                        principal = Double.parseDouble(commandArgs[3]);
                        numOfYears = Integer.parseInt(commandArgs[4]);
                        roi = Double.parseDouble(commandArgs[5]);
                        System.out.println(bankService.loan(bank, user, principal, numOfYears, roi));
                        break;
                    case "PAYMENT":
                        bank = commandArgs[1];
                        user = commandArgs[2];
                        principal = Double.parseDouble(commandArgs[3]);
                        emiNum = Integer.parseInt(commandArgs[4]);
                        System.out.println(bankService.payment(bank, user, principal, emiNum));
                        break;
                    case "BALANCE":
                        bank = commandArgs[1];
                        user = commandArgs[2];
                        System.out.println(bankService.balance(bank, user, emiNum));
                        break;
                    default:
                        System.out.println("INVALID COMMAND");

                }
            }
        } catch (Exception e) {
                System.out.println("Read excpetion occured" + e);
        } finally {
            assert s != null;
            s.close();
        }
    }
}
