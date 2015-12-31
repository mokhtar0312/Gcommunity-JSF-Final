package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Event;
import entities.News;
import entities.SimpleMember;

@Remote
public interface EventServicesRemote {

Boolean addEvent(Event event);
	
	Boolean deleteEventById(Integer id);

	Event findEventById(Integer id);

	Boolean updateEvent(Event event);

	Boolean deleteEvent(Event event);

	List<Event> findAllEvents();
	
	Event findEventByName(String nom);
	
	Boolean affectSimpleMemberToEvent(Event event,
			List<SimpleMember> simpleMembers);
	List<Event> findAllEventsRestants(SimpleMember simpleMember);
	
	List<Event> FindbyTyped(String name);

}
