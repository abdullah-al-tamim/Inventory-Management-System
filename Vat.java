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
public abstract class Vat {
    public static double Rate = 0.15;

    public Vat() {
    }

    public Vat(double Rate) {
        this.Rate = Rate;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }

    abstract public double vatAmount(double totalAmount);

    @Override
    public String toString() {
        return "Vat{" + "Rate=" + Rate + '}';
    }
}
