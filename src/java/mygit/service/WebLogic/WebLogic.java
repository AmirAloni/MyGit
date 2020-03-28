package mygit.service.WebLogic;

import mygit.service.Logic.Logic;
import mygit.service.Logic.Node.CommitNode;
import mygit.service.WebLogic.WebObjects.Notification;
import mygit.service.WebLogic.WebObjects.Repository;
import mygit.service.WebLogic.WebObjects.FileObject;
import org.springframework.stereotype.Service;

import static mygit.service.Logic.ConstantsEnums.dateFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WebLogic {

    private Logic logicManager = new Logic();

    public void addNotification(String other_user, String message) {
        String date = dateFormat.format(new Date());
        Notification notification = new Notification(message,date);
        File file = new File("C:\\magit-ex3\\"+other_user+"\\NOTIFICATIONS.txt");
        try {
            Files.write(Paths.get(file.toString()),(notification.toString()+System.lineSeparator()).getBytes(),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean userExist(String username)
    {
        File file = new File("C:\\magit-ex3\\users.txt");
        String[] usersArray = getContentOfFile(file).split(System.lineSeparator());
        return Arrays.asList(usersArray).contains(username);
    }

    public String getContentOfFile(File i_File) {
        String fileContent = "";
        Path path = Paths.get(i_File.getAbsolutePath());

        try {
            fileContent = "";
            if (path.toFile().length() > 0)
                fileContent = new String(Files.readAllBytes(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    public ArrayList<Notification> getNotifications(String username) {
        String userLastLoggedOut = getUserLastLogedOut(username);
        File file = new File("C:\\magit-ex3\\"+username+"\\NOTIFICATIONS.txt");
        String[] arrayNotifications = getContentOfFile(file).split(System.lineSeparator());
        ArrayList<Notification> listNotifications = new ArrayList<Notification>();
        for(String notification: arrayNotifications) {
            if (notification != "") {
                Notification noti = new Notification(notification);
                try {
                    Date notiDate = dateFormat.parse(noti.getM_CreatedTime());
                    Date lastLoggedOutDate = dateFormat.parse(userLastLoggedOut);
                    if (notiDate.compareTo(lastLoggedOutDate) > 0) {
                        listNotifications.add(noti);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return listNotifications;
    }


    public ArrayList<String> getUsers(String username) {
        File file = new File("C:\\magit-ex3\\users.txt");
        ArrayList<String> listUsers = new ArrayList<String>(Arrays.asList(getContentOfFile(file).split(System.lineSeparator())));
        listUsers.remove(username);
        return listUsers;
    }

    public ArrayList<Repository> getUserRepositories(String username){
        File[] repositories = new File("C:\\magit-ex3\\"+username+"\\repositories").listFiles(File::isDirectory);
        ArrayList<Repository> directoriesList = new ArrayList<>();

        for(File repoFile: repositories){
            directoriesList.add(getRepositoryDetails(repoFile));
        }
        return directoriesList;
    }

    public Repository getRepositoryDetails(File repoFile) {
        File branchesDirectory = new File(repoFile.getPath() + File.separator + ".magit" + File.separator +"branches");
        File headBranchFile = new File( branchesDirectory +File.separator + "HEAD.txt");
        File activeBranchFile = new File(branchesDirectory +File.separator + logicManager.getContentOfFile(headBranchFile) +".txt");
        String commitSha1 = logicManager.getContentOfFile(activeBranchFile);
        String commitDetails = "";
        if(!commitSha1.equals("")){
            commitDetails = logicManager.getContentOfZipFile(repoFile + File.separator + ".magit" + File.separator + "objects", commitSha1);
        }
        Integer branchesNum = getTextFiles(branchesDirectory)-2;

        Repository repo = new Repository();
        repo.setName(repoFile.getName());
        repo.setActiveBranch(activeBranchFile.getName().replace(".txt",""));
        repo.setBranchesNumber(branchesNum.toString());
        if(!commitDetails.equals("")) {
            repo.setLastCommitTime(commitDetails.split(",")[3]);
            repo.setLastCommitMsg(commitDetails.split(",")[2]);
        }
        return repo;
    }

    private Integer getTextFiles(File branchesDirectory) {
        Integer num =0;
        for(File f : branchesDirectory.listFiles()){
            if(f.isFile())
                num++;
        }
        return  num;
    }

    public String getUserLastLogedOut(String username) {
        File file = new File("C:\\magit-ex3\\"+username+"\\LAST_LOGGED_OUT.txt");
        String lastLogedIn = getContentOfFile(file);
        return lastLogedIn;
    }

    public void setUserLastLogedOut(String username) {
        File file = new File("C:\\magit-ex3\\"+username+"\\LAST_LOGGED_OUT.txt");
        String lastLogedIn = dateFormat.format(new Date());
        try {
            file.delete();
            Files.write(Paths.get(file.toString()), lastLogedIn.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<CommitNode> getAllBranchCommits(String username, Repository repositortDetails) {
        String activeBranch = repositortDetails.getActiveBranch();
        File BranchFile = new File("C:\\magit-ex3\\"+username+"\\repositories\\"+repositortDetails.getName()+"\\.magit\\branches\\"+activeBranch+".txt");
        String Sha1=getContentOfFile(BranchFile);
        ArrayList<CommitNode> commitBranchList = new ArrayList<>();
        if(!Sha1.equals("")){
            logicManager.getAllCommits(Sha1,commitBranchList,username,repositortDetails.getName());
        }
        return commitBranchList;
    }

    public ArrayList<FileObject> getAllFiles(String path){
        ArrayList<FileObject>files = new ArrayList<>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            String file=listOfFiles[i].getAbsolutePath().replace("\\","\\\\");
            if (listOfFiles[i].isFile()) {
                files.add(new FileObject(file,false));
            } else if (listOfFiles[i].isDirectory()) {
                files.add(new FileObject(file,true));
            }
        }
        return files;
    }

    public void CreateUser(String username) throws IOException {
        Files.createDirectory(Paths.get("C:\\magit-ex3\\"+username));
        Files.createDirectory(Paths.get("C:\\magit-ex3\\"+username+"\\repositories"));
        Files.createFile(Paths.get("C:\\magit-ex3\\"+username+"\\NOTIFICATIONS.txt"));
        Files.createFile(Paths.get("C:\\magit-ex3\\"+username+"\\LAST_LOGGED_OUT.txt"));
        setUserLastLogedOut(username);
        Files.write(Paths.get("C:\\magit-ex3\\users.txt"),(username+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
    }
}
