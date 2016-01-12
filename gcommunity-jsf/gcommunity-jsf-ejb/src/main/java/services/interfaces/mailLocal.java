package services.interfaces;

import java.io.IOException;

import javax.ejb.Local;

@Local
public interface mailLocal {
	void mail(String subject, String text, String destinataire) throws IOException ;
}
