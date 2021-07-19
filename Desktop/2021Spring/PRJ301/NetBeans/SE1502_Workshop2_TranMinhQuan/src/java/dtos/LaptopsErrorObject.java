/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class LaptopsErrorObject implements Serializable{
    private String idError, nameError, TIError, yearError, producerError, statusError;

    public LaptopsErrorObject() {
    }

    public LaptopsErrorObject(String idError, String nameError, String TIError, String yearError, String producerError, String statusError) {
        this.idError = idError;
        this.nameError = nameError;
        this.TIError = TIError;
        this.yearError = yearError;
        this.producerError = producerError;
        this.statusError = statusError;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getTIError() {
        return TIError;
    }

    public void setTIError(String TIError) {
        this.TIError = TIError;
    }

    public String getYearError() {
        return yearError;
    }

    public void setYearError(String yearError) {
        this.yearError = yearError;
    }

    public String getProducerError() {
        return producerError;
    }

    public void setProducerError(String producerError) {
        this.producerError = producerError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }
    
    
}
