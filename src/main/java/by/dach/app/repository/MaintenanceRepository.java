package by.dach.app.repository;

import by.dach.app.model.dto.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository <Maintenance, Integer> {

}
