package dawi.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dawi.project.entity.ProductoModel;
import dawi.project.entity.ProveedorModel;

public interface ProductoDAO extends JpaRepository<ProductoModel, Integer> {

	/*@Query(value=" call listarProductoPorNombre(?1) ", nativeQuery=true)
	public List<ProductoModel> buscarPorNombre(String nombre);
	*/
	
	@Query("select p from ProductoModel p where p.categoria.idcategoria=?1")
	public List<ProductoModel> buscarPorCategoria(int cod);
	
	public List<ProductoModel> findByDescripcionStartingWith(String des);
	
}
