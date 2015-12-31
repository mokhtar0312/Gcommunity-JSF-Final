package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Streams;

@Remote
public interface StreamServicesRemote {

	Boolean addStream(Streams stream);
	Streams findStreamById(Integer id);
	Boolean updateStream(Streams stream);
	Boolean deleteStream(Integer id);
	List<Streams> findAllStreams();
}
