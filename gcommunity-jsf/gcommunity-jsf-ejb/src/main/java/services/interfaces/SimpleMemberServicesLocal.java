package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Event;
import entities.SimpleMember;

@Local
public interface SimpleMemberServicesLocal {
Boolean addSimpleMember(SimpleMember simpleMember);
	
	Boolean deleteSimpleMemberById(Integer id);

	SimpleMember findSimpleMemberById(Integer id);

	Boolean updateSimpleMember(SimpleMember simpleMember);

	Boolean deleteSimpleMember(SimpleMember simpleMember);

	List<SimpleMember> findAllSimpleMember();
	Boolean affectEventToSimpleMember(SimpleMember simpleMember,
			Event event);

}
