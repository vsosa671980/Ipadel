package modelo;

import java.sql.SQLException;


import dao.DaoPersona;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;

	private String contrasena;
	private String email;
	private String dni;
	private int contacto;
	private String nacionalidad;
	

	public Persona() {}


	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}




	public Persona(String nombre, String apellidos, String contrasena, String email, String dni, int contacto,
			String nacionalidad) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
		this.dni = dni;
		this.contacto = contacto;
		this.nacionalidad = nacionalidad;
	}


	public Persona(int id, String nombre, String apellidos, String contrasena, String email, String dni, int contacto,
			String nacionalidad) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
		this.dni = dni;
		this.contacto = contacto;
		this.nacionalidad = nacionalidad;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getContrasena() {
		return contrasena;
	}




	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public int getContacto() {
		return contacto;
	}




	public void setContacto(int contacto) {
		this.contacto = contacto;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrasena=" + contrasena
				+ ", email=" + email + ", dni=" + dni + ", contacto=" + contacto + ", nacionalidad=" + nacionalidad
				+ "]";
	}
	
	
	
	
}
