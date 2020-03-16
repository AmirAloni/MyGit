package mygit.service.WebLogic.WebObjects;

import mygit.service.Logic.Objects.Commit;

public class Repository {
    private String m_Name = "";
    private String m_ActiveBranch = "";
    private String m_BranchesNumber = "";
    private String m_LastCommitTime = "";
    private String m_LastCommitMsg = "";

    public String getName() {
        return m_Name;
    }

    public void setName(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getActiveBranch() {
        return m_ActiveBranch;
    }

    public void setActiveBranch(String m_ActiveBranch) {
        this.m_ActiveBranch = m_ActiveBranch;
    }

    public String getBranchesNumber() {
        return m_BranchesNumber;
    }

    public void setBranchesNumber(String m_BranchesNumber) {
        this.m_BranchesNumber = m_BranchesNumber;
    }

    public String getLastCommitTime() {
        return m_LastCommitTime;
    }

    public String getLastCommitMessege() {
        return m_LastCommitMsg;
    }

    public void setLastCommitTime(String m_LastCommitTime) {
        this.m_LastCommitTime = m_LastCommitTime;
    }

    public void setLastCommitMsg(String m_LastCommitMsg) {
        this.m_LastCommitMsg = m_LastCommitMsg;
    }
}
