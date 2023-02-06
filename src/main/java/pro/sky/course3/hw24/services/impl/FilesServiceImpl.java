package pro.sky.course3.hw24.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.course3.hw24.services.FilesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {

    @Value("${path.to.data.files}")
    private String dataFilesPath;
    @Value("${name.of.ingredients.data.file}")
    private String ingredientsDataFileName;
    @Value("${name.of.recipes.data.file}")
    private String recipesDataFileName;

    public String getDataFilesPath() {
        return dataFilesPath;
    }

    @Override
    public String getIngredientsDataFileName() {
        return ingredientsDataFileName;
    }

    @Override
    public String getRecipesDataFileName() {
        return recipesDataFileName;
    }

    @Override
    public boolean saveToJsonFile(String json, String dataFileName) {
        Path path = Path.of(dataFilesPath, dataFileName);
        try {
            cleanDataFile(dataFileName);
            Files.writeString(path, json);
            return true;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromJsonFile(String dataFileName) {
        try {
            return Files.readString(Path.of(dataFilesPath, dataFileName));
        } catch (NoSuchFileException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getDataFile(String dataFileName) {
        return new File(dataFilesPath + '/' + dataFileName);
    }

    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilesPath),
                    "temp", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFile(String dataFileName) {
        Path path = Path.of(dataFilesPath, dataFileName);
        try {
            Files.createDirectories(path.getParent());
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
