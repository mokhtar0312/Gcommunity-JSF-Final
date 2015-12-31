package anis.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.criteria.CriteriaBuilder.In;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;

@Local
public interface MessageServiceLocal {
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
