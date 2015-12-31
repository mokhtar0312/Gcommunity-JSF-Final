package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.News;

@Remote
public interface NewsServicesRemote {
	Boolean addNews(News news);

	News findNewsbyId(Integer Id);
	List<News> FindbyTyped(String typed);

	Boolean updateNews(News news);

	Boolean deleteNews(News news);

	List<News> DisplayAllNews();

}
