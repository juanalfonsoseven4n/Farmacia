

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla InventarioForm
 * @author SPEEDY
 * 
 */

public class InventarioForm extends ValidatorForm  {
	  
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
			private String idinventario; 
			private String idproducto; 
			private String cantidad; 
			private String fechaexpir; 
			private String fechaing; 
			private String codigo; 
			private String preciocosto; 
			private String idfarmacia; 
	


	/**
	 * Definición de métodos de acceso a los atributos de clase: 
	 */
	
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdinventario () {
		return idinventario;
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
	public String getFechaexpir () {
		
		if(fechaexpir.length()>8){
			String fecharet= fechaexpir.substring(0,4)+fechaexpir.substring(5,7)+fechaexpir.substring(8,10);
			return fecharet;
			}else {
				return fechaexpir;	
			}
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getFechaing () {
		if(fechaing.length()>8){
			String fecharet= fechaing.substring(0,4)+fechaing.substring(5,7)+fechaing.substring(8,10);
			return fecharet;
			}else {
				return fechaing;	
			}
		
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getCodigo () {
		return codigo;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getPreciocosto () {
		return preciocosto;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdfarmacia () {
		return idfarmacia;
	}
		
	
	/**
	 * @param idinventario
	 */
	public void setIdinventario(String idinventario) {
		this.idinventario = idinventario;
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
	 * @param fechaexpir
	 */
	public void setFechaexpir(String fechaexpir) {
		this.fechaexpir = fechaexpir;
	}
	
	/**
	 * @param fechaing
	 */
	public void setFechaing(String fechaing) {
		this.fechaing = fechaing;
	}
	
	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @param preciocosto
	 */
	public void setPreciocosto(String preciocosto) {
		this.preciocosto = preciocosto;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(String idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	

	public void clear () {
	  				 idinventario = "0"; 
					 idproducto = "0"; 
					 cantidad = "0"; 
					 fechaexpir = "0"; 
					 fechaing = "0"; 
					 codigo = ""; 
					 preciocosto = "0"; 
					 idfarmacia = "0"; 
			}
	public void clearStrings() {
					 idinventario = ""; 
					 idproducto = ""; 
					 cantidad = ""; 
					 fechaexpir = ""; 
					 fechaing = ""; 
					 codigo = ""; 
					 preciocosto = ""; 
					 idfarmacia = ""; 
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
