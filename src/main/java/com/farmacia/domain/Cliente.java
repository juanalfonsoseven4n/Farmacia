
package com.farmacia.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.farmacia.util.Utilitario;

/**
 * Clase que representa un objeto de la tabla Cliente
 * @author SPEEDY
 * 
 */
 
public class Cliente implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idcliente; 
			private java.lang.String nombre; 
			private java.lang.String apellido; 
			private java.lang.String direccion; 
			private String telefono; 
			private java.lang.String mail; 
			private java.lang.String cedula; 
			private java.lang.String clasdesc;
			private java.lang.String clasdesc2;
			private java.lang.String clasdesc3;
			private java.math.BigDecimal idclasificacion; 
			private java.lang.String observacion;
			private java.lang.String sexo;
			private java.math.BigDecimal idclasificacion2; 
			private java.math.BigDecimal idclasificacion3; 
			private java.math.BigDecimal fechanac; 
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdcliente () {
		return idcliente;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getApellido () {
		return apellido;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDireccion () {
		return direccion;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getTelefono () {
		return telefono;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getMail () {
		return mail;
	}
	
	
		
	
	/**
	 * @param idcliente
	 */
	public void setIdcliente(java.math.BigDecimal idcliente) {
		this.idcliente = idcliente;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param apellido
	 */
	public void setApellido(java.lang.String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * @param direccion
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @param mail
	 */
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}
	
	
	public java.lang.String getCedula() {
		return cedula;
	}

	public void setCedula(java.lang.String cedula) {
		this.cedula = cedula;
	}

	public java.lang.String getClasdesc() {
		return clasdesc;
	}

	public void setClasdesc(java.lang.String clasdesc) {
		this.clasdesc = clasdesc;
	}

	public java.math.BigDecimal getIdclasificacion() {
		return idclasificacion;
	}

	public void setIdclasificacion(java.math.BigDecimal idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public java.lang.String getObservacion() {
		return observacion;
	}

	public void setObservacion(java.lang.String observacion) {
		this.observacion = observacion;
	}

	

	public java.math.BigDecimal getFechanac() {
		return fechanac;
	}

	public void setFechanac(java.math.BigDecimal fechanac) {
		this.fechanac = fechanac;
	}

	public java.math.BigDecimal getIdclasificacion2() {
		return idclasificacion2;
	}

	public void setIdclasificacion2(java.math.BigDecimal idclasificacion2) {
		this.idclasificacion2 = idclasificacion2;
	}

	public java.math.BigDecimal getIdclasificacion3() {
		return idclasificacion3;
	}

	public void setIdclasificacion3(java.math.BigDecimal idclasificacion3) {
		this.idclasificacion3 = idclasificacion3;
	}

	public java.lang.String getSexo() {
		return sexo;
	}

	public void setSexo(java.lang.String sexo) {
		this.sexo = sexo;
	}

	public java.lang.String getClasdesc2() {
		return clasdesc2;
	}

	public void setClasdesc2(java.lang.String clasdesc2) {
		this.clasdesc2 = clasdesc2;
	}

	public java.lang.String getClasdesc3() {
		return clasdesc3;
	}

	public void setClasdesc3(java.lang.String clasdesc3) {
		this.clasdesc3 = clasdesc3;
	}
		
	public BigDecimal getEdad() {
		BigDecimal edad = new BigDecimal(0);
		try {
			String fecha = Utilitario.formatoDate(Utilitario.obtenerFechaSistema());
			int year = Integer.parseInt(fecha.substring(0, 4));
			if(getFechanac()!=null){
				int yearnac = Integer.parseInt(getFechanac().toString().substring(0, 4));
				edad = new BigDecimal((year-yearnac));
			}
		} catch (Exception e) {
			System.err.println("Error obteniendo edad.");
		}
		
		return edad;
	}
}
