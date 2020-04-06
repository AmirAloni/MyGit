package mygit.service;

import mygit.entity.Notification;
import java.util.List;

public interface NotificationService {

    List<Notification> getNotifications(String userId);
    void insertNotification(Notification notification);
    void deleteNotification(String id);

}