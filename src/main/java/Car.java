package main.java;

public class Car {

    private String car_make, car_model, car_regNumber;
    private int car_releaseYear, car_price, seller_PhoneNumber;

    public Car (String car_make, String car_model, String car_regNumber, int car_releaseYear, int car_price, int seller_PhoneNumber) {
        this.car_make = car_make;
        this.car_model = car_model;
        this.car_regNumber = car_regNumber;
        this.car_releaseYear = car_releaseYear;
        this.car_price = car_price;
        this.seller_PhoneNumber = seller_PhoneNumber;
    }

    public Car() {
    }

    public String getCar_make() {
        return car_make;
    }

    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_regNumber() {
        return car_regNumber;
    }

    public void setCar_regNumber(String car_regNumber) {
        this.car_regNumber = car_regNumber;
    }

    public int getCar_releaseYear() {
        return car_releaseYear;
    }

    public void setCar_releaseYear(int car_releaseYear) {
        this.car_releaseYear = car_releaseYear;
    }

    public int getCar_price() {
        return car_price;
    }

    public void setCar_price(int car_price) {
        this.car_price = car_price;
    }

    public int getSeller_PhoneNumber() {
        return seller_PhoneNumber;
    }

    public void setSeller_PhoneNumber(int seller_PhoneNumber) {
        this.seller_PhoneNumber = seller_PhoneNumber;
    }
}
