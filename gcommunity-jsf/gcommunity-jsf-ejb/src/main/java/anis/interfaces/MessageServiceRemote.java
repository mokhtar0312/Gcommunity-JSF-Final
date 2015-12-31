package anis.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;

@Remote
public interface MessageServiceRemote {
	Boolean ajouterMessage(Message message);
	List<Message> readAllMessage();
	Boolean deleteMessageById(Integer id);
	Boolean updateMessage(Message message);	
	Message findMessageById(Integer id);
    ActiveMember findActiveMemeberByUsername(String username);
    ActiveMember findActiveMemberById(int i);
    ActiveMember findActiveMemberByEmail(String email);
    List<Message> readAllMessageByIDActiveMember(int i);
    List<Message> findAllMessage();

}
