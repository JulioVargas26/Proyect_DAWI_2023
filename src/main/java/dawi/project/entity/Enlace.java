package dawi.project.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="enlace")

public class Enlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idenlace;
	private String descripcion;
	private String ruta;

	
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlace;


	public int getIdenlace() {
		return idenlace;
	}


	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}


	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}


	
}
