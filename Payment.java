/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Payment extends Vat {

    private double totalAmount, due;

    public Payment() {
        totalAmount = 0;
        due = 0;
    }

    public Payment(double amount) {
        totalAmount = amount;
    }

    public Payment(double totalAmount, double Rate) {
        super(Rate);
        this.totalAmount = totalAmount;

    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    @Override
    public double vatAmount(double totalAmount) {
        return totalAmount * Vat.Rate;
    }

    public void printPaymentSlip(Customer customer, ArrayList<Product> pList, int how) {
        ArrayList<Product> pList2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < how; i++) {

            System.out.print("Enter product Id: ");
            String pid = sc.next();
            boolean flug = true;
            for (int j = 0; j < pList.size(); j++) {
                if (pid.equalsIgnoreCase(pList.get(j).getProductId())) {
                    if (pList.get(j).getQuantity() <= 0) {
                        System.out.println("This product is no more available in the inventory, PLEASE RESTOCK!!");
                        flug = false;
                        break;
                    }
                    totalAmount += pList.get(j).getPrice();
                    int q = pList.get(j).getQuantity() - 1;
                    pList.get(j).setQuantity(q);
                    pList2.add(pList.get(j));
                    flug = false;
                }

            }
            if (flug) {
                System.out.println("No such products!");
            }
        }
        if (pList2.size() > 0) {

            System.out.println("Net payable: " + (totalAmount + vatAmount(totalAmount)));
            System.out.print("Enter paid amount: ");
            double pamentAmount = sc.nextDouble();
            System.out.println("------------------------------------------------------------");
            System.out.println(customer);
            for (int i = 0; i < pList2.size(); i++) {
                
                System.out.println(pList2.get(i).paymentDisplay());
            }

            System.out.println("Total amount without vat: " + totalAmount);
            totalAmount += vatAmount(totalAmount);
            System.out.println("Total amount with 15% vat: " + totalAmount);
            if (pamentAmount > totalAmount) {
                System.out.println("Paid.");
                System.out.println("Change: " + (pamentAmount - totalAmount));
            }
            if (pamentAmount < totalAmount) {
                double due = totalAmount - pamentAmount;
                System.out.println("Due: " + due);

            }
            if (totalAmount == pamentAmount) {
                System.out.println("Paid.");
            }
            System.out.println(Calendar.getInstance().getTime());
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("No payment slip!");
        }
    }

    @Override
    public String toString() {
        return "Payment{" + "totalAmount=" + totalAmount + ", due=" + due + "Rate=" + Rate + '}';
    }
}
