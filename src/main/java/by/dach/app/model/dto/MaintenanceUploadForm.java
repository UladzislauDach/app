package by.dach.app.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class MaintenanceUploadForm {
    MultipartFile excelFile;

    public MaintenanceUploadForm(MultipartFile excelFile) {
        this.excelFile = excelFile;
    }

    public MaintenanceUploadForm() {
    }

    public MultipartFile getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(MultipartFile excelFile) {
        this.excelFile = excelFile;
    }
}
