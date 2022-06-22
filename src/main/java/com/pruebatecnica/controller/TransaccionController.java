package com.pruebatecnica.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pruebatecnica.datos.Conexion;
import com.pruebatecnica.model.Usuarios;

public class TransaccionController {
	Conexion ConexionBasesDatos = new Conexion();
	ArrayList<Usuarios> usuario = new ArrayList<Usuarios>();
	ResultSet resultadoConsulta;

	public List<Usuarios> consultaListaUsuarios() {

		try {

			String sql = "select * from usuarios ";
			Statement sentencia = ConexionBasesDatos.getConnection().createStatement();
			resultadoConsulta = sentencia.executeQuery(sql);

			while (resultadoConsulta.next()) {
				Usuarios datosUsuarios = new Usuarios();
				datosUsuarios.setId(resultadoConsulta.getString(1));
				datosUsuarios.setNombres(resultadoConsulta.getString(2));
				datosUsuarios.setApellidos(resultadoConsulta.getString(3));
				datosUsuarios.setEmail(resultadoConsulta.getString(4));
				datosUsuarios.setCiudad(resultadoConsulta.getString(5));
				datosUsuarios.setPais(resultadoConsulta.getString(6));
				usuario.add(datosUsuarios);

			}
		
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return usuario;
	}

	public List<Usuarios> consultaUsuariosPorId(String id) {

		try {

			Integer idUsuario = Integer.parseInt(id);

			String sql = "select * from usuarios where id =  " + idUsuario + " ";
			Statement sentencia = ConexionBasesDatos.getConnection().createStatement();
			resultadoConsulta = sentencia.executeQuery(sql);

			while (resultadoConsulta.next()) {
				Usuarios datosUsuarios = new Usuarios();
				datosUsuarios.setId(resultadoConsulta.getString(1));
				datosUsuarios.setNombres(resultadoConsulta.getString(2));
				datosUsuarios.setApellidos(resultadoConsulta.getString(3));
				datosUsuarios.setEmail(resultadoConsulta.getString(4));
				datosUsuarios.setCiudad(resultadoConsulta.getString(5));
				datosUsuarios.setPais(resultadoConsulta.getString(6));
				usuario.add(datosUsuarios);

			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return usuario;
	}

	public String insertarUsuarios(String nombres, String apellidos, String email, String ciudad, String pais,String telefono) {

		String mensaje = null;
		try {
			String sql = "insert into usuarios  (nombres,apellidos,email,ciudad,pais,telefono) values ('" + nombres + "','" + apellidos + "','" + email + "','"
					+ ciudad + "','" + pais + "','" + telefono + "')";

			Statement sentencia = ConexionBasesDatos.getConnection().createStatement();
			sentencia.executeUpdate(sql);
			mensaje = "Se inserto el registro e manera correcta";

		
			
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

		return mensaje;

	}

	public String editarUsuarios(String id, String nombres, String apellidos, String email, String ciudad,
			String pais) {
		String mensaje = null;
		try {
			String sql = "update usuarios  set " + "nombres =  '" + nombres + "', " + "apellidos  = '" + apellidos
					+ "', " + "email      = '" + email + "'," + "ciudad      = '" + ciudad + "'," + "pais      = '"
					+ pais + "'" + " where id= '" + id + "'";

			Statement sentencia = ConexionBasesDatos.getConnection().createStatement();
			sentencia.executeUpdate(sql);
			mensaje = "Se edito el registro e manera correcta";
		
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

		return mensaje;
	}

}
