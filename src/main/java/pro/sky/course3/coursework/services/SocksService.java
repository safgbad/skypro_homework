package pro.sky.course3.coursework.services;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.course3.coursework.dto.ApiOperationDTO;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.exceptions.NotEnoughSocksException;
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;
import pro.sky.course3.coursework.exceptions.NothingToExportException;
import pro.sky.course3.coursework.exceptions.NothingToImportException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface SocksService {
    void addSocks(ApiPairOfSocksDTO apiPairOfSocksDTO,
                  boolean isSynchronizing) throws InvalidInputException;

    int getSocks(String targetColor,
                 Integer targetSize,
                 Integer cottonMin,
                 Integer cottonMax) throws InvalidInputException;

    void releaseSocks(ApiPairOfSocksDTO apiPairOfSocksDTO,
                      boolean isWritingOff,
                      boolean isSynchronizing) throws InvalidInputException,
            NotEnoughSocksException;

    Path generateExportFile() throws IOException, NothingToExportException;

    void importSocks(MultipartFile file)
            throws NothingToImportException, InvalidInputException, IOException;

    void synchronize(List<ApiOperationDTO> operations) throws InvalidInputException, NotEnoughSocksException;
}
