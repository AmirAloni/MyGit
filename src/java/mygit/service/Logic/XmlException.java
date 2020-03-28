package mygit.service.Logic;

public class XmlException extends Exception {
    private String m_Path;

    public XmlException(String message) {
        super(message);
    }
    public XmlException(String message,String i_Path) {
        super(message);
        m_Path = i_Path;
    }

    public String getPath() {
        return m_Path;
    }
}