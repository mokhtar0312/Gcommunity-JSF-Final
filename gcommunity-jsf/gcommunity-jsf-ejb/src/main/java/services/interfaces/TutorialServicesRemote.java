package services.interfaces;

import java.util.List;

import javax.ejb.Remote;


import entities.SimpleMember;
import entities.Tutorial;

@Remote
public interface TutorialServicesRemote {
	Boolean addTutorial(Tutorial tutorial, SimpleMember simplemembertut);

	Boolean deleteTutorialById(Integer id);

	Tutorial findTutorialById(Integer id);

	Boolean updateTutorial(Tutorial tutorial);

	Boolean deleteTutorial(Tutorial tutorial);

	List<Tutorial> findAllTutorial();
	
	List<Tutorial> FindbyTyped(String typed);
}
