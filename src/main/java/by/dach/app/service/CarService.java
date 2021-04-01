package by.dach.app.service;

import by.dach.app.model.Car;
import by.dach.app.model.Transmission;
import by.dach.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Car> findCarByPartModelName(String partOfName) {
        return carRepository.findCarByName(partOfName);
    }

    public List<Car> findCarYoungerYear(int year) {
        return carRepository.findCarYoungerYear(year);
    }

    //получаем авто опред г.в. с помощью stream api (хоть это и неуместно здесь)
    public List<Car> findCarByYear(int year) {
        Map<Integer, List<Car>> map = carRepository.findAll().stream()
                .collect(Collectors.groupingBy(car -> car.getYear()));
        return map.get(year);
    }

    //все авто с сортировкой по г.в. от старшего
    public List<Car> findAllCarSortedByYear() {
        List<Car> cars = carRepository.findAll().stream()
                .sorted((c1, c2) -> c2.getYear() - c1.getYear()).collect(Collectors.toList());
        return cars;
    }


    public Map<Transmission, Integer> findPriceAllByTransmission() {
        Map<Transmission, Integer> map = carRepository.findAll().stream()
                .collect(Collectors.groupingBy(Car::getTransmission, Collectors
                        .reducing(0, Car::getPrice, Integer::sum)));
//        for (Map.Entry<Transmission, Integer> temp : map.entrySet()) {
//            System.out.println(temp.getKey() + " " + temp.getValue());
//        }
        return map;
    }

    public Map<Transmission, List<Car>> findCarByTransmissionType() {
        Map<Transmission, List<Car>> map = carRepository.findAll().stream()
                .collect(Collectors.groupingBy(Car::getTransmission));
        return map;
    }
}