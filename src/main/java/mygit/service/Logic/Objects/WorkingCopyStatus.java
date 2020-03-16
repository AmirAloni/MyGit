package mygit.service.Logic.Objects;

import java.util.*;

public class WorkingCopyStatus
{
    private Set<String> m_DeletedFilesList;
    private List<String> m_ChangedFilesList = new ArrayList<>();
    private List<String> m_NewFilesList = new ArrayList<>();
    private List<String> m_NotChangedList= new ArrayList<>();
    private Map<String, String> m_PathSha1 = new HashMap<>();

    public Set<String> getM_DeletedFilesList() {
        return m_DeletedFilesList;
    }
    public List<String> getM_NotChangedFilesList() {
        return m_NotChangedList;
    }
    public void setM_DeletedFilesList(Set<String> i_DeletedFilesList) {

        this.m_DeletedFilesList = clone(i_DeletedFilesList);
    }

    private Set<String> clone(Set<String> i_deletedFilesList) {
        Set returnSet = new HashSet();
        for(String str : i_deletedFilesList)
            returnSet.add(str);
        return returnSet;
    }

    public void setM_NotChangedFilesList(Set<String> i_NotChangedList) {
        for(String str : i_NotChangedList)
        this.m_NotChangedList.add(str);
    }

    public void setM_NotChangedList(List<String> m_NotChangedList) {
        this.m_NotChangedList = m_NotChangedList;
    }

    public List<String> getM_NotChangedList() {
        return m_NotChangedList;
    }

    public Map<String, String> getM_PathSha1() {
        return m_PathSha1;
    }

    public List<String> getM_ChangedFilesList() {
        return m_ChangedFilesList;
    }
    public List<String> getM_NewFilesList() {
        return m_NewFilesList;
    }
    public Boolean isNotChanged()    {
        return (m_ChangedFilesList.size()==0 && m_NewFilesList.size()==0 && m_DeletedFilesList.isEmpty());
    }
    public Boolean IsEmpty()
    {
        return (m_DeletedFilesList.isEmpty() && m_ChangedFilesList.isEmpty() && m_NewFilesList.isEmpty());
    }

}