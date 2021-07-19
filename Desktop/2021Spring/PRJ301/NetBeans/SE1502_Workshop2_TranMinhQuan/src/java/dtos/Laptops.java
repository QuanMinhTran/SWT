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
public class Laptops {
    private String Id;
    private String LaptopName;
    private String TechnicalInformation;
    private int YearOfManufacture;
    private String Producer;
    private String Status;
    private Suppliers SupplierID;
    
    public Laptops() {
    }

    public Laptops(String Id, String LaptopName, String TechnicalInformation, int YearOfManufacture, String Producer, String Status, Suppliers SupplierID) {
        this.Id = Id;
        this.LaptopName = LaptopName;
        this.TechnicalInformation = TechnicalInformation;
        this.YearOfManufacture = YearOfManufacture;
        this.Producer = Producer;
        this.Status = Status;
        this.SupplierID = SupplierID;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getLaptopName() {
        return LaptopName;
    }

    public void setLaptopName(String LaptopName) {
        this.LaptopName = LaptopName;
    }

    public String getTechnicalInformation() {
        return TechnicalInformation;
    }

    public void setTechnicalInformation(String TechnicalInformation) {
        this.TechnicalInformation = TechnicalInformation;
    }

    public int getYearOfManufacture() {
        return YearOfManufacture;
    }

    public void setYearOfManufacture(int YearOfManufacture) {
        this.YearOfManufacture = YearOfManufacture;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Suppliers getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(Suppliers SupplierID) {
        this.SupplierID = SupplierID;
    }

    
    
    
}
