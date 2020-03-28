package mygit.service.Logic;

import mygit.service.Logic.GeneratedXML.*;
import mygit.service.Logic.Objects.BlobData;
import mygit.service.Logic.Objects.Commit;
import mygit.service.Logic.Objects.Folder;
import mygit.service.Logic.Zip.ZipFile;
import mygit.service.Logic.inputValidation.FilesValidation;
import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static mygit.service.Logic.ConstantsEnums.EmptyString;


public class XmlReader {
    private MagitRepositoryType magitRepository;
    private ZipFile m_ZipFile;
    private String m_Location;
    FilesValidation m_FilesValidation;

    public XmlReader() {
        magitRepository = new MagitRepositoryType();
        m_ZipFile = new ZipFile();
        m_FilesValidation = new FilesValidation();
    }

    public void ReadXml(String i_Location) throws JAXBException,XmlException {

        InputStream inputStream =null;
        try {
            Path XmlFilePath = Paths.get(i_Location);
            if(i_Location.length()<4||!i_Location.substring(i_Location.length() - 4).equals(".xml"))
                throw new XmlException("File is not xml format");
            if(!Files.exists(XmlFilePath))
                throw new XmlException("Xml file not found");
            inputStream = new FileInputStream(i_Location);
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<MagitRepositoryType> unmarshalledObject = (JAXBElement<MagitRepositoryType>) unmarshaller.unmarshal(inputStream);
        magitRepository = unmarshalledObject.getValue();
    }

    public String GetName() {
       return magitRepository.getName();
    }


    public void buildFromXML(String i_PathTo) throws XmlException {
        m_Location = i_PathTo + File.separator + magitRepository.getName();
        checkIfActiveBranchExist(getActiveBranch());
      //  MagitRemoteReferenceType a= magitRepository.getMagitRemoteReference();
      //  if(a != null)
      //      checkIfMagitRemoteReferenceExist(magitRepository.getMagitRemoteReference());
        //todo    checkIfRemoteTrackingExist(magitRepository);
        Path ActiveBranchFilePath = Paths.get(m_Location + File.separator + ".magit" +File.separator + "branches" +File.separator + "HEAD.txt");
        Path BranchesNamesFilePath = Paths.get(m_Location + File.separator + ".magit" +File.separator + "branches" +File.separator + "NAMES.txt");
        try {
            Files.write(ActiveBranchFilePath, getActiveBranch().getBytes());
            Path remoteBranchFolder= Paths.get("");
          // if(a != null) {
          //     remoteBranchFolder = Paths.get(m_Location + File.separator + ".magit" + File.separator + "branches" + File.separator + magitRepository.getMagitRemoteReference().getName());
          //     Files.createDirectory(remoteBranchFolder);
          // }
            for (MagitSingleBranchType branch : magitRepository.getMagitBranches().getMagitSingleBranch()) {
                Path BranchPath = Paths.get(m_Location + File.separator + ".magit" + File.separator + "branches" + File.separator + branch.getName() + ".txt");
                Files.write(BranchesNamesFilePath, (branch.getName() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                checkIfCommitExist(branch.getPointedCommit().getId());
                String CommitSha1 = buildCommit(magitRepository.getMagitCommits().getMagitSingleCommit().get(Integer.parseInt(branch.getPointedCommit().getId())-1));
                updateBranchCommit(CommitSha1, BranchPath, branch, remoteBranchFolder);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getActiveBranch(){
        return magitRepository.getMagitBranches().getHead();
    }
    private void updateBranchCommit(String i_CommitSha1,Path i_BranchPath, MagitSingleBranchType i_BranchType, Path remotePathName) {
        try{
            if(!Files.exists(i_BranchPath))
                Files.createFile(i_BranchPath);
            Files.write(i_BranchPath,i_CommitSha1.getBytes());
            if(i_BranchType.getIsRemote() != null){
                Files.copy(i_BranchPath, remotePathName , StandardCopyOption.REPLACE_EXISTING);
            }
            if(i_BranchType.getTracking().equals("true")){
                Path RTBfol = Paths.get(m_Location + File.separator + ".magit" +File.separator + "branches" + File.separator + "RTB");
                if(!Files.exists(RTBfol))
                    Files.createDirectory(RTBfol);
                Files.copy(i_BranchPath, Paths.get(RTBfol +File.separator+ i_BranchType.getName()+".txt") , StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (Exception e)
        {

        }
    }
    private String buildCommit(MagitSingleCommitType commitXmlObject) throws XmlException {
        String PreCommitSha1 = "NONE";
        if(commitXmlObject.getPrecedingCommits()!=null && commitXmlObject.getPrecedingCommits().getPrecedingCommit()!=null) {
            checkIfCommitExist(commitXmlObject.getPrecedingCommits().getPrecedingCommit().getId());
            MagitSingleCommitType commit = getCommitXmlObject(commitXmlObject.getPrecedingCommits().getPrecedingCommit().getId());
            PreCommitSha1 = buildCommit(commit);
        }
        BlobData rootBlobData;
        Commit commitObject = new Commit();
        commitObject.setM_CreatedBy(commitXmlObject.getAuthor());
        commitObject.setM_CreatedTime(commitXmlObject.getDateOfCreation());
        commitObject.setM_Message(commitXmlObject.getMessage());
        checkIfFolderIdExist(commitXmlObject.getRootFolder().getId());
        checkIfFolderIsRootFolder(commitXmlObject.getRootFolder().getId());
        rootBlobData = buildRootFolder(commitXmlObject.getRootFolder().getId(), ConstantsEnums.FileType.FOLDER);
        commitObject.setM_MainSHA1(rootBlobData.getM_Sha1());
        commitObject.setM_PreviousSHA1(PreCommitSha1);
        m_ZipFile.zipFile(m_Location + File.separator + ".magit"+File.separator+"objects",DigestUtils.sha1Hex(commitObject.toString()),commitObject.toString());
        return DigestUtils.sha1Hex(commitObject.toString());
    }
    private BlobData buildRootFolder(String id, ConstantsEnums.FileType fileType) throws XmlException {
        String sha1;
        if (fileType == ConstantsEnums.FileType.FOLDER) {
            Folder folder = new Folder();
            MagitSingleFolderType MagitFolder =  getFolderXmlObject(id);
            for (ItemType itemFolder : MagitFolder.getItems().getItem()) {
                if (itemFolder.getType().equals("blob")) {
                    checkIfBlobIdExist(itemFolder.getId());
                    folder.AddNewItem(buildRootFolder(itemFolder.getId(), ConstantsEnums.FileType.FILE));
                } else {
                    checkIfFolderIdExist(itemFolder.getId());
                    checkIfFolderPointToHimself(itemFolder.getId(), id);
                    folder.AddNewItem(buildRootFolder(itemFolder.getId(), ConstantsEnums.FileType.FOLDER));
                }
            }
            sha1 = DigestUtils.sha1Hex(folder.toString());
            BlobData directoryBlob =
                    new BlobData(MagitFolder.getName(), sha1, ConstantsEnums.FileType.FOLDER,
                            MagitFolder.getLastUpdater(), MagitFolder.getLastUpdateDate());
            m_ZipFile.zipFile(m_Location + File.separator + ".magit" + File.separator + "objects", sha1, folder.printArray());
            return directoryBlob;
        } else {
            MagitBlobType blob = getBlobXmlObject(id);
            BlobData blobData = new BlobData(blob.getName(), DigestUtils.sha1Hex(blob.getContent()), ConstantsEnums.FileType.FILE, blob.getLastUpdater(), blob.getLastUpdateDate());
            m_ZipFile.zipFile(m_Location + File.separator + ".magit" + File.separator + "objects", DigestUtils.sha1Hex(blob.getContent()), blob.getContent());
            return blobData;
        }
    }
    private MagitBlobType getBlobXmlObject(String id) {
        MagitBlobType BlobToFind = null;
        for(MagitBlobType blob: magitRepository.getMagitBlobs().getMagitBlob())
        {
            if(blob.getId().equals(id))
                BlobToFind =  blob;
        }
        return BlobToFind;
    }
    private MagitSingleFolderType getFolderXmlObject(String id) {
        MagitSingleFolderType FolderToFind = null;
        for(MagitSingleFolderType folder: magitRepository.getMagitFolders().getMagitSingleFolder())
        {
            if(folder.getId().equals(id))
                FolderToFind =  folder;
        }
        return FolderToFind;
    }
    private MagitSingleCommitType getCommitXmlObject(String id) {
        MagitSingleCommitType CommitToFind = null;
        for(MagitSingleCommitType commit: magitRepository.getMagitCommits().getMagitSingleCommit())
        {
            if(commit.getId().equals(id))
                CommitToFind =  commit;
        }
        return CommitToFind;
    }

    //Xml Validation 3.2
    private void xmlFileIsValid_oneId32() throws XmlException {
        List<String>idNumbers = new ArrayList<>();
        for(MagitBlobType blob:magitRepository.getMagitBlobs().getMagitBlob())
        {
            if(idNumbers.contains(blob.getId())) {
                throw new XmlException("there is 2 blobs with the same id");
            }
            idNumbers.add(blob.getId());
        }
        idNumbers.clear();
        for(MagitSingleFolderType folder:magitRepository.getMagitFolders().getMagitSingleFolder())
        {
            if(idNumbers.contains(folder.getId())) {
                throw new XmlException("there is 2 folders with the same id");
            }
            idNumbers.add(folder.getId());
        }
        idNumbers.clear();
        for(MagitSingleCommitType commit:magitRepository.getMagitCommits().getMagitSingleCommit())
        {
            if(idNumbers.contains(commit.getId())) {
                throw new XmlException("there is 2 commits with the same id");
            }
            idNumbers.add(commit.getId());
        }
        idNumbers.clear();
    }

    //Xml Validation 3.3
    private void checkIfBlobIdExist(String id) throws XmlException {
        Boolean Exist=false;
        for(MagitBlobType blob: magitRepository.getMagitBlobs().getMagitBlob())
        {
            if(blob.getId().equals(id))
                Exist = true;
        }
        if(!Exist)
            throw new XmlException("Folder Pointing UnExist Blob");
    }

    //Xml Validation 3.4 & 3.6
    private void checkIfFolderIdExist(String id) throws XmlException {
        Boolean Exist=false;
        for(MagitSingleFolderType folder: magitRepository.getMagitFolders().getMagitSingleFolder())
        {
            if(folder.getId().equals(id))
                Exist = true;
        }
        if(!Exist)
            throw new XmlException("Folder Pointing UnExist Folder");
    }

    //Xml Validation 3.5
    private void checkIfFolderPointToHimself(String ToId, String FromId) throws XmlException {
        if(ToId.equals(FromId))
            throw new XmlException("Folder Point to Same Folder");
    }

    //Xml Validation 3.7
    private void checkIfFolderIsRootFolder(String id) throws XmlException {
        if(getFolderXmlObject(id.toString()).getIsRoot()==null)
            throw new XmlException("Commit Pointing None Root Folder");
        if(!getFolderXmlObject(id.toString()).getIsRoot().equals("true"))
            throw new XmlException("Commit Pointing None Root Folder");
    }

    //Xml Validation 3.8
    private void checkIfCommitExist(String id) throws XmlException {
        Boolean Exist=false;
        for(MagitSingleCommitType commit: magitRepository.getMagitCommits().getMagitSingleCommit())
        {
            if(commit.getId().equals(id))
                Exist = true;
        }
        if(!Exist)
            throw new XmlException("Branch Pointing UnExist Commit");
    }

    //Xml Validation 3.9
    private void checkIfActiveBranchExist(String activeBranch) throws XmlException {
        Boolean Exist=false;
        for(MagitSingleBranchType branch: magitRepository.getMagitBranches().getMagitSingleBranch())
        {
            if(branch.getName().equals(activeBranch))
                Exist = true;
        }
        if(!Exist)
            throw new XmlException("Head Pointing UnExist Branch");
    }

    //Xml Validation Ex02 - A
    private void checkIfMagitRemoteReferenceExist(MagitRemoteReferenceType magitRemoteReference) throws XmlException{
        Boolean Exist=false;
        if(!m_FilesValidation.isRepository(magitRemoteReference.getLocation() + File.separator + magitRemoteReference.getName()))
            Exist = true;

        if(!Exist)
            throw new XmlException("Remote Reference is not Repository");
    }

    //Xml Validation Ex02 - B
    private void checkIfRemoteTrackingExist(MagitRepositoryType magitRepository) throws XmlException{
        Boolean Exist=false;


        for(MagitSingleBranchType trackingBranch : magitRepository.getMagitBranches().getMagitSingleBranch()){
            if(trackingBranch.getTracking().equals("true")){
                if(magitRepository.getMagitBranches().getMagitSingleBranch().contains(trackingBranch.getTrackingAfter())){
                    int index =  magitRepository.getMagitBranches().getMagitSingleBranch().indexOf(trackingBranch.getTrackingAfter());
                    if(!magitRepository.getMagitBranches().getMagitSingleBranch().get(index).getIsRemote().equals("true")){
                        Exist = true;
                    }
                }
                else {Exist = true;}
            }

        }
        if(!Exist)
            throw new XmlException("Remote branch problem");
    }


    private void checkIfMagitRepoExist(MagitRepositoryType magitRepository) throws XmlException{
        Boolean Exist=false;
        if(Files.exists(Paths.get(magitRepository.getLocation())))
            Exist = true;

        if(!Exist)
            throw new XmlException("Repository already exists");
    }



}