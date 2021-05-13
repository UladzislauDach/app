package by.dach.app.model.dto;

import by.dach.app.model.BodyType;
import by.dach.app.model.Transmission;

public class CarFormDto extends BaseCarDto {
    private int engineVolume;
    private BodyType bodyType;

    public CarFormDto() {
    }

    public CarFormDto(int engineVolume, BodyType bodyType) {
        this.engineVolume = engineVolume;
        this.bodyType = bodyType;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
