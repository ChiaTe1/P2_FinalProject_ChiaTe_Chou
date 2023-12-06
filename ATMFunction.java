/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author ChiaTe
 */
public interface ATMFunction {

    /**
     *
     * @param accountNumber
     * @return
     */
    public double checkBalance(String accountNumber);

    /**
     *
     * @param accountNumber
     * @param amount
     * @return
     */
    boolean withdraw(String accountNumber, double amount);

}
