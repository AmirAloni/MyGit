package mygit.service.Logic;

import java.text.SimpleDateFormat;

public class ConstantsEnums {

    public enum FileType {
        NONE,
        FILE,
        FOLDER,
        COMMIT
    }

    public enum FileState{
        CREATED,
        DELETED,
        UPDATED,
        NOTCHANGED,
        NONE
    }

    public enum DialogType {
        TEXT,
        ALERT
    }

    public static final String EmptyString = "";
    public static final String Separator = ", ";
    public static final Integer NameLength = 50;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-hh:mm:ss:sss");

}
