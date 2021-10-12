/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;

/**
 *
 * @author Admin
 */
public class Cash extends Payment{
    private double CashTendered;

    

    public Cash(double CashTendered, double totalAmount ) {
        super(totalAmount);
        this.CashTendered = CashTendered;
    }

    public double getCashTendered() {
        return CashTendered;
    }

    public void setCashTendered(double CashTendered) {
        this.CashTendered = CashTendered;
    }

    

}
