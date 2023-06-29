package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.ProductoDAO;
import dawi.project.entity.ProductoModel;

@Service
public class ProductoService {

	@Autowired
	private ProductoDAO repo;
	
	public void grabar(ProductoModel a) {
		repo.save(a);
	}
	
	public List<ProductoModel> listarProducto(){
		return repo.findAll();
	}
	
	public void actualizar(ProductoModel a) {
		repo.save(a);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	
	public ProductoModel buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<ProductoModel> buscarPorNombre(String nombre){
		return repo.findByDescripcionStartingWith(nombre);
	}

	public List<ProductoModel> listarPorCategoria(int cod) {
		// TODO Auto-generated method stub
		return repo.buscarPorCategoria(cod);
	}
}
