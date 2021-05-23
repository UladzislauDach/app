package by.dach.app.mappers;

import by.dach.app.model.Car;
import by.dach.app.model.User;
import by.dach.app.model.dto.UserFormDto;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public UserFormDto userToUserFormDto(User user) {
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setName(user.getName());
        userFormDto.setAge(user.getAge());
        userFormDto.setCarId(user.getCar().getId());
        return userFormDto;
    }

    public User userFormDtoToUser(UserFormDto userFormDto) {
        User user = new User();
        user.setName(userFormDto.getName());
        user.setAge(userFormDto.getAge());
        Car car = new Car();
        car.setId(userFormDto.getCarId());
        user.setCar(car);
        user.setCreationAt(LocalDateTime.now());
        return user;
    }

}
