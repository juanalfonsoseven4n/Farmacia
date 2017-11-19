

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla ProvprodForm
 * @author SPEEDY
 * 
 */

public class ProvprodForm extends ValidatorForm  {
	  
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
			private String idproveedor; 
			private String idproducto; 
			private String idprovprod; 
			private String valor; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdproveedor () {
		return idproveedor;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdproducto () {
		return idproducto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdprovprod () {
		return idprovprod;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValor () {
		return valor;
	}
		
	
	/**
	 * @param idproveedor
	 */
	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param idprovprod
	 */
	public void setIdprovprod(String idprovprod) {
		this.idprovprod = idprovprod;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	

	public void clear () {
	  				 idproveedor = "0"; 
					 idproducto = "0"; 
					 idprovprod = "0"; 
					 valor = "0"; 
			}
	public void clearStrings() {
					 idproveedor = ""; 
					 idproducto = ""; 
					 idprovprod = ""; 
					 valor = ""; 
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
