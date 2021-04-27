/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.car;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Tam Dang
 */
public class CarDTO implements Serializable {

    private String licensePlate;
    private String name;
    private String image;
    private String color;
    private int year;
    private String category;
    private float price;
    private int quantity;
    private Timestamp rental_date;
    private Timestamp return_date;
    private int daysRented;
    private float totalPrice;
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

    public CarDTO() {
    }

    public CarDTO(String licensePlate, String name, String image, String color, int year, String category, float price) {
        this.licensePlate = licensePlate;
        this.name = name;
        this.image = image;
        this.color = color;
        this.year = year;
        this.category = category;
        this.price = price;
    }

    public CarDTO(String licensePlate, String name, String image, String color, int year, String category, float price, Timestamp rental_date, Timestamp return_date, int daysRented, float totalPrice) {
        this.licensePlate = licensePlate;
        this.name = name;
        this.image = image;
        this.color = color;
        this.year = year;
        this.category = category;
        this.price = price;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.daysRented = daysRented;
        this.totalPrice = totalPrice;
    }

    public CarDTO(String name, int year, String category, int quantity) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.quantity = quantity;
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
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
