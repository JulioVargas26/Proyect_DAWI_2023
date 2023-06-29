package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.UsuarioDAO;
import dawi.project.entity.Enlace;
import dawi.project.entity.Usuario;


@Service
public class UsuarioServices {
	@Autowired
	private UsuarioDAO repo;
	
	public Usuario validarSesion(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}	
	public List<Enlace> enlacesDelUsuario(int codRol){
		return repo.traerEnlacesDelUsuario(codRol);
	}
	public void grabar(Usuario a) {
		repo.save(a);
	}
	
	public List<Usuario> listarUsuario(){
		return repo.findAll();
	}
	
	public void actualizar(Usuario a) {
		repo.save(a);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public Usuario buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
}






