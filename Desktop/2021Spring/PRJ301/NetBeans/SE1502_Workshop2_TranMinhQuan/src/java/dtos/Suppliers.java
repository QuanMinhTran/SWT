/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class Suppliers {
    private String SupplierID;
    private String SupplierName;
    private String Description;

    public Suppliers() {
    }

    public Suppliers(String SupplierID, String SupplierName) {
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
    }

    public Suppliers(String SupplierID, String SupplierName, String Description) {
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
        this.Description = Description;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
}
