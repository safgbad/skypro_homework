package pro.sky.course3.coursework.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.Operation;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.Color;
import pro.sky.course3.coursework.model.enums.Size;
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

    private static Map<PairOfSocks, Integer> socks = new HashMap<>();

    public SocksServiceImpl(TempFilesService tempFilesService) {
        this.tempFilesService = tempFilesService;
    }

    @Override
    public PairOfSocks addSocks(ApiPairOfSocksDTO apiPairOfSocksDTO) throws InvalidInputException {
        PairOfSocks pairOfSocks = ObjectConversion.getPairOfSocksFromDTO(apiPairOfSocksDTO);
        ValueCheck.checkQuantity(apiPairOfSocksDTO.getQuantity());
        int quantity = apiPairOfSocksDTO.getQuantity();

        Integer currentQuantity;
        if ((currentQuantity = socks.putIfAbsent(pairOfSocks, quantity)) != null) {
            socks.put(pairOfSocks, currentQuantity + quantity);
        }

        return pairOfSocks;
    }

    private void addSocks(PairOfSocks pairOfSocks, Integer quantity) throws InvalidInputException {
        ValueCheck.checkQuantity(quantity);

        Integer currentQuantity;
        if ((currentQuantity = socks.putIfAbsent(pairOfSocks, quantity)) != null) {
            socks.put(pairOfSocks, currentQuantity + quantity);
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
    public PairOfSocks releaseSocks(ApiPairOfSocksDTO apiPairOfSocksDTO) throws InvalidInputException,
            NotEnoughSocksException {
        PairOfSocks pairOfSocks = ObjectConversion.getPairOfSocksFromDTO(apiPairOfSocksDTO);

        ValueCheck.checkQuantity(apiPairOfSocksDTO.getQuantity());
        int quantity = apiPairOfSocksDTO.getQuantity();

        Integer currentQuantity = socks.get(pairOfSocks);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new NotEnoughSocksException("Not enough socks in stock");
        }
        socks.put(pairOfSocks, currentQuantity - quantity);

        return pairOfSocks;
    }

    private void releaseSocks(PairOfSocks pairOfSocks,
                              Integer quantity) throws InvalidInputException, NotEnoughSocksException {
        ValueCheck.checkQuantity(quantity);

        Integer currentQuantity = socks.get(pairOfSocks);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new NotEnoughSocksException("Not enough socks in stock");
        }
        socks.put(pairOfSocks, currentQuantity - quantity);
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
    public Map<PairOfSocks, Integer> importSocks(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException {
        if (file.isEmpty()) {
            throw new NothingToImportException("Specified file is empty");
        }
        List<ApiPairOfSocksDTO> listDTO = new ObjectMapper()
                .readValue(file.getInputStream(), new TypeReference<>() {});
        socks = new HashMap<>();
        for (ApiPairOfSocksDTO dto : listDTO) {
            addSocks(dto);
        }

        return socks;
    }

    @Override
    public void synchronize(List<Operation> operations)
            throws InvalidInputException, NotEnoughSocksException {
        socks = new HashMap<>();
        for (Operation operation : operations) {
            switch (operation.getOperationType()) {
                case RECEIVING -> addSocks(operation.getSocks(), operation.getQuantity());
                case WRITE_OFF, RELEASE -> releaseSocks(operation.getSocks(), operation.getQuantity());
            }
        }
    }
}
