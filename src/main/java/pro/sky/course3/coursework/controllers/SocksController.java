package pro.sky.course3.coursework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.OperationType;
import pro.sky.course3.coursework.services.OperationsService;
import pro.sky.course3.coursework.services.SocksService;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Tag(name = "Носки", description = "CRUD-операции, импорт/экспорт")
@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;
    private final OperationsService operationsService;

    public SocksController(SocksService socksService, OperationsService operationsService) {
        this.socksService = socksService;
        this.operationsService = operationsService;
    }

    @Operation(
            summary = "Добавление партии носков",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "apiPairOfSocksDTO",
                    schema = @Schema(implementation = ApiPairOfSocksDTO.class)
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Партия носков успешно добавлена"
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
    @PostMapping(path = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @Operation(
            summary = "Добавление партии носков",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "color",
                    example = "red"
            ),
            @Parameter(
                    name = "size",
                    example = "39"
            ),
            @Parameter(
                    name = "cottonPart",
                    example = "98"
            ),
            @Parameter(
                    name = "quantity",
                    example = "15"
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Партия носков успешно добавлена"
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
    @PostMapping
    public ResponseEntity<String> addSocksParam(@RequestParam(required = false) String color,
                                           @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) Integer cottonPart,
                                           @RequestParam(required = false) Integer quantity) {
        try {
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

    @Operation(
            summary = "Получить остаток носков на складе",
            description = "Остаток можно получить по конкретным цвету и размеру и по интервалу содержания хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "color",
                    example = "red"
            ),
            @Parameter(
                    name = "size",
                    example = "39"
            ),
            @Parameter(
                    name = "cottonMin",
                    example = "50"
            ),
            @Parameter(
                    name = "cottonMax",
                    example = "100"
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(type = "integer", format = "int64")
                            )
                    },
                    description = "Остаток высчитан"
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

    @Operation(
            summary = "Отпуск партии носков со склада",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "apiPairOfSocksDTO",
                    schema = @Schema(implementation = ApiPairOfSocksDTO.class)
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Носки успешно отпущены со склада"
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
    @PutMapping(path = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @Operation(
            summary = "Отпуск партии носков со склада",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "color",
                    example = "red"
            ),
            @Parameter(
                    name = "size",
                    example = "39"
            ),
            @Parameter(
                    name = "cottonPart",
                    example = "98"
            ),
            @Parameter(
                    name = "quantity",
                    example = "15"
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Носки успешно отпущены со склада"
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
    @PutMapping
    public ResponseEntity<String> releaseSocksParam(@RequestParam(required = false) String color,
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

    @Operation(
            summary = "Списание партии бракованных носков со склада",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "apiPairOfSocksDTO",
                    schema = @Schema(implementation = ApiPairOfSocksDTO.class)
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Носки успешно списаны"
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
    @DeleteMapping(path = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @Operation(
            summary = "Списание партии бракованных носков со склада",
            description = "Партия состоит из носков одного цвета, размера и с одинаковым содержанием хлопка"
    )
    @Parameters(value = {
            @Parameter(
                    name = "color",
                    example = "red"
            ),
            @Parameter(
                    name = "size",
                    example = "39"
            ),
            @Parameter(
                    name = "cottonPart",
                    example = "98"
            ),
            @Parameter(
                    name = "quantity",
                    example = "15"
            )
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(mediaType = "text/plain")
                    },
                    description = "Носки успешно списаны"
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

    @Operation(
            summary = "Экспорт данных о наличии носков на складе"
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
                    description = "Носки на складе отсутствуют"
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

    @Operation(
            summary = "Импорт данных о носках",
            description = "Импортированные носки заменяют все имеющиеся, носки синхронизируются с операциями"
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
                    description = "Данные о носках успешно импортированы"
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
                    .body(e.toString());
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body(e.toString());
        }
    }
}
