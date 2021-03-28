package by.dach.app.repository;

import by.dach.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAll();

    List<Car> findCarByModel(String model);

    List<Car> findCarByYearAfter(int year);

    List<Car> findCarByYearBetweenAndModelEquals(int firstYer, int secondYear, String model);

    //поиск по части названия модели
    @Query ("select c from Car c where c.model like %?1%")
    List<Car> findCarByName(String partOfName);

    @Query ("select c from Car c where c.year > ?1")
    List<Car> findCarYoungerYear(int year);
}
