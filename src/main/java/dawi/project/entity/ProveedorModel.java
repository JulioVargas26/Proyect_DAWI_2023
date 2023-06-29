package dawi.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class ProveedorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproveedor")
	private Integer idproveedor;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ruc")
	private String ruc;
	@Column(name="direccion")
	private String direccion;
	
	//relación UNO A MUCHOS
	@OneToMany(mappedBy = "proveedor") //nombre de la asociación
	@JsonIgnore
	private List<MarcaModel> tblistaProveedor;
	
	@OneToMany(mappedBy="proveedorEntrada")
	@JsonIgnore
	private List<Entradas> listaEntradasProveedor;

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<MarcaModel> getTblistaProveedor() {
		return tblistaProveedor;
	}

	public void setTblistaProveedor(List<MarcaModel> tblistaProveedor) {
		this.tblistaProveedor = tblistaProveedor;
	}

	public List<Entradas> getListaEntradasProveedor() {
		return listaEntradasProveedor;
	}

	public void setListaEntradasProveedor(List<Entradas> listaEntradasProveedor) {
		this.listaEntradasProveedor = listaEntradasProveedor;
	}


	
	
}
