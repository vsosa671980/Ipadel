package dao;

import java.sql.*;
import java.util.Properties;

public class DBconection {

	

	private static String dB_user = "root";
	private static String password_user = "Suse@2029";
	private static String url_user = "jdbc:mysql://localhost:3306/padel";
	private static String jdbcName = "com.mysql.cj.jdbc.Driver";


	private DBconection() {
	}
	public static Connection getConnection() throws SQLException {

		Connection conn = null;

		if (conn == null) {
			try {
				Class.forName(jdbcName);

			} catch (Exception e) {
				System.out.println("e.printStackTrace()");
				e.printStackTrace();
			}
		}

		try {
			conn = DriverManager.getConnection(url_user, dB_user, password_user);
			System.out.println("Conectado");
		} catch (SQLException e) {
			System.out.println("Problema con la conexion de la base de datos");
			e.printStackTrace();
		}
		return conn;

	}

	// Creamos el metodo para cerrar el Resulset
	public static void close(ResultSet rs) throws SQLException {
		rs.close();

	}

	//Creamos metoido para cerrar la conexion
	public static void close(Connection conn) throws SQLException {

		conn.close();

	}

	//Creamos metodo para cerrar el prepareStatement

	public static void close(PreparedStatement ps) throws SQLException {
		ps.close();
	}


}
	

