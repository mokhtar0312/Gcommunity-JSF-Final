package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Sponsor;

@Local
public interface SponsorServicesLocal {
	Boolean addSponsor(Sponsor sponsor);

	Boolean deleteSponsorById(Integer id);

	Sponsor findSponsorById(Integer id);

	Boolean updateSponsor(Sponsor sponsor);

	Boolean deleteSponsor(Sponsor sponsor);

	List<Sponsor> findAllSponsors();
}
