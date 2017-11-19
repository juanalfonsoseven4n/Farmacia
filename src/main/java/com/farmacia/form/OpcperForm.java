

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla OpcperForm
 * @author SPEEDY
 * 
 */

public class OpcperForm extends ValidatorForm  {
	  
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
			private String idperfil; 
			private String idopcper; 
	


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
	 * @return java.math.BigDecimal
	 */
	public String getIdperfil () {
		return idperfil;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdopcper () {
		return idopcper;
	}
		
	
	/**
	 * @param idopcion
	 */
	public void setIdopcion(String idopcion) {
		this.idopcion = idopcion;
	}
	
	/**
	 * @param idperfil
	 */
	public void setIdperfil(String idperfil) {
		this.idperfil = idperfil;
	}
	
	/**
	 * @param idopcper
	 */
	public void setIdopcper(String idopcper) {
		this.idopcper = idopcper;
	}
	

	public void clear () {
	  				 idopcion = "0"; 
					 idperfil = "0"; 
					 idopcper = "0"; 
			}
	public void clearStrings() {
					 idopcion = ""; 
					 idperfil = ""; 
					 idopcper = ""; 
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
