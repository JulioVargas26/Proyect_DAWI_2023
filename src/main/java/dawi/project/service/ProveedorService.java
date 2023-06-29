package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.ProveedorDAO;
import dawi.project.entity.ProveedorModel;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorDAO repo;
	
	
	public void grabar(ProveedorModel m) {
		repo.save(m);
	}
	
	public List<ProveedorModel> listarProveedor(){
		return repo.findAll();
	}
	
	public void actualizar(ProveedorModel m) {
		repo.save(m);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public ProveedorModel buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<ProveedorModel> buscarPorNombre(String nombre){
		return repo.findByNombreStartingWith(nombre);
	}
}
