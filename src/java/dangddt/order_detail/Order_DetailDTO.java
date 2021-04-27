/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.order_detail;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Tam Dang
 */
public class Order_DetailDTO implements Serializable{
    private String carLicensePlate;
    private Timestamp rental_date;
    private Timestamp return_date;
    private int daysRented;
    private float totalPrice;

    public Order_DetailDTO(String carLicensePlate, Timestamp rental_date, Timestamp return_date, int daysRented, float totalPrice) {
        this.carLicensePlate = carLicensePlate;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.daysRented = daysRented;
        this.totalPrice = totalPrice;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }
    
    public Order_DetailDTO() {
    }

    public Timestamp getRental_date() {
        return rental_date;
    }

    public void setRental_date(Timestamp rental_date) {
        this.rental_date = rental_date;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
