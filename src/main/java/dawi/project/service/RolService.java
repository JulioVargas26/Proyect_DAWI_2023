package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dawi.project.dao.RolDAO;
import dawi.project.entity.Rol;

@Service
public class RolService {
	
	@Autowired
	private RolDAO repo;
	
	
	public List<Rol> listarRol(){
		return repo.findAll();
	}
	
	
}
