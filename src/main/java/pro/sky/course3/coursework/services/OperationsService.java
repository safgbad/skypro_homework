package pro.sky.course3.coursework.services;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.OperationType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface OperationsService {
    void addOperation(PairOfSocks socks, Integer quantity, OperationType operationType);

    Path generateExportFile() throws IOException, NothingToExportException;

    void importOperations(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException, NotEnoughSocksException;

    void synchronize(Map<PairOfSocks, Integer> socks);
}
