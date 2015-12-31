package anis.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Message;
import entities.Notification;

@Local
public interface NotificationServiceLocal {
	Boolean ajouterNotification(Notification notification);
	List<Notification> readAllNotifications();
	Boolean deleteNotificationById(Integer id);
	Boolean updateNotification(Notification notification);
	Message getMessageFromNotificationTable(Integer id);
	List<Notification> readAllNotificationsStocks();

}
