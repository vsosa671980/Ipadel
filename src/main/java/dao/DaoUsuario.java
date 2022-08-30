package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Persona;
import modelo.Usuario;


public class DaoUsuario {
	
	private Connection con = null;
	private static DaoUsuario instance = null;
	
	public DaoUsuario() throws SQLException {
		
		con = DBconection.getConnection();
	}
	
	
	
	public static DaoUsuario getInstance() throws SQLException {
		
		if(instance == null) {
		instance = new DaoUsuario();
		}
		return instance;

	}
	
	public Usuario logeo(Usuario u,String pass) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? and pass = ?");
		ps.setString(1, u.getNombre());
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		Usuario result = null;
		if (rs.next()) {
			result = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("mail"),rs.getInt("permisos"));
			
		}
	
		
		rs.close();
		ps.close();
		return result;
	}

}
