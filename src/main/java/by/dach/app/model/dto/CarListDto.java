package by.dach.app.model.dto;

import by.dach.app.model.BodyType;
import by.dach.app.model.CarServiceInfo;
import by.dach.app.model.Transmission;

public class CarListDto extends BaseCarDto {
    private int id;
    private int volume;
    private CarServiceInfo carServiceInfo;

    public CarListDto() {
    }

    public CarListDto(int id, int volume, CarServiceInfo carServiceInfo) {
        this.id = id;
        this.volume = volume;
        this.carServiceInfo = carServiceInfo;
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

    public CarServiceInfo getCarServiceInfo() {
        return carServiceInfo;
    }

    public void setCarServiceInfo(CarServiceInfo carServiceInfo) {
        this.carServiceInfo = carServiceInfo;
    }
}
