package services.interfaces;

import java.io.IOException;

import javax.ejb.Remote;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@Remote
public interface mailRemote {
	
	void mail(String subject, String text, String destinataire) throws IOException ;

}
