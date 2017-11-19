
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Perfil
 * @author SPEEDY
 * 
 */
 
public class Perfil implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idperfil; 
			private java.lang.String nombre; 
			private java.lang.String descripcion; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdperfil () {
		return idperfil;
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
	public java.lang.String getDescripcion () {
		return descripcion;
	}
		
	
	/**
	 * @param idperfil
	 */
	public void setIdperfil(java.math.BigDecimal idperfil) {
		this.idperfil = idperfil;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}
		
}
