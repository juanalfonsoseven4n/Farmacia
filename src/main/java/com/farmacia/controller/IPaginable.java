package com.farmacia.controller;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibatis.common.util.PaginatedList;

/**
 * Interfaz que define un comportamiento para el manejo de paginacion
 * @version 1.0
 * @created 11-Oct-2006 10:36:48 AM
 */
public interface IPaginable {

	
	/**
	 * Método que invocado cada vez que se cambia de pagina.
	 * @param mapping
	 * @param form Es el path que se compara contra la URI solicitada de la
	 * solicitud entrante, y normalmente especifica el nombre totalmente cualificado
	 * de clase para la clase Action
	 * @param request     request del servlet
	 * @param response    response del servlet
	 * @return
	 * @throws java.lang.Exception  
	 */
	public ActionForward pager(ActionMapping mapping, ActionForm form,
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws java.lang.Exception;
	
	/**
	 * Método que obtiene el string que se imprime en la interfaz de usuario
	 * para el manejo de la paginación
	 * @param pList Lista de objetos a paginar
	 * @param listaToPag Nombre de la lista en sesión
	 * @param nameForm Nombre del formulario en donde se encuentra la paginacion
	 * @param forwardPager Forward de retorno luego de realizar la operacion de paginado. 
	 * @return  String que contiene la cadena con los elementos necesarios en la jsp
	 * para realizar la paginación
	 */
	public String getStringPage(PaginatedList pList,String listaToPag,String nameForm,String forwardPager);
	
	
}