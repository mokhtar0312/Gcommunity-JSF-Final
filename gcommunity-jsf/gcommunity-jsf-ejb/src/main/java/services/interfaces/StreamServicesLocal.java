package services.interfaces;
import java.util.List;
import javax.ejb.Local;
import entities.Streams;

@Local
public interface StreamServicesLocal {
	
	Boolean addStream(Streams stream);
	Streams findStreamById(Integer id);
	Boolean updateStream(Streams stream);
	Boolean deleteStream(Integer id);
	List<Streams> findAllStreams();
	

}
