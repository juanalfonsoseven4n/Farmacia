

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla ClienteForm
 * @author SPEEDY
 * 
 */

public class ClienteForm extends ValidatorForm  {
	  
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	  private int strutsAction;
	  private String strutsOrderby;
	  private String searchButton = "";
	  private String strutsLimit;
	  private String strutsButton = "";
	  
	/**
	 * Definición de atributos privados de clase:
	 */
			private String idcliente; 
			private String nombre; 
			private String apellido; 
			private String direccion; 
			private String telefono; 
			private String mail; 
			private String cedula; 
			private String clasdesc; 
			private String clasdesc2; 
			private String clasdesc3; 
			private String idclasificacion;
			private String idclasificacion2;
			private String idclasificacion3;
			private String observacion;
			private String sexo;
			private String fechanac;


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdcliente () {
		return idcliente;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getApellido () {
		return apellido;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getDireccion () {
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
	public String getMail () {
		return mail;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getCedula () {
		return cedula;
	}
		
	
	/**
	 * @param idcliente
	 */
	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
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
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	

	public void clear () {
	  				 idcliente = "0"; 
					 nombre = ""; 
					 apellido = ""; 
					 direccion = ""; 
					 telefono = ""; 
					 mail = ""; 
					 cedula = "0"; 
					 clasdesc = ""; 
					 idclasificacion = "0"; 
					 observacion = "";
			}
	public void clearStrings() {
					 idcliente = ""; 
					 nombre = ""; 
					 apellido = ""; 
					 direccion = ""; 
					 telefono = ""; 
					 mail = ""; 
					 cedula = ""; 
					 clasdesc = ""; 
					 idclasificacion = "0"; 
					 observacion = "";
			}

	public ActionErrors validate(ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
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

	public String getClasdesc() {
		return clasdesc;
	}

	public void setClasdesc(String clasdesc) {
		this.clasdesc = clasdesc;
	}

	public String getIdclasificacion() {
		return idclasificacion;
	}

	public void setIdclasificacion(String idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getClasdesc2() {
		return clasdesc2;
	}

	public void setClasdesc2(String clasdesc2) {
		this.clasdesc2 = clasdesc2;
	}

	public String getClasdesc3() {
		return clasdesc3;
	}

	public void setClasdesc3(String clasdesc3) {
		this.clasdesc3 = clasdesc3;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public String getIdclasificacion2() {
		return idclasificacion2;
	}

	public void setIdclasificacion2(String idclasificacion2) {
		this.idclasificacion2 = idclasificacion2;
	}

	public String getIdclasificacion3() {
		return idclasificacion3;
	}

	public void setIdclasificacion3(String idclasificacion3) {
		this.idclasificacion3 = idclasificacion3;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
