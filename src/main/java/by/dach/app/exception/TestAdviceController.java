package by.dach.app.exception;

import org.apache.poi.EmptyFileException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestAdviceController {

    @ExceptionHandler({EmptyOrIllegalMaintenanceFileException.class})
    public String emptyOrIllegalMaintenanceFileException(EmptyOrIllegalMaintenanceFileException e,
                                                         Model model) {
        model.addAttribute("exception", e);
        return "error-page";
    }
}
