package by.dach.app.model.dto;

public class UserFormDto {
    private String name;
    private int age;
    private int carId;

    public UserFormDto() {
    }

    public UserFormDto(String name, int age, int carId) {
        this.name = name;
        this.age = age;
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
