package dawi.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="entradas")
public class Entradas implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identradas")
	private int codigo;
	
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "precio_compra")
	private double precioCompra;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="idalmacenero")
	private Usuario usuario;
	
	@OneToMany(mappedBy="entradas")
	@JsonIgnore
	private List<ProductoHasEntrada> listaProductoHasEntrada;
	
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private ProveedorModel proveedorEntrada;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductoHasEntrada> getListaProductoHasEntrada() {
		return listaProductoHasEntrada;
	}

	public void setListaProductoHasEntrada(List<ProductoHasEntrada> listaProductoHasEntrada) {
		this.listaProductoHasEntrada = listaProductoHasEntrada;
	}

	public ProveedorModel getProveedorEntrada() {
		return proveedorEntrada;
	}

	public void setProveedorEntrada(ProveedorModel proveedorEntrada) {
		this.proveedorEntrada = proveedorEntrada;
	}
	
	
	
	
	
}
