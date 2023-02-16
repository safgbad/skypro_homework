package pro.sky.course3.coursework.services;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.Operation;
import pro.sky.course3.coursework.model.PairOfSocks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SocksService {
    PairOfSocks addSocks(ApiPairOfSocksDTO apiPairOfSocksDTO) throws InvalidInputException;

    int getSocks(String targetColor,
                 Integer targetSize,
                 Integer cottonMin,
                 Integer cottonMax) throws InvalidInputException;

    PairOfSocks releaseSocks(ApiPairOfSocksDTO apiPairOfSocksDTO) throws InvalidInputException,
            NotEnoughSocksException;

    Path generateExportFile() throws IOException, NothingToExportException;

    Map<PairOfSocks, Integer> importSocks(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException;

    void synchronize(List<Operation> operations) throws InvalidInputException, NotEnoughSocksException;
}
