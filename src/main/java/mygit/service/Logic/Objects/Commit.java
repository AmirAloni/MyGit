package mygit.service.Logic.Objects;
import static mygit.service.Logic.ConstantsEnums.EmptyString;
import static mygit.service.Logic.ConstantsEnums.Separator;


public class Commit {
    private String m_MainSHA1 = EmptyString;
    private String m_PreviousSHA1 = EmptyString;
    private String m_PreviousSHA1merge = EmptyString;
    private String m_Message = EmptyString;
    private String m_CreatedTime = EmptyString;
    private String m_CreatedBy = EmptyString;

    public Commit(){ }
    public Commit(String i_CommitDescription){   // add m_PreviousSHA1merge
        String[] CommitString = i_CommitDescription.split(Separator);
        m_MainSHA1 = CommitString[0];
        m_PreviousSHA1 = CommitString[1];
        m_Message = CommitString[2];
        m_CreatedTime = CommitString[3];
        m_CreatedBy = CommitString[4];
    }

    public void setM_MainSHA1(String m_MainSHA1) {
        this.m_MainSHA1 = m_MainSHA1;
    }
    public void setM_Message(String m_Message) {
        this.m_Message = m_Message;
    }
    public void setM_CreatedTime(String m_CreatedTime) {
        this.m_CreatedTime = m_CreatedTime;
    }
    public void setM_CreatedBy(String m_CreatedBy) {
        this.m_CreatedBy = m_CreatedBy;
    }
    public void setM_PreviousSHA1(String m_PreviousSHA1) {
        this.m_PreviousSHA1 = m_PreviousSHA1;
    }
    public void setM_PreviousSHA1merge(String m_PreviousSHA1merge) {
        this.m_PreviousSHA1merge = m_PreviousSHA1merge;
    }
    public String getM_MainSHA1() {
        return m_MainSHA1;
    }
    public String getM_PreviousSHA1() {
        return m_PreviousSHA1;
    }
    public String getM_Message() {
        return m_Message;
    }
    public String getM_CreatedTime() {
        return m_CreatedTime;
    }
    public String getM_CreatedBy() {
        return m_CreatedBy;
    }

    @Override
    public String toString() {
        return m_MainSHA1 + Separator + m_PreviousSHA1 + Separator
                + m_Message + Separator + m_CreatedTime + Separator + m_CreatedBy;
    }


}
