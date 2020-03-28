package mygit.service.Logic;

import java.nio.file.Path;

public class OpenChange {
    private FileStruct m_fileStruct;

    public OpenChange(Path m_filePath, ConstantsEnums.FileState m_fileState) {
        m_fileStruct= new FileStruct(m_filePath,m_fileState);
    }

    public Path getM_filePath() {
        return m_fileStruct.getM_filePath();
    }

    public ConstantsEnums.FileState getM_fileState() {
        return m_fileStruct.getM_fileState();
    }

    public void setM_filePath(Path m_filePath) {
        this.m_fileStruct.setM_filePath(m_filePath);
    }

    public void setM_fileState(ConstantsEnums.FileState m_fileState) {
        this.m_fileStruct.setM_fileState(m_fileState);
    }
}
