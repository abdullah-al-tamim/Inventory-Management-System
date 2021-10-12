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
public class Category {
    protected String catName;

    public Category() {
    }

    public Category(String catName) {
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Category{" + "catName=" + catName + '}';
    }

    
}
