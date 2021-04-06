package by.dach.app.controller;

import by.dach.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("show-car-by-year")
    public String findCarByYear(Model model, @Param("year1") int year1) {
        model.addAttribute("cars", carService.findCarByYear(year1));
        return "show-list-car";
    }

    @GetMapping("show-all-car-sorted-by-year")
    public String findAllCarSortedByYear(Model model) {
        model.addAttribute("cars", carService.findAllCarSortedByYear());
        return "show-list-car";
    }

    @GetMapping("show-price-all-car-by-transmission-type")
    public String findPriceAllByTransmission(Model model) {
        model.addAttribute("map", carService.findPriceAllByTransmission());
        return "show-map-car";
    }

    @GetMapping("show-car-by-transmission-type")
    public String findCarByTransmissionType(Model model) {
        model.addAttribute("map", carService.findCarByTransmissionType());
        return "show-map-with-list-car";
    }

    @GetMapping("show-car-by-volume")
    public String findCarByVolume(Model model) {
        model.addAttribute("map", carService.findCarByVolume());
        return "show-map-with-list-car";
    }

    @GetMapping("show-car-by-transmission-type-with-native-query")
    public String findCarByTransmissionTypeWithNativeQuery(Model model, @Param("tr_type") String tr_type) {
        model.addAttribute("cars", carService.findCarByTransmissionTypeWithNativeQuery(tr_type));
        return "show-list-car";
    }

    @GetMapping("delete-car-by-id")
    public String deleteCarById(@Param("id") int id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("edit-car-price-by-id")
    public String editCarPriceById(@Param("id") int id,
                                   @Param("price") int price) {
        carService.editCarPriceById(id, price);
        return "redirect:/cars";
    }

}

