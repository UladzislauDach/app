package by.dach.app.model.dto;

import by.dach.app.model.BodyType;
import by.dach.app.model.Transmission;

public class CarFormDto extends BaseCarDto {
    private int engineVolume;


    public CarFormDto() {
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
}
