package pro.sky.course3.coursework.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.dto.ApiOperationDTO;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.Color;
import pro.sky.course3.coursework.model.enums.OperationType;
import pro.sky.course3.coursework.model.enums.Size;
import pro.sky.course3.coursework.services.OperationsService;
import pro.sky.course3.coursework.services.TempFilesService;
import pro.sky.course3.coursework.services.SocksService;
import pro.sky.course3.coursework.util.ObjectConversion;
import pro.sky.course3.coursework.util.ValueCheck;
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class SocksServiceImpl implements SocksService {

    private final TempFilesService tempFilesService;
    private final OperationsService operationsService;

    private static Map<PairOfSocks, Integer> socks = new HashMap<>();

    public SocksServiceImpl(TempFilesService tempFilesService, OperationsService operationsService) {
        this.tempFilesService = tempFilesService;
        this.operationsService = operationsService;
    }

    @Override
    public void addSocks(ApiPairOfSocksDTO apiPairOfSocksDTO,
                         boolean isSynchronizing) throws InvalidInputException {
        PairOfSocks pairOfSocks = ObjectConversion.getPairOfSocksFromDTO(apiPairOfSocksDTO);
        ValueCheck.checkQuantity(apiPairOfSocksDTO.getQuantity());
        int quantity = apiPairOfSocksDTO.getQuantity();

        Integer currentQuantity;
        if ((currentQuantity = socks.putIfAbsent(pairOfSocks, quantity)) != null) {
            socks.put(pairOfSocks, currentQuantity + quantity);
        }

        if (!isSynchronizing) {
            operationsService.addOperation(pairOfSocks, quantity, OperationType.RECEIVING);
        }
    }

    @Override
    public int getSocks(String targetColor,
                        Integer targetSize,
                        Integer cottonMin,
                        Integer cottonMax) throws InvalidInputException {
        try {
            Color color = ObjectConversion.getColorFromString(targetColor);
            Size size = Size.getSize(targetSize);
            ValueCheck.checkCottonPart(cottonMin, true);
            ValueCheck.checkCottonPart(cottonMax, true);

            return socks.entrySet().stream()
                    .filter(entry -> entry.getKey().getColor() == color
                            && entry.getKey().getSize() == size
                            && entry.getKey().getCottonPart() <= Objects.requireNonNullElse(cottonMax, 100)
                            && entry.getKey().getCottonPart() >= Objects.requireNonNullElse(cottonMin, 0))
                    .map(Map.Entry::getValue)
                    .mapToInt(Integer::valueOf)
                    .sum();
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e);
        }
    }

    @Override
    public void releaseSocks(ApiPairOfSocksDTO apiPairOfSocksDTO,
                             boolean isWritingOff,
                             boolean isSynchronizing) throws InvalidInputException,
            NotEnoughSocksException {
        PairOfSocks pairOfSocks = ObjectConversion.getPairOfSocksFromDTO(apiPairOfSocksDTO);

        ValueCheck.checkQuantity(apiPairOfSocksDTO.getQuantity());
        int quantity = apiPairOfSocksDTO.getQuantity();

        Integer currentQuantity = socks.get(pairOfSocks);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new NotEnoughSocksException("Not enough socks in stock");
        }
        socks.put(pairOfSocks, currentQuantity - quantity);

        if (!isSynchronizing) {
            operationsService.addOperation(pairOfSocks,
                    quantity,
                    isWritingOff ? OperationType.WRITE_OFF : OperationType.RELEASE);
        }
    }

    @Override
    public Path generateExportFile() throws IOException, NothingToExportException {
        if (socks.isEmpty()) {
            throw new NothingToExportException();
        }
        Path path = tempFilesService.createTempFile("socksExport");
        List<ApiPairOfSocksDTO> listDTO = ObjectConversion.convertPairsOfSocksToListOfDTO(socks);
        String json = new ObjectMapper().writeValueAsString(listDTO);
        Files.writeString(path, json);

        return path;
    }

    @Override
    public void importSocks(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException {
        if (file.isEmpty()) {
            throw new NothingToImportException("Specified file is empty");
        }
        List<ApiPairOfSocksDTO> listDTO = new ObjectMapper()
                .readValue(file.getInputStream(), new TypeReference<>() {});
        socks = new HashMap<>();
        for (ApiPairOfSocksDTO dto : listDTO) {
            addSocks(dto, false);
        }
        operationsService.synchronize(socks);
    }

    @Override
    public void synchronize(List<ApiOperationDTO> operations) throws InvalidInputException, NotEnoughSocksException {
        socks = new HashMap<>();
        for (ApiOperationDTO operation : operations) {
            switch (ObjectConversion.getOperationTypeFromString(operation.getOperationType())) {
                case RECEIVING -> addSocks(operation.getSocks(), true);
                case WRITE_OFF, RELEASE -> releaseSocks(operation.getSocks(), false, true);
            }
        }
    }
}
