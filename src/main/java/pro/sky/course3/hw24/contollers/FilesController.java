package pro.sky.course3.hw24.contollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.apache.commons.io.IOUtils;

import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pro.sky.course3.hw24.services.FilesService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/files")
@Tag(name = "Работа с файлами", description = "Импорт/экспорт файлов данных")
public class FilesController {
    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @Operation(
            summary = "Выгрузка файлов в формате JSON",
            description = "Значения entity:" +
                    "\"ingredient\"(ингредиенты)," +
                    "\"recipe\"(рецепты)"
    )
    @Parameters(value = {
            @Parameter(
                    name = "entity",
                    example = "ingredient"
            )}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Файл успешно выгружен"
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Запрашиваемый файл отсутствует на сервере"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Указано некорректное значение entity"
            )
    })
    @GetMapping("/export/{entity}")
    public ResponseEntity<InputStreamResource> downloadDataFile(
            @PathVariable String entity) throws FileNotFoundException {
        String dataFileName = recognizeEntity(entity);
        if (dataFileName == null) {
            return ResponseEntity.badRequest().build();
        }
        File dataFile = filesService.getDataFile(dataFileName);

        if (dataFile.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(dataFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(dataFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; " +
                            "filename = \"" + dataFileName + "\"")
                    .body(resource);
        }

        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Загрузка данных из JSON",
            description = "Значения entity:" +
                    "\"ingredient\"(ингредиенты)," +
                    "\"recipe\"(рецепты)"
    )
    @Parameters(value = {
            @Parameter(
                    name = "entity",
                    example = "ingredient"
            )}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Данные успешно обновлены"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Указано некорректное значение entity"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Внутренняя ошибка"
            )
    })
    @PostMapping(path = "/export/{entity}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFile(
            @PathVariable String entity,
            @RequestParam MultipartFile file) {
        String dataFileName = recognizeEntity(entity);
        if (dataFileName == null) {
            return ResponseEntity.badRequest().build();
        }
        filesService.cleanDataFile(dataFileName);
        File dataFile = filesService.getDataFile(dataFileName);

        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    private String recognizeEntity(String pathVariable) {
        return switch (pathVariable) {
            case "ingredient" -> filesService.getIngredientsDataFileName();
            case "recipe" -> filesService.getRecipesDataFileName();
            default -> null;
        };
    }
}
