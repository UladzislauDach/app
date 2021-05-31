package by.dach.app.model.dto;

public class MaintenanceDto {
    private String operationName;
    private int operationCode;
    private String description;
    private String parts;
    private int interval;


    public MaintenanceDto() {
    }

    public MaintenanceDto(String operationName, int operationCode, String description, String parts, int interval) {
        this.operationName = operationName;
        this.operationCode = operationCode;
        this.description = description;
        this.parts = parts;
        this.interval = interval;
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

    public static class Builder {
        private MaintenanceDto newMaintenanceDto;

        public Builder() {
            newMaintenanceDto = new MaintenanceDto();
        }

        public Builder setOperationName(String operationName) {
            newMaintenanceDto.operationName = operationName;
            return this;
        }

        public Builder setOperationCode(int operationCode) {
            newMaintenanceDto.operationCode = operationCode;
            return this;
        }

        public Builder setDescription(String description) {
            newMaintenanceDto.description = description;
            return this;
        }

        public Builder setParts(String parts) {
            newMaintenanceDto.parts = parts;
            return this;
        }

        public Builder setInterval(int interval) {
            newMaintenanceDto.interval = interval;
            return this;
        }

        public MaintenanceDto build(){
            return newMaintenanceDto;
        }
    }
}
