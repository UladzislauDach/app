package by.dach.app.mappers;

import by.dach.app.model.Car;
import by.dach.app.model.CarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    //CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    Car carDtoToCar(CarDTO carDTO);
}
