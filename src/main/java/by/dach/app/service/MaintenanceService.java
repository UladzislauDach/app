package by.dach.app.service;

import by.dach.app.mappers.EntityMapper;
import by.dach.app.model.BodyType;
import by.dach.app.model.dto.Maintenance;
import by.dach.app.model.dto.MaintenanceDto;
import by.dach.app.model.dto.MaintenanceUploadForm;
import by.dach.app.repository.MaintenanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MaintenanceService {

    private static final Logger log = LoggerFactory.getLogger(MaintenanceService.class);
    private final MaintenanceExcelParser maintenanceExcelParser;
    private final MaintenanceRepository maintenanceRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public MaintenanceService(MaintenanceExcelParser maintenanceExcelParser, MaintenanceRepository maintenanceRepository, EntityMapper entityMapper) {
        this.maintenanceExcelParser = maintenanceExcelParser;
        this.maintenanceRepository = maintenanceRepository;
        this.entityMapper = entityMapper;
    }

    @Transactional
    public void addMaintenanceList(MaintenanceUploadForm file) {
        Map<BodyType, List<MaintenanceDto>> maintenanceMap = maintenanceExcelParser.getMaintenanceMap(file.getExcelFile());
        for (BodyType bodyType : maintenanceMap.keySet()) {
            for (MaintenanceDto entity : maintenanceMap.get(bodyType)) {
                Maintenance maintenance = entityMapper.maintenanceDtoToMaintenance(entity, bodyType);
                maintenanceRepository.save(maintenance);
                log.info("Maintenance list for {} add to DB. Id: {}", maintenance.getBodyType(), maintenance.getId());
            }
        }
    }
}
