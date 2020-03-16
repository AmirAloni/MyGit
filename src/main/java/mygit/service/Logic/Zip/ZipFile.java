package mygit.service.Logic.Zip;

import java.io.*;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public void zipFile(String i_FolderToSave, String i_FileName, String i_FileContent) {
        StringBuilder sb = new StringBuilder();
        sb.append(i_FileContent);

        File ZipFile = new File(i_FolderToSave + File.separator + i_FileName + ".zip");
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(ZipFile));
            ZipEntry e = new ZipEntry(i_FileName + ".txt");
            out.putNextEntry(e);
            byte[] data = sb.toString().getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unZipIt(String zipFile, String outputFolder) {
        byte[] buffer = new byte[1024];
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));

            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();
            String fileName = ze.getName();
            File newFile = new File(outputFolder + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
