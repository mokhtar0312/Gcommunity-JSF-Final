package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Sponsor;

@Remote
public interface SponsorServicesRemote {
	Boolean addSponsor(Sponsor sponsor);

	Boolean deleteSponsorById(Integer id);

	Sponsor findSponsorById(Integer id);

	Boolean updateSponsor(Sponsor sponsor);

	Boolean deleteSponsor(Sponsor sponsor);

	List<Sponsor> findAllSponsors();
}
