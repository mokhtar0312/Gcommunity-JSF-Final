package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Event;
import entities.SimpleMember;

@Local
public interface EventServicesLocal {
Boolean addEvent(Event event);
	
	Boolean deleteEventById(Integer id);

	Event findEventById(Integer id);
	
	Event findEventByName(String nom);


	Boolean updateEvent(Event event);

	Boolean deleteEvent(Event event);

	List<Event> findAllEvents();
	
	Boolean affectSimpleMemberToEvent(Event event,
			List<SimpleMember> simpleMembers);
	List<Event> findAllEventsRestants(SimpleMember simpleMember);

}
