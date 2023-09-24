package com.example.geektrust;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = null;
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            s = new Scanner(fis);
            while(s.hasNextLine()) {
                String command = s.nextLine();
                String[] commandArgs = command.split(" ");
                switch (commandArgs[0]) {
                    case "LOAN" :
                    case "PAYMENT" :
                    case "BALANCE" :

                }
            }
        } catch(Exception e) {

        } finally {
            s.close();
        }
    }
}
