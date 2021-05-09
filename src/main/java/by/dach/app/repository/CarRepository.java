package by.dach.app.repository;

import by.dach.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarByYearAfter(int year);

    List<Car> findCarByYearBetweenAndModelEquals(int firstYer, int secondYear, String model);

    @Query("select c from Car c where c.model like %?1%")
    List<Car> findCarByName(String partOfName);

    @Query("select c from Car c where c.year > ?1")
    List<Car> findCarYoungerYear(int year);

    @Query(value = "select * from cars c where c.transmission = ?1", nativeQuery = true)
    List<Car> findCarByTransmissionType(String transmission_type);

    @Modifying
    @Query("delete from Car c where c.id = :id")
    void deleteCarById(int id);

    @Modifying
    @Query(value = "update cars set price = :price where id = :id", nativeQuery = true)
    void editCarPriceById(int id, int price);

}
