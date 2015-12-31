package services.interfaces;

import javax.ejb.Local;

import entities.ActiveMember;

@Local
public interface AuthentificationLocal {
	Boolean connect(ActiveMember activeMember);
	Boolean disconect();
	ActiveMember getConectedPerson();
}
