package by.dach.app.service;

import by.dach.app.mappers.EntityMapper;
import by.dach.app.model.*;
import by.dach.app.model.dto.CarFormDto;
import by.dach.app.model.dto.CarListDto;
import by.dach.app.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final EntityMapper entityMapper;
    static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    public CarService(CarRepository carRepository, EntityMapper entityMapper) {
        this.carRepository = carRepository;
        this.entityMapper = entityMapper;
    }

    public Car saveCar(CarFormDto carFormDto) {
        Car car = entityMapper.carDtoToCar(carFormDto);
        car.setCarServiceInfo(new CarServiceInfo(LocalDateTime.now(), carFormDto.getModel() + carFormDto.getBodyType()));
        log.info("Entity Car successful writing/update in to database: {}, {}, {}", carFormDto.getModel(), carFormDto.getBodyType(), carFormDto.getEngineVolume());
        return carRepository.save(car);
    }

    public List<CarListDto> findAll() {
        return carRepository.findAll().stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    public List<CarListDto> findAfterYear(int year) {
        return carRepository.findCarByYearAfter(year).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    public List<CarListDto> findByYearIntervalAndModel(int firstYear, int secondYear, String model) {
        return carRepository.findCarByYearBetweenAndModelEquals(firstYear, secondYear, model).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    public List<CarListDto> findByPartModelName(String partOfName) {
        return carRepository.findCarByName(partOfName).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    public List<CarListDto> findYoungerYear(int year) {
        return carRepository.findCarYoungerYear(year).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    //получаем авто опред г.в. с помощью stream api (хоть это и неуместно здесь)
    public List<CarListDto> findByYear(int year) {
        Map<Integer, List<Car>> map = carRepository.findAll().stream()
                .collect(Collectors.groupingBy(Car::getYear));
        return map.get(year).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    //все авто с сортировкой по г.в. от старшего
    public List<CarListDto> findAllSortedByYear() {
        return carRepository.findAll().stream()
                .sorted((c1, c2) -> c2.getYear() - c1.getYear()).map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }


    public Map<Transmission, Integer> findPriceAllByTransmission() {
        return carRepository.findAll().stream()
                .collect(Collectors.groupingBy(Car::getTransmission, Collectors
                        .reducing(0, Car::getPrice, Integer::sum)));
    }

    public Map<Transmission, List<CarListDto>> findByTransmissionType() {
        return carRepository.findAll().stream().map(entityMapper::carToCarListDto)
                .collect(Collectors.groupingBy(CarListDto::getTransmission));
    }

    public Map<Integer, List<CarListDto>> findByVolume() {
        return carRepository.findAll().stream().map(entityMapper::carToCarListDto)
                .collect(Collectors.groupingBy(CarListDto::getVolume));
    }

    public List<CarListDto> findByTransmissionTypeWithNativeQuery(String tr_type) {
        return carRepository.findCarByTransmissionType(tr_type).stream().map(entityMapper::carToCarListDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteCarById(int id) {
        carRepository.deleteCarById(id);
        log.info("Entity Car successful delete from database ID:{}", id);
    }

    @Transactional
    public void editCarPriceById(int id, int price) {
        carRepository.editCarPriceById(id, price);
    }
}