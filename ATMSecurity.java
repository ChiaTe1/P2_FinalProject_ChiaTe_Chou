/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author ChiaTe
 */
public abstract class ATMSecurity {

    /**
     *
     * @param accountNumber
     * @param password
     * @return
     */
    public abstract boolean validateLogin(String accountNumber, String password);
    
//    public abstract boolean validateWithdrawal(String accountNumber, double amount);
        
}
