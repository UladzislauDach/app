package by.dach.app.mappers;

import by.dach.app.model.Car;
import by.dach.app.model.User;
import by.dach.app.model.dto.CarFormDto;
import by.dach.app.model.dto.CarListDto;
import by.dach.app.model.dto.UserFormDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    //CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    @Mapping(target = "volume", source = "engineVolume")
    Car carDtoToCar(CarFormDto carFormDto);

    @Mappings({
            @Mapping(target = "creationAt", source = "carServiceInfo.creationAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(target = "innerCode", source = "carServiceInfo.innerCode")
    })
    CarListDto carToCarListDto(Car car);


    @Mapping(target = "car.id", source = "carId")
    User userFormDtoToUser(UserFormDto userFormDto);

    @Mapping(target = "carId", source = "car.id")
    UserFormDto userToUserFormDto(User user);
}
