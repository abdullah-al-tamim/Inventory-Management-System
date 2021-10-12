/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Supplier implements Serializable{
    private String supName;
    private String supPhone;

    public Supplier(String supName, String supPhone) {
        this.supName = supName;
        this.supPhone = supPhone;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public void order(){

    }

    @Override
    public String toString() {
        return "Supplier{" + "supName=" + supName + ", supPhone=" + supPhone + '}';
    }

    
}
