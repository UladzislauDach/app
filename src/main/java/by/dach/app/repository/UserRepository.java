package by.dach.app.repository;

import by.dach.app.model.Car;
import by.dach.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
}
