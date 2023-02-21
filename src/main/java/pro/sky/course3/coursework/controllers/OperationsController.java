package pro.sky.course3.coursework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.Operation;
import pro.sky.course3.coursework.services.OperationsService;
import pro.sky.course3.coursework.services.SocksService;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Tag(name = "Операции с носками", description = "Импорт/экспорт")
@RestController
@RequestMapping("/api/socks/operations")
public class OperationsController {

    private final SocksService socksService;
    private final OperationsService operationsService;

    public OperationsController(SocksService socksService, OperationsService operationsService) {
        this.socksService = socksService;
        this.operationsService = operationsService;
    }

    @io.swagger.v3.oas.annotations.Operation(
            summary = "Экспорт операций с носками"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE),
                    },
                    description = "JSON-файл успешно сгенерирован и экспортирован"
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Нет ни одной операции с носками"
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Внутренняя ошибка сервера"
            )
    })
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

    @io.swagger.v3.oas.annotations.Operation(
            summary = "Импорт операций с носками",
            description = "Импортированные операции заменяют все имеющиеся," +
                    "операции синхронизируются с данными о наличии носков на складе"
    )
    @Parameters(value = {
            @Parameter(
                    name = "file",
                    content = {
                            @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
                    }
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Операции с носками успешно импортированы"
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Ошибка во входных данных"
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Внутренняя ошибка сервера"
            )
    })
    @PutMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadOperationsDataFile(@RequestParam MultipartFile file) {
        try {
            List<Operation> operations = operationsService.importOperations(file);
            socksService.synchronize(operations);
            return ResponseEntity.ok()
                    .body("Operations data was successfully imported from file");
        } catch (NothingToImportException e) {
            return ResponseEntity.badRequest()
                    .body("Uploaded file is empty");
        } catch (InvalidInputException | JsonProcessingException | NotEnoughSocksException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }
}
