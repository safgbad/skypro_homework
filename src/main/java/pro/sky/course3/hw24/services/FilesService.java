package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.exceptions.UnableToCreateTempFile;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public interface FilesService {
    String getIngredientsDataFileName();

    String getRecipesDataFileName();

    boolean saveToJsonFile(String json, String dataFileName);

    String readFromJsonFile(String dataFileName) throws NoSuchFileException;

    File getDataFile(String dataFileName);

    Path createTempFile(String suffix) throws UnableToCreateTempFile;

    boolean cleanDataFile(String dataFileName);
}
