package by.dach.app.mappers;

import by.dach.app.model.Car;
import by.dach.app.model.User;
import by.dach.app.model.dto.CarFormDto;
import by.dach.app.model.dto.CarListDto;
import by.dach.app.model.dto.UserFormDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    //CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    @Mapping(target = "volume", source = "engineVolume")
    Car carDtoToCar(CarFormDto carFormDto);

    CarListDto carToCarViewDto (Car car);

    @Mapping(target = "car.id", source = "carId")
    User userFormDtoToUser(UserFormDto userFormDto);

    @Mapping(target = "carId", source = "car.id")
    UserFormDto userToUserFormDto (User user);
}
