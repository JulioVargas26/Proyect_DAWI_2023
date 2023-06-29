package dawi.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="almacenero")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idalmacenero")
	private int idalmacenero;
	@Column(name="nombre")
	private String nombre;
	@Column(name="login")
	private String login;
	@Column(name="clave")
	private String clave;
	@Column(name="telefono")
	private String telefono;
	@Column(name="correo")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(int codUsuario) {
		idalmacenero=codUsuario;
	}
	
	public int getIdalmacenero() {
		return idalmacenero;
	}
	public void setIdalmacenero(int idalmacenero) {
		this.idalmacenero = idalmacenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	

	
	
}
