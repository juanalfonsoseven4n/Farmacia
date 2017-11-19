

package com.farmacia.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



/**
 * Clase que representa un objeto de la tabla GastoForm
 * @author SPEEDY
 * 
 */

public class GastoForm extends ValidatorForm  {
	  
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
	 * Definici?n de atributos privados de clase:
	 */
			private String idgasto; 
			private String descripcion; 
			private String nombre; 
			private String fecha; 
			private String valor; 
			private String idusuario; 
			private String idfarmacia; 
			private String userdesc;
			private String farmdesc;


	/**
	 * Definici?n de m?todos de acceso a los atributos de clase: 
	 */
	
	
	public String getFarmdesc() {
				return farmdesc;
			}

			public void setFarmdesc(String farmdesc) {
				this.farmdesc = farmdesc;
			}

			public String getUserdesc() {
				return userdesc;
			}

			public void setUserdesc(String userdesc) {
				this.userdesc = userdesc;
			}

	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdgasto () {
		return idgasto;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getDescripcion () {
		return descripcion;
	}
	
	/**
	 * @return java.lang.String
	 */
	public String getNombre () {
		return nombre;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getFecha () {
		if(fecha.length()>8){
		String fecharet= fecha.substring(0,4)+fecha.substring(5,7)+fecha.substring(8,10);
		return fecharet;
		}else {
			return fecha;	
		}
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
	public String getIdusuario () {
		return idusuario;
	}
	
	/**
	 * @return java.math.BigDecimal
	 */
	public String getIdfarmacia () {
		return idfarmacia;
	}
		
	
	/**
	 * @param idgasto
	 */
	public void setIdgasto(String idgasto) {
		this.idgasto = idgasto;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * @param idusuario
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * @param idfarmacia
	 */
	public void setIdfarmacia(String idfarmacia) {
		this.idfarmacia = idfarmacia;
	}
	

	public void clear () {
	  				 idgasto = "0"; 
					 descripcion = ""; 
					 nombre = ""; 
					 fecha = "0"; 
					 valor = "0"; 
					 idusuario = "0"; 
					 idfarmacia = "0"; 
			}
	public void clearStrings() {
					 idgasto = ""; 
					 descripcion = ""; 
					 nombre = ""; 
					 fecha = ""; 
					 valor = ""; 
					 idusuario = ""; 
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
