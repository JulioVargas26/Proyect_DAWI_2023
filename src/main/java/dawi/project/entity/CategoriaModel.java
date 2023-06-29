package dawi.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcategoria;
	private String descripcion;
	
	//relación UNO A MUCHOS
	@OneToMany(mappedBy = "categoria") //nombre de la asociación
	@JsonIgnore
	private List<ProductoModel> tblistacategoria;

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ProductoModel> getTblistacategoria() {
		return tblistacategoria;
	}

	public void setTblistacategoria(List<ProductoModel> tblistacategoria) {
		this.tblistacategoria = tblistacategoria;
	}


	
}
