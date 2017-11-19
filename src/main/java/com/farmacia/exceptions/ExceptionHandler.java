package com.farmacia.exceptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.config.ExceptionConfig;

/**
 * Clase para el manejo de Excepciones ApplicationException
 * Realiza el log de error.
 * Redirecciona a una pagina de error mostrando al usuario un 
 * mensaje de acuerdo al error presentado.
 * @author Fredy Yamid Sierra 
 * @date 17/11/2006
 */
public class ExceptionHandler extends org.apache.struts.action.ExceptionHandler {
	
	
	/**
	 * Metodo que se ejecuta para el manejo de la exception.
	 */
	public ActionForward execute(Exception exception, ExceptionConfig eConfig,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		ApplicationException applicationException = (ApplicationException) exception;
		System.err.println("HA OCURRIDO UN ERROR");
		ActionMessage p = new ActionMessage(applicationException.getErrorCode());
		ActionMessages ms = new ActionMessages();
		ms.add("errors", p);
		request.setAttribute("errors", ms);
		return super.execute(exception, eConfig, mapping, form, request,
				response);
	}
}
