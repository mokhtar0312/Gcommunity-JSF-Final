package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.StreamServicesLocal;
import services.interfaces.StreamServicesRemote;
import entities.Streams;

/**
 * Session Bean implementation class StreamServices
 */

@Stateless
@LocalBean
public class StreamServices implements StreamServicesRemote, StreamServicesLocal {
@PersistenceContext
	EntityManager entitymanager;
    /**
     * Default constructor. 
     */
    public StreamServices() {
        // TODO Auto-generated constructor stub
    }

@Override
public Boolean addStream(Streams stream ) {
	boolean b=false;
	try {
		entitymanager.persist(stream);
		b=true;
	} catch (Exception e) {
		System.err.println("ouups ...");
	}
	return b;
}

@Override
public Streams findStreamById(Integer id) {
	// TODO Auto-generated method stub
	return entitymanager.find(Streams.class, id);
}

@Override
public Boolean updateStream(Streams stream) {
	boolean b=false;
	try {
		entitymanager.merge(stream);
		b=true;
		
	} catch (Exception e) {
		System.err.println("ouups ...");
	}
	return b;
}

@Override
public Boolean deleteStream(Integer id) {
	
	boolean b=false;
	try {
		entitymanager.remove(findStreamById(id));
		b=true;
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return b;
}

@Override
public List<Streams> findAllStreams() {
	String jpql = "select s from Streams s";
	Query query = entitymanager.createQuery(jpql);
	
	return query.getResultList();
}

}
