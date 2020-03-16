package mygit.api;

import mygit.service.WebLogic.WebLogic;
import mygit.service.WebLogic.WebObjects.Notification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RequestMapping("mygit/api/user/notifications")
@RestController
public class FetchNotificationsController {

    private final WebLogic webLogicService;

    @Autowired
    public FetchNotificationsController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}")
    public String GetNotifications(@PathVariable("username") String username) throws JSONException {

        if(webLogicService.userExist(username)){
            JSONArray jsonArray = new JSONArray();
            ArrayList<Notification> notificationArray = new ArrayList<>();
            notificationArray = webLogicService.getNotifications(username);

            for(Notification notification : notificationArray){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("text", notification.getText());
                jsonObject.put("created", notification.getM_CreatedTime());
                jsonArray.put(jsonObject);
            }

            return jsonArray.toString();
        }
        else {
            return null;
        }
    }

    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void  Update(){}

}