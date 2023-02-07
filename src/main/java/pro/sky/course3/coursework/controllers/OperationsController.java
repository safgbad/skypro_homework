package pro.sky.course3.coursework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.services.OperationsService;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/socks/operations")
public class OperationsController {

    private final OperationsService operationsService;

    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/export")
    public ResponseEntity<Object> downloadOperationsDataFile() {
        try {
            Path path = operationsService.generateExportFile();
            FileInputStream fis = new FileInputStream(path.toFile());
            InputStreamResource resource = new InputStreamResource(fis);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(Files.size(path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; " +
                            "filename = \"operations_export.json\"")
                    .body(resource);
        } catch (NothingToExportException e) {
            return ResponseEntity.noContent()
                    .build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @PutMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadOperationsDataFile(@RequestParam MultipartFile file) {
        try {
            operationsService.importOperations(file);
            return ResponseEntity.ok()
                    .body("Operations data was successfully imported from file");
        } catch (NothingToImportException e) {
            return ResponseEntity.badRequest()
                    .body("Uploaded file is empty");
        } catch (InvalidInputException | JsonProcessingException e) {
            return ResponseEntity.badRequest()
                    .body("Invalid file format");
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }
}
