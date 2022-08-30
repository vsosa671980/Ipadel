package modelo;

import java.sql.SQLException;

import dao.DaoUsuario;

public class Usuario {

	private int id;
	private String nombre;
	private String mail;
	private int permiso;
	

	public Usuario(String nombre) {
		
		this.nombre = nombre;
		this.mail = mail;
	
	}
	
	public Usuario(String nombre, String mail, int permiso) {
		
		this.nombre = nombre;
		this.mail = mail;
		this.permiso = permiso;
	}


	public Usuario(int id, String nombre, String mail, int permiso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.permiso = permiso;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
	public boolean logeando(String pass) throws SQLException {
		
		boolean ok = false;
		
		Usuario aux = DaoUsuario.getInstance().logeo(this, pass);
		
		if(aux != null) {
			ok = true;
			this.id = aux.getId(); 
			this.nombre = aux.getNombre();
			this.mail = aux.getMail();
			this.permiso = aux.getPermiso();
		}
		return ok;
		
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", permiso=" + permiso + "]";
	}
	
	
	
	
	
}
