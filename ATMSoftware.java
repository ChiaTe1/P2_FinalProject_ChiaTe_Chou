/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.HashMap;

/**
 *
 * @author ChiaTe
 */
public class ATMSoftware extends Bank implements ATMFunction {

    private Bank bank;

    public ATMSoftware(Bank bank) {
        this.bank = bank;
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    @Override
    public double checkBalance(String accountNumber) {
        // Retrieve account balance from the bank
        return totalDeposit.getOrDefault(accountNumber, 0.0);
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, Double> getTotalDeposit() {
        return totalDeposit;
    }

    /**
     *
     * @param accountNumber
     * @param amount
     */
    @Override
    public void setTotalDeposit(String accountNumber, double amount) {
        totalDeposit.put(accountNumber, amount);
    }

    /**
     *
     * @param accountNumber
     * @param amount
     * @return
     */
    @Override
    public boolean withdraw(String accountNumber, double amount) {
        // Implement withdrawal logic
        double balance = bank.getTotalDeposit().getOrDefault(accountNumber, 0.0);
        if (balance >= amount) {
            balance -= amount;
            totalDeposit.put(accountNumber, balance);
            return true;
        } else {
            return false;  // Insufficient balance
        }
    }
}
