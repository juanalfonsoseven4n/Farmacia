package com.farmacia.controller;
import com.farmacia.pojo.IFarmacia;


/**
 * Interfaz que provee el acceso a los servicios del Negocio
 * @version 1.0
 * @created 11-Oct-2006 10:36:50 AM
 */
public interface IServiceLocator {

	/**
	 * Obtiene el modelo de negocio para la gestion de los datos
	 */
	public IFarmacia getFarmacia();


}