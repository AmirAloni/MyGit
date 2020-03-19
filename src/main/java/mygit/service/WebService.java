package mygit.service;

import mygit.service.Logic.Logic;
import mygit.service.Logic.Node.CommitNode;
import mygit.service.Logic.Objects.BranchData;
import mygit.service.WebLogic.WebLogic;
import mygit.service.WebLogic.WebObjects.Notification;
import mygit.service.WebLogic.WebObjects.Repository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebService {

    WebLogic webLogic = new WebLogic();

    public ResponseEntity Login(String username) {
        try{
            if(webLogic.userExist(username))
               return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity Logout(String username) {
        try{
            webLogic.setUserLastLogedOut(username);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity SignUp(String username) {

        try{
            if(!webLogic.userExist(username)) {
                webLogic.CreateUser(username);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is already exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity GetUserRepositories(String username) {
        try{
            if(webLogic.userExist(username)) {
                ArrayList<Repository> repositoriesList = webLogic.getUserRepositories(username);
                return new ResponseEntity<>(repositoriesList, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity GetNotifications(String username) {
        try{
            if(webLogic.userExist(username)) {
                ArrayList<Notification> notificationArray = webLogic.getNotifications(username);
                return new ResponseEntity<List>(notificationArray, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity GetOtherUsers(String username) {
        try{
            if(webLogic.userExist(username)) {
                ArrayList<String> arrayList = webLogic.getUsers(username);
                return new ResponseEntity<List>(arrayList, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity GetRepositoryData(String username, String repositoryName) {
        try{
            if(webLogic.userExist(username)) {
                Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repositoryName);
                List<Object> repository = new ArrayList<>();

                File repoFile = new File("C:\\magit-ex3\\" + username + "\\repositories\\" + repositoryName);
                Repository repositoryDetails = webLogic.getRepositoryDetails(repoFile);

                ArrayList<Notification> notificationList = webLogic.getNotifications(username);
                ArrayList<CommitNode> CommitBranchList = webLogic.getAllBranchCommits(username, repositoryDetails);
                ArrayList<BranchData> branchData = (ArrayList<BranchData>) logicManager.GetAllBranchesDetails();
                Boolean isPr = Files.exists(Paths.get(logicManager.getPathFolder(".magit"), "PR"));
                Boolean isLr = Files.exists(Paths.get(logicManager.getPathFolder("branches"), "RTB"));

                repository.add(repositoryDetails);
                repository.add(notificationList);
                repository.add(CommitBranchList);
                repository.add(branchData);
                repository.add(isPr);
                repository.add(isLr);

                return new ResponseEntity<Object>(repository, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public ResponseEntity GetCommitData(String username, String repositoryName, String commitSha1) {
        try{
            if(webLogic.userExist(username)) {
                Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repositoryName);
                logicManager.spreadCommitToShow(commitSha1);
                String jsonFilesString = createJsonFiles(username, repositoryName, logicManager.getRootFolderName()).toString();


                return new ResponseEntity<String>(jsonFilesString, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private JSONObject getJsonDataRec(File rootFolder) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", rootFolder.getName());

        if(rootFolder.isFile()){
            jsonObject.put("path", rootFolder.getAbsolutePath());
            return jsonObject;
        }

        if(rootFolder.isDirectory()){
            JSONArray jsonArray = new JSONArray();
            for(File file : rootFolder.listFiles()){
                jsonArray.put(getJsonDataRec(file));
            }
            jsonObject.put("toggled", true);
            jsonObject.put("children", jsonArray);
            return jsonObject;
        }

        return null;
    }
    private JSONObject createJsonFiles(String username, String repoName, String rootFolderName) throws JSONException {

        File rootFolder = new File("C:\\magit-ex3\\" + username + "\\repositories\\" + repoName + "\\.magit\\commitToShow\\" + rootFolderName);
        return getJsonDataRec(rootFolder);
    }

    public ResponseEntity GetFileContent(String path) {
        try{
                Logic logicManager = new Logic();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("content",logicManager.getContentOfFile(new File(path)));
                return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
            }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity CreateRepository(String username, String repoName) {
        try{
            if(webLogic.userExist(username)) {
                Logic logic = new Logic(username, repoName);
                logic.initRepository(repoName);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User is not exists", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
