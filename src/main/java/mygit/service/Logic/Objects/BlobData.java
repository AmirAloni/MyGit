package mygit.service.Logic.Objects;

import mygit.service.Logic.ConstantsEnums.FileType;

import static mygit.service.Logic.ConstantsEnums.EmptyString;
import static mygit.service.Logic.ConstantsEnums.Separator;

public class BlobData {
    private String m_Name = EmptyString;
    private String m_Sha1 = EmptyString;
    private FileType m_Type = FileType.NONE;
    private String m_ChangedBy = EmptyString;
    private String m_Date = EmptyString;


    public BlobData(String m_Name, String m_Sha1, FileType m_Type, String m_ChangedBy, String m_Date) {
        this.m_Name = m_Name;
        this.m_Sha1 = m_Sha1;
        this.m_Type = m_Type;
        this.m_ChangedBy = m_ChangedBy;
        this.m_Date = m_Date;
    }

    public BlobData(String i_DescriptionBlobData){
        String[] strArr = i_DescriptionBlobData.split(Separator);
        this.m_Name = strArr[0];
        this.m_Sha1 = strArr[1];
        this.m_Type = FileType.valueOf(strArr[2]);
        this.m_ChangedBy = strArr[3];
        this.m_Date = strArr[4];
    }



    public String getM_Sha1() {
        return m_Sha1;
    }

    public FileType getM_Type() {
        return m_Type;
    }

    public String getM_Name() {
        return m_Name;
    }

    public String getM_ChangedBy() {
        return m_ChangedBy;
    }

    public String getM_Date() {
        return m_Date;
    }

    @Override
    public String toString()
    {
        String str =m_Name +Separator+ m_Sha1 + Separator
                + m_Type.toString() + Separator + m_ChangedBy +
                Separator + m_Date;
        return str;
    }


//   public String CompareSha1(String LastSha1)
//    {
//
//        /*
//        //if the content of file with the same sha1 is changed so sha1 should change.
//
//        //if(blob changed){
//            if exist check if changed
//            check with the last commit that saved in head branch. if all file exist or if its new file
//            add to array of blob changed
//            //return toString();
//*/
//    }

}
