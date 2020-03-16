package mygit.service;

import mygit.service.WebLogic.WebLogic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
