package dawi.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_has_entrada")
public class ProductoHasEntrada {
	@EmbeddedId
	private ProductoHasEntradaPK pk;
	
	//Relación MUCHOS  a UNO "Medicamento"
		@ManyToOne
		@JoinColumn(name="idproducto",referencedColumnName = "idproducto",insertable = false,updatable =false)
		private ProductoModel producto;//ASOCI.
		
		//Relación MUCHOS  a UNO "Boleta"
		@ManyToOne
		@JoinColumn(name="identradas",referencedColumnName = "identradas",insertable = false,updatable =false)
		private Entradas entradas;//ASOCI.
		
		@Column(name = "precio")
		private double precio;

		public ProductoHasEntradaPK getPk() {
			return pk;
		}

		public void setPk(ProductoHasEntradaPK pk) {
			this.pk = pk;
		}

		public ProductoModel getProducto() {
			return producto;
		}

		public void setProducto(ProductoModel producto) {
			this.producto = producto;
		}

		public Entradas getEntradas() {
			return entradas;
		}

		public void setEntradas(Entradas entradas) {
			this.entradas = entradas;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
	
		
		
	
	
}
