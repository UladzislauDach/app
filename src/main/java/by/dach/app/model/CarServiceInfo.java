package by.dach.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CarServiceInfo {
    @Column
    LocalDateTime creationAt;
    @Column
    String innerCode;

    public CarServiceInfo() {
    }

    public CarServiceInfo(LocalDateTime creationAt, String innerCode) {
        this.creationAt = creationAt;
        this.innerCode = innerCode;
    }

    public LocalDateTime getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(LocalDateTime creationAt) {
        this.creationAt = creationAt;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }
}
