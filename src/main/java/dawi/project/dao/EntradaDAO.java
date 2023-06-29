package dawi.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dawi.project.entity.Entradas;

public interface EntradaDAO extends JpaRepository<Entradas, Integer>{

	@Query("select x  from Entradas x where x.proveedorEntrada.idproveedor=?1")
	public List<Entradas> listaPorEntrada(int cod);
}
