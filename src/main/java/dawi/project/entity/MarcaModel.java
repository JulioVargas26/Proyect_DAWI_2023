package dawi.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="marca")
public class MarcaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmarca;
	private String descripcion;
	
	//relación MUCHOS A UNOS
	@ManyToOne
	@JoinColumn(name="idproveedor")//nombre de la columna
	private ProveedorModel proveedor; //variable de asociacion
	
	//relación UNO A MUCHOS
	@OneToMany(mappedBy = "marca")//nombre de la asociación
	@JsonIgnore
	private List<ProductoModel> tblistaMarca;

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ProductoModel> getTblistaMarca() {
		return tblistaMarca;
	}

	public void setTblistaMarca(List<ProductoModel> tblistaMarca) {
		this.tblistaMarca = tblistaMarca;
	}

	public ProveedorModel getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModel proveedor) {
		this.proveedor = proveedor;
	}

	
	

}
