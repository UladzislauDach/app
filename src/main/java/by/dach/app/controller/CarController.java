package by.dach.app.controller;

import by.dach.app.model.CarDTO;
import by.dach.app.model.User;
import by.dach.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "car/main";
    }

    @GetMapping("new")
    public String newCar(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "car/form-of-creation";
    }

    @PostMapping("/save")
    public String createUser(CarDTO carDTO) {
        carService.saveCar (carDTO);
        return "redirect:/";
    }

    @GetMapping("show-after-2000")
    public String findCarYear(Model model) {
        model.addAttribute("cars", carService.findAfterYear(2000));
        return "car/show-list";
    }

    @GetMapping("show-in-year-interval-and-model")
    public String findCarYearIntervalModel(Model model) {
        model.addAttribute("cars", carService.findByYearIntervalAndModel(1998,
                2005, "Audi"));
        return "car/show-list";
    }

    @GetMapping("show-by-part-name")
    public String findCarByPartName(Model model, @Param("pattern") String pattern) {
        model.addAttribute("cars", carService.findByPartModelName(pattern));
        return "car/show-list";
    }

    @GetMapping("show-younger-year")
    public String findCarYoungerYear(Model model, @Param("year") int year) {
        model.addAttribute("cars", carService.findYoungerYear(year));
        return "car/show-list";
    }

    @GetMapping("show-by-year")
    public String findCarByYear(Model model, @Param("year") int year) {
        model.addAttribute("cars", carService.findByYear(year));
        return "car/show-list";
    }

    @GetMapping("show-all-sorted-by-year")
    public String findAllCarSortedByYear(Model model) {
        model.addAttribute("cars", carService.findAllSortedByYear());
        return "car/show-list";
    }

    @GetMapping("show-price-all-by-transmission-type")
    public String findPriceAllByTransmission(Model model) {
        model.addAttribute("map", carService.findPriceAllByTransmission());
        return "car/show-map";
    }

    @GetMapping("show-by-transmission-type")
    public String findCarByTransmissionType(Model model) {
        model.addAttribute("map", carService.findByTransmissionType());
        return "car/show-map-with-list";
    }

    @GetMapping("show-by-volume")
    public String findCarByVolume(Model model) {
        model.addAttribute("map", carService.findByVolume());
        return "car/show-map-with-list";
    }

    @GetMapping("show-by-transmission-type-with-native-query")
    public String findCarByTransmissionTypeWithNativeQuery(Model model, @RequestParam("tr_type") String tr_type) {
        model.addAttribute("cars", carService.findByTransmissionTypeWithNativeQuery(tr_type));
        return "car/show-list";
    }

    @GetMapping("delete-by-id")
    public String deleteCarById(@Param("id") int id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("edit-price-by-id")
    public String editCarPriceById(@Param("id") int id,
                                   @Param("price") int price) {
        carService.editCarPriceById(id, price);
        return "redirect:/cars";
    }

}

