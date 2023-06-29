package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.CategoriaDAO;
import dawi.project.entity.CategoriaModel;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDAO repo;
	
	
	public void grabar(CategoriaModel m) {
		repo.save(m);
	}
	
	public List<CategoriaModel> listarCategoria(){
		return repo.findAll();
	}
	
	public void actualizar(CategoriaModel m) {
		repo.save(m);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public CategoriaModel buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
