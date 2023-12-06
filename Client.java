/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Objects;

/**
 *
 * @author ChiaTe
 */
public class Client {
    private String accountName;
    private String accountnumber;
    private String password;

    /**
     *
     * @param accountName
     * @param accountnumber
     * @param password
     */
    public Client(String accountName, String accountnumber, String password) {
        this.accountName = accountName;
        this.accountnumber = accountnumber;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     *
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     *
     * @return
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     *
     * @param accountnumber
     */
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.accountName, other.accountName)) {
            return false;
        }
        if (!Objects.equals(this.accountnumber, other.accountnumber)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }  

    @Override
    public String toString() {
        return "Client{" + "accountName=" + accountName + ", accountnumber=" + accountnumber + ", password=" + password + '}';
    }
    
}
