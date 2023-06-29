package dawi.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dawi.project.entity.ProveedorModel;

public interface ProveedorDAO extends JpaRepository<ProveedorModel, Integer> {
	/*@Query(value=" call listarProveedorPorNombre(?1) ", nativeQuery=true)
	public List<ProveedorModel> buscarPorNombre(String nombre);
	*/
	public List<ProveedorModel> findByNombreStartingWith(String nom);
	
}
