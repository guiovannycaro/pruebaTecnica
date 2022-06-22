package com.pruebatecnica.model;

public class Usuarios {
String id;
String nombres;
String apellidos;
String email;
String ciudad;
String pais;
String telefono;

public Usuarios() {
}



public String getTelefono() {
	return telefono;
}



public void setTelefono(String telefono) {
	this.telefono = telefono;
}



public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getPais() {
	return pais;
}

public void setPais(String pais) {
	this.pais = pais;
}

@Override
public String toString() {
	return "Usuarios [nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", ciudad=" + ciudad
			+ ", pais=" + pais + "]";
}

}
