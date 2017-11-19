package com.farmacia.controller;
import com.farmacia.pojo.FarmaciaModel;
import com.farmacia.pojo.IFarmacia;


/**
 * Clases que implementa los metodos necesarios para el acceso a los servicios del
 * Negocio
 * @version 1.0
 * @created 11-Oct-2006 10:37:04 AM
 */
public class ServiceLocator implements IServiceLocator {

	/**
	 * Obtiene el modelo de negocio para la gestion de los datos
	 */
	public IFarmacia getFarmacia(){
		IFarmacia Farmacia = new FarmaciaModel();
		return Farmacia;
	}

}