package mygit.service.Logic.Objects;
import java.util.ArrayList;
import java.util.List;

import static mygit.service.Logic.ConstantsEnums.EmptyString;

public class Folder
{
    private List<BlobData> LibraryFiles;
    private Boolean rootFolder = false;

    public Folder() {
        LibraryFiles = new ArrayList<>();
    }
    public Folder(String i_FolderContent) {
        String[] blobDataStrings = i_FolderContent.split(" ~ ");
        LibraryFiles = new ArrayList<>();
        for(String blobData : blobDataStrings)
        {
            LibraryFiles.add(new BlobData(blobData));
        }
    }

    public List<BlobData> getLibraryFiles() {
        return LibraryFiles;
    }
    public String printArray() {
        String ArrayString=EmptyString;
        for(BlobData blob : LibraryFiles) {
            if (blob != null)
                ArrayString += blob.toString() + " ~ ";
        }
        if(ArrayString.length()>=3)
            ArrayString = ArrayString.substring(0, ArrayString.length() - 3);
        return ArrayString;
    }
    public void AddNewItem(BlobData blobData) {
        LibraryFiles.add(blobData);
    }

    @Override
    public String toString() {
        return "Folder{" + getLibraryFilesToString() +
                "rootFolder=" + rootFolder +
                '}';
    }

    private String getLibraryFilesToString()
    {
        String str = EmptyString;
        for(BlobData blobData : LibraryFiles)
            str += blobData.getM_Sha1() + ", ";
        return  str;
    }


}

