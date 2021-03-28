package by.dach.app.controller;

import by.dach.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car-main";
    }

    // поиска авто по названию модели
    @GetMapping("show-car-by-model-jymper")
    public String findCarModel(Model model) {
        model.addAttribute("cars", carService.findAllCarByModel("Jymper"));
        return "show-list-car";
    }

    @GetMapping("show-car-after-2000")
    public String findCarYear(Model model) {
        model.addAttribute("cars", carService.findCarAfterYear(2000));
        return "show-list-car";
    }

    @GetMapping("show-car-in-year-interval-and-model")
    public String findCarYearIntervalModel(Model model) {
        model.addAttribute("cars", carService.findCarByYearIntervalAndModel(1998,
                2005, "Caddy"));
        return "show-list-car";
    }

    @GetMapping("show-car-by-part-name")
    public String findCarByPartName(Model model, @Param("pattern") String pattern) {
        model.addAttribute("cars", carService.findCarByPartModelName(pattern));
        return "show-list-car";
    }

    @GetMapping("show-car-younger-year")
    public String findCarYoungerYear(Model model, @Param("year") int year) {
        model.addAttribute("cars", carService.findCarYoungerYear(year));
        return "show-list-car";
    }

}

