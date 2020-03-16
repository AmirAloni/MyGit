package mygit.service.Logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static mygit.service.Logic.ConstantsEnums.EmptyString;

public class InputValidation
{
    public Boolean checkInputStringLen(String i_String) {
        return (!(i_String.length()==0) && !(i_String.length() > 50));
    }
    public Boolean checkInputActiveRepository(String i_ActiveRepository) {
        Path RepositoryPath = Paths.get(i_ActiveRepository  + File.separator + ".magit");
        return Files.exists(RepositoryPath);
    }
}
