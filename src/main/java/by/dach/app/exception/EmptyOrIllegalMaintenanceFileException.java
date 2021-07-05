package by.dach.app.exception;

public class EmptyOrIllegalMaintenanceFileException extends IllegalArgumentException {
    public EmptyOrIllegalMaintenanceFileException(String message) {
        super(message);
    }

    public EmptyOrIllegalMaintenanceFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
