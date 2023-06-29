package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.MarcaDAO;
import dawi.project.entity.MarcaModel;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaDAO repo;
	
	
	public void grabar(MarcaModel m) {
		repo.save(m);
	}
	
	public List<MarcaModel> listarMarca(){
		return repo.findAll();
	}
	
	public void actualizar(MarcaModel m) {
		repo.save(m);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public MarcaModel buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}

	public List<MarcaModel> listarPorProveedor(Integer codLab){
		return repo.findAllByProveedor(codLab);
	}
	
}
