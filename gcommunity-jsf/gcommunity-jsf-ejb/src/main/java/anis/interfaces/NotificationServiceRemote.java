package anis.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Message;
import entities.Notification;

@Remote
public interface NotificationServiceRemote {
	Boolean ajouterNotification(Notification notification);
	List<Notification> readAllNotifications();
	Boolean deleteNotificationById(Integer id);
	Boolean updateNotification(Notification notification);
	Message getMessageFromNotificationTable(Integer id);
	List<Notification> readAllNotificationsStocks();

}
