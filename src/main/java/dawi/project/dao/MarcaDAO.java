package dawi.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dawi.project.entity.MarcaModel;

public interface MarcaDAO extends JpaRepository<MarcaModel, Integer> {
	
	//hql--->select
		//select *from tb_tipo_medicamento where cod_lab=?
		@Query("select tm from MarcaModel tm where tm.proveedor.idproveedor=?1")
		public List<MarcaModel> findAllByProveedor(Integer codProv);
	

}
