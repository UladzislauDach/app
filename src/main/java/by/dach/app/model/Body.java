package by.dach.app.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Body {
    String type;
    String vin;

    public Body() {
    }

    public Body(String type, String vin) {
        this.type = type;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
