package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Clase que representa un objeto de la tabla UsuarioForm
 * 
 * @author SPEEDY
 * 
 */

public class UsuarioForm extends ValidatorForm {

	  
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public void iniciar() {
		
		this.idusuario = "0";
		this.cedula = "0";
		this.telefono2 = "0";
		this.telefono = "0";
		this.idperfil = "0";
		this.idfarmacia = "0";
	}

	private int strutsAction;

	private String strutsOrderby;

	private String searchButton = "";

	private String strutsLimit;

	private String strutsButton = "";

	/**
	 * Definición de atributos privados de clase:
	 */
	private String idusuario;
	
	private String idperfil;
	
	private String idfarmacia;

	private String nombre;

	private String apellido;

	private String direccion;

	private String mail;

	private String cedula;

	private String telefono2;

	private String telefono;

	private String especializacion;

	private String descripcion;

	private String password;
	
	private String passwordold; 
	
	private String passwordconf; 

	/**
	 * Definición de métodos de acceso a los atributos de clase:
	 */

	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdusuario() {
		return idusuario;
	}

	/**
	 * @return java.lang.String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return java.lang.String
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return java.lang.String
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return java.lang.String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getTelefono2() {
		return telefono2;
	}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @return java.lang.String
	 */
	public String getEspecializacion() {
		return especializacion;
	}

	/**
	 * @return java.lang.String
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param idusuario
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @param telefono2
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	/**
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @param especializacion
	 */
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void clear() {
		idusuario = "0";
		nombre = "";
		apellido = "";
		direccion = "";
		mail = "";
		cedula = "0";
		telefono2 = "0";
		telefono = "0";
		especializacion = "";
		descripcion = "";
		idperfil = "";
		idfarmacia = "";
		password = "";
		passwordold = "";
		passwordconf = "";
	}

	public void clearStrings() {
		idusuario = "";
		nombre = "";
		apellido = "";
		direccion = "";
		mail = "";
		cedula = "";
		telefono2 = "";
		telefono = "";
		especializacion = "";
		descripcion = "";
		idperfil = "";
		idfarmacia = "";
		password = "";
		passwordold = "";
		passwordconf = "";
	}

	public ActionErrors validate(ActionMapping mapping,
			javax.servlet.http.HttpServletRequest request) {
		ActionErrors aes = super.validate(mapping, request);
		return aes;
	}

	public String getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(String searchButton) {
		this.searchButton = searchButton;
	}

	public int getStrutsAction() {
		return strutsAction;
	}

	public void setStrutsAction(int strutsAction) {
		this.strutsAction = strutsAction;
	}

	public String getStrutsButton() {
		return strutsButton;
	}

	public void setStrutsButton(String strutsButton) {
		this.strutsButton = strutsButton;
	}

	public String getStrutsLimit() {
		return strutsLimit;
	}

	public void setStrutsLimit(String strutsLimit) {
		this.strutsLimit = strutsLimit;
	}

	public String getStrutsOrderby() {
		return strutsOrderby;
	}

	public void setStrutsOrderby(String strutsOrderby) {
		this.strutsOrderby = strutsOrderby;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdfarmacia() {
		return idfarmacia;
	}

	public void setIdfarmacia(String idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

	public String getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(String idperfil) {
		this.idperfil = idperfil;
	}

	public String getPasswordconf() {
		return passwordconf;
	}

	public void setPasswordconf(String passwordconf) {
		this.passwordconf = passwordconf;
	}

	public String getPasswordold() {
		return passwordold;
	}

	public void setPasswordold(String passwordold) {
		this.passwordold = passwordold;
	}
}
