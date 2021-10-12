/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ProjectIMS implements Serializable {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("*****************************************");
        System.out.println("------ INVENTORY MANAGEMENT SYSTEM ------");
        System.out.println("*****************************************");
        System.out.println("      --------- Log in --------");
        System.out.print("Enter User ID : ");
        user.setUserId(sc.next());
        System.out.print("Enter User name : ");
        user.setUserName(sc.next());
        System.out.print("Enter PASSWORD : ");
        if (user.logIn(sc.next())) {
            ArrayList<Product> pList = new ArrayList<>();
            ArrayList<Supplier> sList = new ArrayList<>();
            Product p;
            Supplier s;
            try {
                File file = new File("ims.txt");
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    String ss = scan.nextLine();
                    String[] pfile = ss.split(", ");
                    p = new Product(pfile[0], pfile[1], pfile[2], Double.parseDouble(pfile[3]), Integer.parseInt(pfile[4]));
                    pList.add(p);
                    System.out.println(p.toString());
                }
                scan.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                File file = new File("supplier.txt");
                Scanner scanf = new Scanner(file);
                while (scanf.hasNext()) {
                    String sss = scanf.nextLine();
                    String[] pfile = sss.split(", ");
                    s = new Supplier(pfile[0], pfile[1]);
                    sList.add(s);
                }
                for (int i = 0; i < sList.size(); i++) {
                    System.out.println(sList.get(i));

                }
                scanf.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            boolean run = true;
            while (run == true) {
                System.out.println("\n\t1. Add");
                System.out.println("\t2. Remove");
                System.out.println("\t3. Make payment slip");
                System.out.println("\t4. Search");
                System.out.println("\t5. Sort products by price");
                System.out.println("\t6. Display");
                System.out.println("\t7. Update");
                System.out.println("\t8. Exit");
                System.out.print("Enter your choice: ");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("\t1. Add a product");
                        System.out.println("\t2. Add a Supplier");
                        System.out.print("Enter your choice: ");
                        int a = sc.nextInt();
                        switch (a) {
                            case 1:
                                System.out.print("Enter product Id: ");
                                String id = sc.next();
                                System.out.print("Enter Product Name: ");
                                String name = sc.next();
                                System.out.print("Enter category: ");
                                String cat = sc.next();
                                System.out.print("Enter price: ");
                                double price = sc.nextDouble();
                                System.out.print("Enter quantity of the product: ");
                                int quan = sc.nextInt();
                                Product p1 = new Product(id, name, cat, price, quan);
                                pList.add(p1);
                                System.out.println("Product Added!!");
                                break;

                            case 2:
//                                        ObjectOutputStream objwr = new ObjectOutputStream(new FileOutputStream("supbin.bin"));
//                                for (int i = 0; i < 3; i++) {

                                System.out.print("Enter supplier name: ");
                                String Sname = sc.next();
                                System.out.print("Enter supplier phone number: ");
                                String Snum = sc.next();
                                Supplier s1 = new Supplier(Sname, Snum);
                                sList.add(s1);
//                                    try {
//                                        objwr.writeObject(s1);
//                                    } catch (Exception e) {
//                                        System.out.println(e);
//                                    }
                                System.out.println("Supplier Added!!");
//                                }
//                                        objwr.close();
                                break;

                        }
                        break;
                    case 2:
                        System.out.println("\t1. Remove a product");
                        System.out.println("\t2. Remove a supplier");
                        System.out.print("Enter your choice: ");
                        int r = sc.nextInt();
                        switch (r) {
                            case 1:
                                System.out.print("Enter product Id: ");
                                String id2 = sc.next();
                                for (int i = 0; i < pList.size(); i++) {
                                    if (id2.equalsIgnoreCase(pList.get(i).getProductId())) {
                                        pList.remove(i);
                                    }

                                }
                                System.out.println("Product removed successfully!");
                                break;
                            case 2:
                                System.out.println("Enter supplier phone number: ");
                                String sphn = sc.next();
                                for (int i = 0; i < sList.size(); i++) {
                                    if (sphn.equalsIgnoreCase(sList.get(i).getSupPhone())) {
                                        sList.remove(i);
                                    }
                                }
                                System.out.println("Supplier removed successfully!");
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("Enter customer name: ");
                        String cName = sc.next();
                        System.out.print("Enter customer phone: ");
                        long cPhn = sc.nextLong();
                        System.out.print("Enter address: ");
                        String add = sc.next();
                        Customer customer = new Customer(cName, add, cPhn);
                        Payment payment = new Payment();

                        System.out.print("How many products: ");
                        int h = sc.nextInt();
                        System.out.print("Enter payment method"
                                + "\n\t1. Cash"
                                + "\n\t2. Credit Card"
                                + "\n\t3. Bank Card"
                                + "\nEnter choice: ");
                        int pc = sc.nextInt();
                        switch (pc) {
                            case 1:
                                payment.printPaymentSlip(customer, pList, h);
                                break;
                            case 2:
                                System.out.print("Enter Credit card number: ");
                                String ccn = sc.next();
                                System.out.print("Enter credit card password: ");
                                String ccpass = sc.next();
                                CreditCard ccard = new CreditCard();
                                if (ccpass.equals(ccard.getPassword())) {

                                    payment.printPaymentSlip(customer, pList, h);
                                }
                                break;
                            case 3:
                                System.out.print("Enter Bank card number: ");
                                String bcn = sc.next();
                                System.out.print("Enter Bank card password: ");
                                String bcpass = sc.next();
                                BankCard bcard = new BankCard();
                                if (bcpass.equals(bcard.getPassword())) {
                                    payment.printPaymentSlip(customer, pList, h);
                                }
                                break;
                        }
                        break;

                    case 4:
                        System.out.println("\t1. Search a product");
                        System.out.println("\t2. Search a supplier");
                        System.out.print("Enter a option: ");
                        int optS = sc.nextInt();
                        switch (optS) {
                            case 1:
                                System.out.print("Enter product id: ");
                                String proID = sc.next();
                                boolean flug = true;
                                for (int i = 0; i < pList.size(); i++) {
                                    if (proID.equalsIgnoreCase(pList.get(i).getProductId())) {
                                        System.out.println(pList.get(i));
                                        flug = false;
                                    }
                                }
                                if (flug) {
                                    System.out.println("No products found!");
                                }
                                break;
                            case 2:
                                System.out.print("Enter supplier phone number: ");
                                String supP = sc.next();
                                boolean flug2 = true;
                                for (int i = 0; i < sList.size(); i++) {
                                    if (supP.equalsIgnoreCase(sList.get(i).getSupPhone())) {
                                        System.out.println(sList.get(i));
                                        flug2 = false;
                                    }
                                }
                                if (flug2) {
                                    System.out.println("No suppliers found!");
                                }
                                break;
                        }
                        break;
                    case 5:
                        Collections.sort(pList);
                        for (int i = 0; i < pList.size(); i++) {
                            System.out.println(pList.get(i));
                        }
                        break;
                    case 6:
                        System.out.println("\t1. Display all products");
                        System.out.println("\t2. Display all suppliers");
                        System.out.print("Enter your choice: ");
                        int sC = sc.nextInt();
                        switch (sC) {
                            case 1:
                                for (int i = 0; i < pList.size(); i++) {
                                    if (pList.get(i).getQuantity() <= 0) {
                                        System.out.println("Product id " + pList.get(i).getProductId() + " is no more available in the inventory, PLEASE RESTOCK!!");
                                        continue;
                                    }
                                    System.out.println(pList.get(i));
                                }
                                break;
                            case 2:
                                ObjectInputStream oisr = new ObjectInputStream(new FileInputStream("supbin.bin"));
                                while (oisr.available()>0) {
                                    try{
                                        System.out.println(oisr.readObject());
                                    } 
//                                    catch (EOFException e) {
//                                        break;
//                                    } 
                                    catch (Exception e1) {
                                        System.out.println(e1);

                                    }
                                }
                                for (int i = 0; i < sList.size(); i++) {
                                    System.out.println(sList.get(i));
                                }
                                break;
                            default:
                                System.out.println("Wrong input!\n");
                        }
                        break;
                    case 7:
                        System.out.println("\t1. Update price.");
                        System.out.println("\t2. Update quantity");
                        System.out.print("Enter option: ");
                        int upOption = sc.nextInt();

                        switch (upOption) {
                            case 1:
                                System.out.print("Enter product ID: ");
                                String produID = sc.next();
                                System.out.print("Enter updated price: ");
                                double newP = sc.nextDouble();
                                for (int i = 0; i < pList.size(); i++) {
                                    if (produID.equalsIgnoreCase(pList.get(i).getProductId())) {
                                        pList.get(i).setPrice(newP);

                                    }
                                }
                                System.out.println("Price updated successfully!");
                                break;
                            case 2:
                                System.out.print("Enter product id: ");
                                String Pid = sc.next();
                                System.out.print("Enter Updated quantity: ");
                                int Nq = sc.nextInt();
                                for (int i = 0; i < pList.size(); i++) {
                                    if (Pid.equalsIgnoreCase(pList.get(i).getProductId())) {
                                        pList.get(i).setQuantity(Nq);
                                    }
                                }
                                System.out.println("Quantity updated successfully!");
                                break;
                        }
                        break;
                    case 8:
                        run = false;
                        break;
                    default:
                        System.out.println("Wrong input! Try Again.\n");
                }
            }

        } else {
            user.logOut();
        }
    }

}
