

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla OpcionForm
 * @author SPEEDY
 * 
 */

public class OpcionForm extends ValidatorForm  {
	  
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
			private String idopcion; 
			private String nombre; 
			private String descripcion; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdopcion () {
		return idopcion;
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
	public String getDescripcion () {
		return descripcion;
	}
		
	
	/**
	 * @param idopcion
	 */
	public void setIdopcion(String idopcion) {
		this.idopcion = idopcion;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public void clear () {
	  				 idopcion = "0"; 
					 nombre = ""; 
					 descripcion = ""; 
			}
	public void clearStrings() {
					 idopcion = ""; 
					 nombre = ""; 
					 descripcion = ""; 
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
}
