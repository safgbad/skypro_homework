package pro.sky.course3.coursework.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.dto.ApiOperationDTO;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.Operation;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.OperationType;
import pro.sky.course3.coursework.services.OperationsService;
import pro.sky.course3.coursework.services.TempFilesService;
import pro.sky.course3.coursework.util.ObjectConversion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OperationsServiceImpl implements OperationsService {

    private final TempFilesService tempFilesService;

    private static int counter = 0;
    private static Map<Integer, Operation> operations = new HashMap<>();

    public OperationsServiceImpl(TempFilesService tempFilesService) {
        this.tempFilesService = tempFilesService;
    }

    @Override
    public void addOperation(PairOfSocks socks,
                             Integer quantity,
                             OperationType operationType) {
        operations.put(counter, new Operation(counter++,
                operationType,
                LocalDateTime.now(),
                socks,
                quantity));
    }

    public void addOperation(PairOfSocks socks,
                             Integer quantity,
                             OperationType operationType,
                             LocalDateTime dateTime) {
        operations.put(counter, new Operation(counter++,
                operationType,
                dateTime,
                socks,
                quantity));
    }

    @Override
    public Path generateExportFile() throws IOException, NothingToExportException {
        if (operations.isEmpty()) {
            throw new NothingToExportException();
        }
        Path path = tempFilesService.createTempFile("operationsExport");
        List<ApiOperationDTO> listDTO = ObjectConversion.convertOperationsToListOfDTO(operations);
        String json = new ObjectMapper().writeValueAsString(listDTO);
        Files.writeString(path, json);

        return path;
    }

    @Override
    public List<Operation> importOperations(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException {
        if (file.isEmpty()) {
            throw new NothingToImportException("Specified file is empty");
        }
        List<ApiOperationDTO> listDTO = new ObjectMapper()
                .readValue(file.getInputStream(), new TypeReference<>() {});
        operations = new HashMap<>();
        for (ApiOperationDTO dto : listDTO) {
            addOperation(ObjectConversion.getPairOfSocksFromDTO(dto.getSocks()),
                    dto.getSocks().getQuantity(),
                    ObjectConversion.getOperationTypeFromString(dto.getOperationType()),
                    LocalDateTime.parse(dto.getDateTime(), ApiOperationDTO.formatter));
        }

        return operations.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void synchronize(Map<PairOfSocks, Integer> socks) {
        operations = new HashMap<>();
        for (Map.Entry<PairOfSocks, Integer> entry : socks.entrySet()) {
            addOperation(entry.getKey(), entry.getValue(), OperationType.RECEIVING);
        }
    }
}
