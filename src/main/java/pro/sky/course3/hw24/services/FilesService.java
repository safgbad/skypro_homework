package pro.sky.course3.hw24.services;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    String getIngredientsDataFileName();

    String getRecipesDataFileName();

    boolean saveToJsonFile(String json, String dataFileName);

    String readFromJsonFile(String dataFileName);

    File getDataFile(String dataFileName);

    Path createTempFile(String suffix);

    boolean cleanDataFile(String dataFileName);
}
