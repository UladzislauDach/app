package by.dach.app.repository;

import by.dach.app.model.Transmission;
import by.dach.app.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.car.transmission = :tr_type")
    List<User> findAllUserByCarTransmissionType(Transmission tr_type);

    @Query("select u from User u where u.car.body.type = :bodyType")
    List<User> findAllUserByCarBodyType(String bodyType);

    Page<User> findAll (Pageable pageable);

    @Query("select u from User u where u.car.volume > :volume")
    Page<User> findAllUserWhereCarVolumeBiggest(Pageable pageable, int volume);
}
