
package com.farmacia.domain;

/**
 * Clase que representa un objeto de la tabla Opcper
 * @author SPEEDY
 * 
 */
 
public class Opcper implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idopcion; 
			private java.math.BigDecimal idperfil; 
			private java.math.BigDecimal idopcper; 
	
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdopcion () {
		return idopcion;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdperfil () {
		return idperfil;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdopcper () {
		return idopcper;
	}
		
	
	/**
	 * @param idopcion
	 */
	public void setIdopcion(java.math.BigDecimal idopcion) {
		this.idopcion = idopcion;
	}
	
	/**
	 * @param idperfil
	 */
	public void setIdperfil(java.math.BigDecimal idperfil) {
		this.idperfil = idperfil;
	}
	
	/**
	 * @param idopcper
	 */
	public void setIdopcper(java.math.BigDecimal idopcper) {
		this.idopcper = idopcper;
	}
		
}
