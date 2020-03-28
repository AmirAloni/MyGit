package mygit.service.Logic.Objects;

import static mygit.service.Logic.ConstantsEnums.EmptyString;

public class BranchData {

    private String m_BranchName = EmptyString;
    private Boolean m_IsActive = false;
    private String m_CommitSha1 = EmptyString;
    private String m_CommitMessage = EmptyString;

    public BranchData(String i_BranchName, Boolean i_IsActive, String i_CommitSha1, String i_CommitMessage)
    {
        m_BranchName = i_BranchName;
        m_IsActive =i_IsActive;
        m_CommitSha1 =i_CommitSha1;
        m_CommitMessage =i_CommitMessage;
    }

    public String getM_BranchName() {
        return m_BranchName;
    }
    public Boolean getM_IsActive() {
        return m_IsActive;
    }
    public String getM_CommitSha1() {
        return m_CommitSha1;
    }
    public String getM_CommitMessage() {
        return m_CommitMessage;
    }

    @Override
    public String toString() {
        String stringOfBranchData=EmptyString;
        if (this.getM_IsActive())
            stringOfBranchData +=("(Active Branch) -> ");
        stringOfBranchData += ("Branch Name:    " + this.getM_BranchName() + System.lineSeparator());
        stringOfBranchData += ("------------------------------" + System.lineSeparator());
        stringOfBranchData += ("Commit Sha1:    " + this.getM_CommitSha1() + System.lineSeparator());
        stringOfBranchData += ("Commit Message: " + this.getM_CommitMessage() + System.lineSeparator()+System.lineSeparator());
        return stringOfBranchData;
    }
}