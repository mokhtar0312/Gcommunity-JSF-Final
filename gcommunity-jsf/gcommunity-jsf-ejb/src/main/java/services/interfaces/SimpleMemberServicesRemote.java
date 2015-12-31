package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Event;
import entities.SimpleMember;

@Remote
public interface SimpleMemberServicesRemote {
	Boolean addSimpleMember(SimpleMember simpleMember);
	
	Boolean deleteSimpleMemberById(Integer id);

	SimpleMember findSimpleMemberById(Integer id);

	Boolean updateSimpleMember(SimpleMember simpleMember);

	Boolean deleteSimpleMember(SimpleMember simpleMember);

	List<SimpleMember> findAllSimpleMember();
	
	Boolean affectEventToSimpleMember(SimpleMember simpleMember,
			Event event);
	

}
