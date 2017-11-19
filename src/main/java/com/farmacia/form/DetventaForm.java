

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla DetventaForm
 * @author SPEEDY
 * 
 */

public class DetventaForm extends ValidatorForm  {
	  
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
			private String iddetventa; 
			private String idventa; 
			private String idproducto; 
			private String cantidad; 
			private String valor; 
			private String iva; 
			private String ivadet; 
			private String valorunit; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIddetventa () {
		return iddetventa;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdventa () {
		return idventa;
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
	public String getCantidad () {
		return cantidad;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValor () {
		return valor;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIva () {
		return iva;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getValorunit () {
		return valorunit;
	}
		
	
	/**
	 * @param iddetventa
	 */
	public void setIddetventa(String iddetventa) {
		this.iddetventa = iddetventa;
	}
	
	/**
	 * @param idventa
	 */
	public void setIdventa(String idventa) {
		this.idventa = idventa;
	}
	
	/**
	 * @param idproducto
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * @param cantidad
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * @param iva
	 */
	public void setIva(String iva) {
		this.iva = iva;
	}
	
	/**
	 * @param valorunit
	 */
	public void setValorunit(String valorunit) {
		this.valorunit = valorunit;
	}
	
	

	public String getIvadet() {
		return ivadet;
	}

	public void setIvadet(String ivadet) {
		this.ivadet = ivadet;
	}

	public void clear () {
	  				 iddetventa = "0"; 
					 idventa = "0"; 
					 idproducto = "0"; 
					 cantidad = "0"; 
					 valor = "0"; 
					 iva = "0";
					 ivadet = "0";
					 valorunit = "0"; 
			}
	public void clearStrings() {
					 iddetventa = ""; 
					 idventa = ""; 
					 idproducto = ""; 
					 cantidad = ""; 
					 valor = ""; 
					 iva = "";
					 ivadet = "";
					 valorunit = ""; 
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
