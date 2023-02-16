package pro.sky.course3.coursework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.OperationType;
import pro.sky.course3.coursework.services.OperationsService;
import pro.sky.course3.coursework.services.SocksService;
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;
    private final OperationsService operationsService;

    public SocksController(SocksService socksService, OperationsService operationsService) {
        this.socksService = socksService;
        this.operationsService = operationsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addSocks(@RequestBody ApiPairOfSocksDTO apiPairOfSocksDTO) {
        try {
            PairOfSocks pairOfSocks = socksService.addSocks(apiPairOfSocksDTO);
            operationsService.addOperation(pairOfSocks, apiPairOfSocksDTO.getQuantity(), OperationType.RECEIVING);
            return ResponseEntity.ok()
                    .body("Socks are successfully added");
        } catch (InvalidInputException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<String> addSocks(@RequestParam(required = false) String color,
                                           @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) Integer cottonPart,
                                           @RequestParam(required = false) Integer quantity) {
        try {
            // TODO: do another adding method
            PairOfSocks pairOfSocks = socksService.addSocks(new ApiPairOfSocksDTO(color, size, cottonPart, quantity));
            operationsService.addOperation(pairOfSocks, quantity, OperationType.RECEIVING);
            return ResponseEntity.ok()
                    .body("Socks are successfully added");
        } catch (InvalidInputException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getSocks(@RequestParam(required = false) String color,
                                           @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) Integer cottonMin,
                                           @RequestParam(required = false) Integer cottonMax) {
        try {
            return ResponseEntity.ok()
                    .body(socksService.getSocks(color, size, cottonMin, cottonMax));
        } catch (InvalidInputException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> releaseSocks(@RequestBody ApiPairOfSocksDTO apiPairOfSocksDTO) {
        try {
            PairOfSocks pairOfSocks = socksService.releaseSocks(apiPairOfSocksDTO);
            operationsService.addOperation(pairOfSocks, apiPairOfSocksDTO.getQuantity(), OperationType.RELEASE);
            return ResponseEntity.ok()
                    .body("Socks have been successfully released from the warehouse");
        } catch (InvalidInputException | NotEnoughSocksException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @PutMapping
    public ResponseEntity<String> releaseSocks(@RequestParam(required = false) String color,
                                               @RequestParam(required = false) Integer size,
                                               @RequestParam(required = false) Integer cottonPart,
                                               @RequestParam(required = false) Integer quantity) {
        try {
            PairOfSocks pairOfSocks = socksService.releaseSocks(
                    new ApiPairOfSocksDTO(color, size, cottonPart, quantity));
            operationsService.addOperation(pairOfSocks, quantity, OperationType.RELEASE);
            return ResponseEntity.ok()
                    .body("Socks have been successfully released from the warehouse");
        } catch (InvalidInputException | NotEnoughSocksException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> writeOffSocks(@RequestBody ApiPairOfSocksDTO apiPairOfSocksDTO) {
        try {
            PairOfSocks pairOfSocks = socksService.releaseSocks(apiPairOfSocksDTO);
            operationsService.addOperation(pairOfSocks, apiPairOfSocksDTO.getQuantity(), OperationType.WRITE_OFF);
            return ResponseEntity.ok()
                    .body("Socks have been successfully written off from the warehouse");
        } catch (InvalidInputException | NotEnoughSocksException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> writeOffSocks(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Integer size,
                                                @RequestParam(required = false) Integer cottonPart,
                                                @RequestParam(required = false) Integer quantity) {
        try {
            PairOfSocks pairOfSocks = socksService.releaseSocks(
                    new ApiPairOfSocksDTO(color, size, cottonPart, quantity));
            operationsService.addOperation(pairOfSocks, quantity, OperationType.WRITE_OFF);
            return ResponseEntity.ok()
                    .body("Socks have been successfully written off from the warehouse");
        } catch (InvalidInputException | NotEnoughSocksException e) {
            return ResponseEntity.badRequest()
                    .body(e.toString());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }

    @GetMapping("/export")
    public ResponseEntity<Object> downloadSocksDataFile() {
        try {
            Path path = socksService.generateExportFile();
            FileInputStream fis = new FileInputStream(path.toFile());
            InputStreamResource resource = new InputStreamResource(fis);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(Files.size(path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; " +
                            "filename = \"socks_export.json\"")
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
    public ResponseEntity<String> uploadSocksDataFile(@RequestParam MultipartFile file) {
        try {
            Map<PairOfSocks, Integer> socks = socksService.importSocks(file);
            operationsService.synchronize(socks);
            return ResponseEntity.ok()
                    .body("Socks data was successfully imported from file");
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
