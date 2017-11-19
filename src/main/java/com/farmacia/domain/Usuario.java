
package com.farmacia.domain;


/**
 * Clase que representa un objeto de la tabla Usuario
 * @author SPEEDY
 * 
 */
 
public class Usuario implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Definición de atributos privados de clase:
	 */
			private java.math.BigDecimal idusuario; 
			private java.math.BigDecimal idfarmacia; 
			private java.math.BigDecimal idperfil; 
			private java.lang.String nombre; 
			private java.lang.String apellido; 
			private java.lang.String direccion; 
			private java.lang.String mail; 
			private java.math.BigDecimal cedula; 
			private java.math.BigDecimal telefono2; 
			private java.math.BigDecimal telefono; 
			private java.lang.String especializacion; 
			private java.lang.String descripcion; 
			private java.lang.String password; 
			private java.lang.String passwordold; 
			private java.lang.String passwordconf; 
	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getIdusuario () {
		return idusuario;
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
	 * @return java.lang.String
	 */
	public java.lang.String getMail () {
		return mail;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getCedula () {
		return cedula;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTelefono2 () {
		return telefono2;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTelefono () {
		return telefono;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getEspecializacion () {
		return especializacion;
	}
	
	/**
	 * @return java.lang.String
	 */
	public java.lang.String getDescripcion () {
		return descripcion;
	}
		
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(java.math.BigDecimal idusuario) {
		this.idusuario = idusuario;
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
	 * @param mail
	 */
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}
	
	/**
	 * @param cedula
	 */
	public void setCedula(java.math.BigDecimal cedula) {
		this.cedula = cedula;
	}
	
	/**
	 * @param telefono2
	 */
	public void setTelefono2(java.math.BigDecimal telefono2) {
		this.telefono2 = telefono2;
	}
	
	/**
	 * @param telefono
	 */
	public void setTelefono(java.math.BigDecimal telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @param especializacion
	 */
	public void setEspecializacion(java.lang.String especializacion) {
		this.especializacion = especializacion;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.math.BigDecimal getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(java.math.BigDecimal idperfil) {
		this.idperfil = idperfil;
	}

	public java.math.BigDecimal getIdfarmacia() {
		return idfarmacia;
	}

	public void setIdfarmacia(java.math.BigDecimal idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

	public java.lang.String getPasswordconf() {
		return passwordconf;
	}

	public void setPasswordconf(java.lang.String passwordconf) {
		this.passwordconf = passwordconf;
	}

	public java.lang.String getPasswordold() {
		return passwordold;
	}

	public void setPasswordold(java.lang.String passwordold) {
		this.passwordold = passwordold;
	}

		
}
