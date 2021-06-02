package by.dach.app.model.dto;

import by.dach.app.model.BodyType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    private String operationName;
    private int operationCode;
    private String description;
    private String parts;
    private int interval;
    private LocalDateTime createdAt;

    public Maintenance() {
    }

    public Maintenance(int id, BodyType bodyType, String operationName, int operationCode, String description, String parts, int interval, LocalDateTime createdAt) {
        this.id = id;
        this.bodyType = bodyType;
        this.operationName = operationName;
        this.operationCode = operationCode;
        this.description = description;
        this.parts = parts;
        this.interval = interval;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
