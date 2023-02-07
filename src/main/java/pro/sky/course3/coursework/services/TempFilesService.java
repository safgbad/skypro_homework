package pro.sky.course3.coursework.services;

import java.io.IOException;
import java.nio.file.Path;

public interface TempFilesService {
    Path createTempFile(String suffix) throws IOException;
}
