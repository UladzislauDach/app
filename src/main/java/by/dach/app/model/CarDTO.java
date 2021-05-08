package by.dach.app.model;

public class CarDTO {
    private int year;
    private String model;
    private int volume;
    private Transmission transmission;
    private int price;
    private BodyType bodyType;
    private String vin;

    public CarDTO() {
    }

    public CarDTO(int year, String model, int volume, Transmission transmission, int price, BodyType bodyType, String vin) {
        this.year = year;
        this.model = model;
        this.volume = volume;
        this.transmission = transmission;
        this.price = price;
        this.bodyType = bodyType;
        this.vin = vin;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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


    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
