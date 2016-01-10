package services.interfaces;

import javax.ejb.Local;

import entities.SimpleMember;

@Local
public interface AuthentificationServiceLocal {
	public SimpleMember authentifier(String login, String pwd);

	
}
