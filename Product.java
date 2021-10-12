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
public class Product extends Category implements Comparable<Product>{
    private String productId;
    private String productName;
//    private Category category;
    private double price;
    private int quantity;
    

    public Product() {
    }

    public Product(String productId, String productName,  String catName, double price, int quantity) {
        super(catName);
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }


    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", Category='" + catName + '\'' +
                ", Price=" + price +
                ", Quantity=" + quantity +
                '}';
    }
    
    public String paymentDisplay(){
        return "Product{" + "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", Category='" + catName + '\'' +
                ", Price=" + price +"}";
    }
    
    @Override
    public int compareTo(Product t) {
        if (price < t.price) {
            return -1;
        } else if (price == t.price) {
            return 0;
        } else {
            return 1;
        }

    }
    
}

