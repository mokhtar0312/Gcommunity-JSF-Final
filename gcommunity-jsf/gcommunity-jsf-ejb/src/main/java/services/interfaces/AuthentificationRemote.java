package services.interfaces;

import javax.ejb.Remote;

import entities.ActiveMember;

@Remote
public interface AuthentificationRemote {
	Boolean connect(ActiveMember activeMember);
	Boolean disconect();
	ActiveMember getConectedPerson();
}
