package dawi.project.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductoHasEntradaPK implements Serializable{
	@Column(name = "idproducto")
	private int idProducto;
	@Column(name = "identradas")
	private int idEntradas;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdEntradas() {
		return idEntradas;
	}
	public void setIdEntradas(int idEntradas) {
		this.idEntradas = idEntradas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEntradas;
		result = prime * result + idProducto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoHasEntradaPK other = (ProductoHasEntradaPK) obj;
		if (idEntradas != other.idEntradas)
			return false;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	
}
