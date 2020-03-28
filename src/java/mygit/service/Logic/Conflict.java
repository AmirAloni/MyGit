package mygit.service.Logic;

public class Conflict {
    private FileStruct m_our;
    private FileStruct m_theirs;
    private FileStruct m_father;


    public Conflict(FileStruct m_our, FileStruct m_theirs, FileStruct m_father) {
        this.m_our = m_our;
        this.m_theirs = m_theirs;
        this.m_father = m_father;
    }

    public FileStruct getM_our() {
        return m_our;
    }

    public FileStruct getM_theirs() {
        return m_theirs;
    }

    public FileStruct getM_father() {
        return m_father;
    }
}
