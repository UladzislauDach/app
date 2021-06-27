package by.dach.app.service;

import by.dach.app.model.BodyType;
import by.dach.app.model.dto.MaintenanceDto;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class MaintenanceExcelParser {
    private static final Logger log = LoggerFactory.getLogger(MaintenanceService.class);

    private Workbook parseWorkbook(MultipartFile file) {
        Workbook workbook = null;
        try (InputStream inputStream = file.getInputStream()) {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            log.error("IO error in MaintenanceExcelParser");
        }
        return workbook;
    }

    public Map<BodyType, List<MaintenanceDto>> getMaintenanceMap(MultipartFile file) {
        Workbook workbook = parseWorkbook(file);
        int sheetQuantity = workbook.getNumberOfSheets();
        Map<BodyType, List<MaintenanceDto>> result = new HashMap<>();
        for (int i = 0; i < sheetQuantity; i++) {
            String sheetName = workbook.getSheetName(i);
            BodyType bodyType = BodyType.parseFromString(sheetName);
            MaintenanceDto maintenanceDto;
            List<MaintenanceDto> list = new ArrayList<>();
            Iterator<Row> iterator = workbook.getSheet(sheetName).rowIterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                maintenanceDto = new MaintenanceDto.Builder()
                        .setOperationName(row.getCell(0).getStringCellValue())
                        .setOperationCode((int) row.getCell(1).getNumericCellValue())
                        .setDescription(row.getCell(2).getStringCellValue())
                        .setParts(row.getCell(3).getStringCellValue())
                        .setInterval((int) row.getCell(4).getNumericCellValue())
                        .build();
                list.add(maintenanceDto);
            }
            result.put(bodyType, list);
        }
        return result;
    }
}
