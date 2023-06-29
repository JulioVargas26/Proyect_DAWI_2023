package dawi.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dawi.project.entity.CategoriaModel;

public interface CategoriaDAO extends JpaRepository<CategoriaModel, Integer> {
	

}
