package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Packs;

@Remote
public interface PacksServicesRemote {

	Boolean addPacks(Packs packs);

	Boolean deletePacksById(Integer id);

	Packs findPacksById(Integer id);

	Boolean updatePacks(Packs packs);

	Boolean deletePacks(Packs packs);

	List<Packs> findAllPacks();
}
