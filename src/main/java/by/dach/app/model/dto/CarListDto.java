package by.dach.app.model.dto;

import by.dach.app.model.BodyType;
import by.dach.app.model.CarServiceInfo;
import by.dach.app.model.Transmission;

import java.time.LocalDateTime;

public class CarListDto extends BaseCarDto {
    private int id;
    private int volume;
    private String creationAt;
    private String innerCode;


    public CarListDto() {
    }

    public CarListDto(int year, String model, Transmission transmission, int price, String vin, BodyType bodyType, int id, int volume, String creationAt, String innerCode) {
        super(year, model, transmission, price, vin, bodyType);
        this.id = id;
        this.volume = volume;
        this.creationAt = creationAt;
        this.innerCode = innerCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(String creationAt) {
        this.creationAt = creationAt;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }
}
