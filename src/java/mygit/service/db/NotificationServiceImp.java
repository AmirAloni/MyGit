
package mygit.service;

        import java.util.List;
        import java.util.UUID;
        import javax.annotation.Resource;

        import mygit.dao.notification.NotificationDao;
        import mygit.entity.Notification;
        import org.springframework.stereotype.Component;


@Component
public class NotificationServiceImp implements NotificationService{
    @Resource
    NotificationDao notificationDao;

    @Override
    public List<Notification> getNotifications(String userId) {
        return notificationDao.getNotifications(userId);
    }

    @Override
    public void insertNotification(Notification notification) {
        notificationDao.insertNotification(notification);
    }

    @Override
    public void deleteNotification(String id) {
        notificationDao.deleteNotification(id);
    }
}
