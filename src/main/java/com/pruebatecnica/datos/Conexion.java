package com.pruebatecnica.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	Connection con;

	public Conexion() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			String db = "jdbc:mysql://localhost/pruebaTecnica";
			con = DriverManager.getConnection(db, "root", "");

		} catch (Exception ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public Connection getConnection() {
		return con;
	}
	
	public void cerrarConeccion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
