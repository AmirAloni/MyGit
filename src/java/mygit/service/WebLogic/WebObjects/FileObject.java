package mygit.service.WebLogic.WebObjects;

public class FileObject {
    String path;
    Boolean isFolder;

    public FileObject(String path, Boolean isFolder) {
        this.path = path;
        this.isFolder = isFolder;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFolder(Boolean folder) {
        isFolder = folder;
    }

    public String getPath() {
        return path;
    }

    public Boolean getFolder() {
        return isFolder;
    }
}
