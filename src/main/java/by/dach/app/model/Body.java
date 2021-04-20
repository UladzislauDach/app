package by.dach.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Body {
    @Column
    @Enumerated(EnumType.STRING)
    BodyType type;
    @Column
    String vin;

    public Body(BodyType type, String vin) {
        this.type = type;
        this.vin = vin;
    }

    public Body() {
    }

    public BodyType getType() {
        return type;
    }

    public void setType(BodyType type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
