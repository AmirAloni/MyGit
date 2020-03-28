package mygit.service.Logic.Objects;
import static mygit.service.Logic.ConstantsEnums.EmptyString;

public class Blob
{
    private String m_Data = EmptyString;

    public Blob(String i_Data){m_Data = i_Data;}

    public String getM_Data() {
        return m_Data;
    }
}
