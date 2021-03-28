package by.dach.app.model;

import org.hibernate.annotations.Type;

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

    public Car() {
    }

    public Car(int id, int year, String model, int volume, Transmission transmission, int price) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.volume = volume;
        this.transmission = transmission;
        this.price = price;
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
}
