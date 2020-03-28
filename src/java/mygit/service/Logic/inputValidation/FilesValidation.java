package mygit.service.Logic.inputValidation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesValidation {
    public boolean isRepository(String SelectedRepository) {
        Path filePath = Paths.get(SelectedRepository + File.separator +".magit");
        return Files.exists(filePath);
    }
}
