package anis.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;

@Local
public interface AdminServiceLocal {
    public void interfaceAdministrateur();

    List<Notification> readAllNotifications();
    List<Integer>  readAllNotificationsCount();

 	
	public Boolean ajouterMessage(Message message);
	
 	public List<Integer>  readAllNotificationsCountMessage(ActiveMember activeMember);
 	public List<Integer>  readAllNotificationsCountStock(ActiveMember activeMember);

}
