package by.dach.app.model.dto;

import by.dach.app.model.BodyType;
import by.dach.app.model.Transmission;
import lombok.Data;
import lombok.Getter;
public abstract class BaseCarDto {
    private int year;
    private String model;
    private Transmission transmission;
    private int price;
    private String vin;
    private BodyType bodyType;

    public BaseCarDto() {
    }

    public BaseCarDto(int year, String model, Transmission transmission, int price, String vin, BodyType bodyType) {
        this.year = year;
        this.model = model;
        this.transmission = transmission;
        this.price = price;
        this.vin = vin;
        this.bodyType = bodyType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
