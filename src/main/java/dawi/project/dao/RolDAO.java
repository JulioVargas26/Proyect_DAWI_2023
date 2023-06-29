package dawi.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import dawi.project.entity.Rol;

public interface RolDAO extends JpaRepository<Rol, Integer> {
	

}
