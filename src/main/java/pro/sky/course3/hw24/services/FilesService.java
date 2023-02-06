package pro.sky.course3.hw24.services;

import java.io.File;

public interface FilesService {
    String getIngredientsDataFileName();

    String getRecipesDataFileName();

    boolean saveToJsonFile(String json, String dataFileName);

    String readFromJsonFile(String dataFileName);

    File getDataFile(String dataFileName);

    boolean cleanDataFile(String dataFileName);
}
