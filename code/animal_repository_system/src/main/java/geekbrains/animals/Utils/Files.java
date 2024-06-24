package geekbrains.animals.Utils;

import java.io.File;
import java.io.IOException;

public class Files {

    public static void createDirectoryAndFile(String filePath) {
        File file = new File(filePath);
        File directory = file.getParentFile();
        try {
            if (directory != null && !directory.exists()) {
                java.nio.file.Files.createDirectories(directory.toPath());
            }
            if (!file.exists()) {
                java.nio.file.Files.createFile(file.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
