package by.dach.app.service;

import by.dach.app.model.Car;
import by.dach.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findAllCarByModel(String model) {
        return carRepository.findCarByModel(model);
    }

    public List<Car> findCarAfterYear(int year) {
        return carRepository.findCarByYearAfter(year);
    }

    public List<Car> findCarByYearIntervalAndModel(int firstYear, int secondYear, String model) {
        return carRepository.findCarByYearBetweenAndModelEquals(firstYear, secondYear, model);
    }

    public List<Car> findCarByPartModelName(String partOfName){
        return carRepository.findCarByName(partOfName);
    }

    public List<Car>findCarYoungerYear(int year){
        return carRepository.findCarYoungerYear(year);
    }

    public List<Car> getAllById(){
        return carRepository.findAll();
    }

}