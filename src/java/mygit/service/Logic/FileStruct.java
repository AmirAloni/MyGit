package mygit.service.Logic;

import java.nio.file.Path;

public class FileStruct {

    private Path m_filePath;
    private ConstantsEnums.FileState m_fileState;

    public FileStruct(Path m_filePath, ConstantsEnums.FileState m_fileState) {
        this.m_filePath = m_filePath;
        this.m_fileState = m_fileState;
    }

    public Path getM_filePath() {
        return m_filePath;
    }

    public ConstantsEnums.FileState getM_fileState() {
        return m_fileState;
    }

    public void setM_filePath(Path m_filePath) {
        this.m_filePath = m_filePath;
    }

    public void setM_fileState(ConstantsEnums.FileState m_fileState) {
        this.m_fileState = m_fileState;
    }
}
