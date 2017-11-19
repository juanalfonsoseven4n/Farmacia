

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla LaboratorioForm
 * @author SPEEDY
 * 
 */

public class LaboratorioForm extends ValidatorForm  {
	  
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
			private String idlaboratorio; 
			private String nombre; 
			private String descripcion; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdlaboratorio () {
		return idlaboratorio;
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
	 * @param idlaboratorio
	 */
	public void setIdlaboratorio(String idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
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
	  				 idlaboratorio = "0"; 
					 nombre = ""; 
					 descripcion = ""; 
			}
	public void clearStrings() {
					 idlaboratorio = ""; 
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
