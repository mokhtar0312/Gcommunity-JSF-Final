package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import services.interfaces.AuthentificationLocal;
import services.interfaces.AuthentificationRemote;
import entities.ActiveMember;

/**
 * Session Bean implementation class Authentification
 */
@Stateful
@LocalBean
public class Authentification implements AuthentificationRemote, AuthentificationLocal {
private ActiveMember conectedPerson=null;
    /**
     * Default constructor. 
     */
    public Authentification() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean connect(ActiveMember activeMember) {
		conectedPerson=activeMember;
		return true;
	}

	@Override
	public Boolean disconect() {
		conectedPerson=null;
		return true;
	}

	public ActiveMember getConectedPerson() {
		return conectedPerson;
	}

	

}
