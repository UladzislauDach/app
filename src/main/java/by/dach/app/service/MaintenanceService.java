package by.dach.app.service;

import by.dach.app.mappers.EntityMapper;
import by.dach.app.model.BodyType;
import by.dach.app.model.dto.Maintenance;
import by.dach.app.model.dto.MaintenanceDto;
import by.dach.app.model.dto.MaintenanceUploadForm;
import by.dach.app.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MaintenanceService {


    private final MaintenanceExcelParser maintenanceExcelParser;
    private final MaintenanceRepository maintenanceRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public MaintenanceService(MaintenanceExcelParser maintenanceExcelParser, MaintenanceRepository maintenanceRepository, EntityMapper entityMapper) {
        this.maintenanceExcelParser = maintenanceExcelParser;
        this.maintenanceRepository = maintenanceRepository;
        this.entityMapper = entityMapper;
    }

    public void addMaintenanceList(MaintenanceUploadForm file) {
        Map<BodyType, List<MaintenanceDto>> maintenanceMap = maintenanceExcelParser.getMaintenanceMap(file.getExcelFile());
        Iterator<BodyType> iterator = maintenanceMap.keySet().iterator();
        while (iterator.hasNext()) {
            BodyType bodyType = iterator.next();
            for (MaintenanceDto a : maintenanceMap.get(bodyType)){
                Maintenance maintenance = entityMapper.maintenanceDtoToMaintenance(a);
                maintenance.setBodyType(bodyType);
                maintenanceRepository.save(maintenance);
            }
        }

    }
}
