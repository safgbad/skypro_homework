package pro.sky.course3.coursework.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.course3.coursework.services.TempFilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TempFilesServiceImpl implements TempFilesService {
    @Value("${path.to.socks.temp.files}")
    private String tempFilesPath;

    @Override
    public Path createTempFile(String suffix) throws IOException {
        try {
            Path path = Path.of(tempFilesPath);
            Files.createDirectories(path);
            return Files.createTempFile(Path.of(tempFilesPath), "temp", suffix);
        } catch (IOException e) {
            throw new IOException("Unable to generate " + suffix + " file");
        }
    }
}
