package pro.sky.course3.hw24.services;

public interface FilesService {
    boolean saveToJsonFile(String json, String dataFileName);

    String readFromJsonFile(String dataFileName);
}
