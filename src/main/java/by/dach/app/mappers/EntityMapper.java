package by.dach.app.mappers;

import by.dach.app.model.BodyType;
import by.dach.app.model.Car;
import by.dach.app.model.User;
import by.dach.app.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    @Mapping(target = "volume", source = "engineVolume")
    Car carDtoToCar(CarFormDto carFormDto);

    @Mappings({
            @Mapping(target = "creationAt", source = "carServiceInfo.creationAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(target = "innerCode", source = "carServiceInfo.innerCode")
    })
    CarListDto carToCarListDto(Car car);

    @Mapping(target = "car.id", source = "carId")
    @Mapping(target = "creationAt", expression = "java( java.time.LocalDateTime.now())")
    User userFormDtoToUser(UserFormDto userFormDto);

    @Mapping(target = "carId", source = "car.id")
    UserFormDto userToUserFormDto(User user);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "bodyType", expression = "java(bodyType)")
    Maintenance maintenanceDtoToMaintenance(MaintenanceDto maintenanceDto, BodyType bodyType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car", expression = "java(new Car(userFormDto.getCarId()))")
    void updateUserFromUserFormDto(UserFormDto userFormDto, @MappingTarget User user);

}
