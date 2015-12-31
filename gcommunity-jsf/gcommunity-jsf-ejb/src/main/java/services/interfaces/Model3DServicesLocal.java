package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Model3D;;

@Local
public interface Model3DServicesLocal {

	Boolean addM(Model3D model3D);

	Model3D findModel3DById(Integer id);

	Boolean updateModel3D(Model3D model3D);

	Boolean deleteModel3D(Integer id);

	List<Model3D> finAll3DModels();
}
