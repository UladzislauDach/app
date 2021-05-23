package by.dach.app.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "year")
    private int year;
    @Column(name = "model")
    private String model;
    @Column(name = "volume")
    private int volume;
    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private Transmission transmission;
    @Column(name = "price")
    private int price;
    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private BodyType bodyType;
    @Column(name = "vin")
    private String vin;
    @Embedded
    @AttributeOverride(name = "creationAt", column = @Column(name = "creation_time"))
    @AttributeOverride(name = "innerCode", column = @Column(name = "inner_code"))
    private CarServiceInfo carServiceInfo;

    public Car(int id, int year, String model, int volume, Transmission transmission, int price, BodyType bodyType, String vin, CarServiceInfo carServiceInfo) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.volume = volume;
        this.transmission = transmission;
        this.price = price;
        this.bodyType = bodyType;
        this.vin = vin;
        this.carServiceInfo = carServiceInfo;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CarServiceInfo getCarServiceInfo() {
        return carServiceInfo;
    }

    public void setCarServiceInfo(CarServiceInfo carServiceInfo) {
        this.carServiceInfo = carServiceInfo;
    }
}
