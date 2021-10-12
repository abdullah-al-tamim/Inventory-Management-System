/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;

import sun.security.util.Password;

/**
 *
 * @author Admin
 */
public class CreditCard extends Payment{
    private String creditNumber;
    private static final String password = "abcd";
    
    public CreditCard() {
    }

    
    
    public CreditCard(String creditNumber, double totalAmount) {
        super(totalAmount);
        this.creditNumber = creditNumber;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getPassword() {
        return password;
    }

   

    
}
