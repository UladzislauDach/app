package by.dach.app.controller;

import by.dach.app.model.dto.CarFormDto;
import by.dach.app.model.dto.MaintenanceUploadForm;
import by.dach.app.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/cars")
public class CarController {
    static final Logger log = LoggerFactory.getLogger(CarController.class);

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
        model.addAttribute("car", new CarFormDto());
        return "car/form-of-creation";
    }

    @PostMapping("/save")
    public String createUser(CarFormDto carFormDto) {
        carService.saveCar(carFormDto);
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
        return "car/show-map-by-transmission";
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

    @GetMapping("add-maintenance-list")
    public String getMaintenanceForm(Model model) {
        model.addAttribute("maintenanceUpload", new MaintenanceUploadForm());
        return "car/add-maintenance-list-form";
    }

    @PostMapping("add-maintenance-list")
    public String addMaintenanceList(MaintenanceUploadForm maintenanceUploadForm) {
        log.info("File uploaded name {}, size {}", maintenanceUploadForm.getExcelFile().getOriginalFilename(),
                maintenanceUploadForm.getExcelFile().getSize());

        carService.addMaintenanceList(maintenanceUploadForm);
        return "redirect:/cars";
    }

}

