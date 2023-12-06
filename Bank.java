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

public class Bank {
    public HashMap<String, Double> totalDeposit;
    
    /**
     *
     */
    public Bank(){
        totalDeposit = new HashMap<>();
    }
    
    /**
     *
     * @return
     */
    public HashMap<String, Double> getTotalDeposit() {
        return totalDeposit;
    }

    /**
     *
     * @param accountNumber
     * @param amount
     */
    public void setTotalDeposit(String accountNumber, double amount) {
        totalDeposit.put(accountNumber, amount);
    }

    
}

