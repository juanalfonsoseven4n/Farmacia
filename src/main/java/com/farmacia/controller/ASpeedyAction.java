package com.farmacia.controller;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ibatis.common.util.PaginatedList;


/**
 * Clase Abstracta que funciona como base de los action y provee funcionaledades
 * comunes como la implementacion de la interfaz IPaginable
 * @version 1.0
 * @created 11-Oct-2006 10:36:32 AM
 */
public abstract class ASpeedyAction extends DispatchAction implements IPaginable {


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
			throws java.lang.Exception{
		String listToPag=(String)request.getParameter("listToPag");
		PaginatedList pList=(PaginatedList)request.getSession().getAttribute(listToPag);
		String newPag=(String)request.getParameter("newPag");
		String forwardPager=(String)request.getParameter("forwardPager");
		String nameForm=(String)request.getParameter("nameForm");
		pList.gotoPage(Integer.parseInt(newPag));
		request.getSession().setAttribute("stringpag",getStringPage(pList,listToPag,nameForm,forwardPager));
		return mapping.findForward(forwardPager);
	}
	
	

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
	public String getStringPage(PaginatedList pList,String listaToPag,String nameForm,String forwardPager){
		
		String dif="";
		if((nameForm!=null)&&(nameForm.indexOf("*")==-1))
		{
			double random=Math.random()*1000;
			dif=Integer.toString((int)random); //La diferencia es un rand.
		}else{
			dif=nameForm.substring(1);//Eliminar el * y la diferencia es el parametro nameForm
		}
		
		
		int nPagActual=pList.getPageIndex();
		
		
		StringBuffer sb=new StringBuffer();
		
		if(pList.isPreviousPageAvailable()){
			sb.append("<< ");
			sb.append("<a href=\'javascript:SaltarAPagina"+dif+"(");
        	sb.append(nPagActual-1);
        	sb.append(")\'>");
        	sb.append("atrás");
        	sb.append("</a>");
    
		}
		if(pList.isPreviousPageAvailable()||pList.isNextPageAvailable()){
			sb.append(" || ");
    
		}
		/*else{
			sb.append("atrás");
		}*/
		//sb.append(" || ");
		if(pList.isNextPageAvailable()){
	    	sb.append("<a href=\'javascript:SaltarAPagina"+dif+"(");
        	sb.append(nPagActual+1);
        	sb.append(")\'>");
        	sb.append("siguiente");
        	sb.append("</a>");
        	sb.append(" >>");
		}
		/*else{
			sb.append("adelante");
		}*/
		
		
		if((nameForm!=null)&&(nameForm.indexOf("*")==-1))
		{
		    sb.append("<script>"); 
	    	sb.append("function SaltarAPagina"+dif+"(pagina){");
	    	sb.append("document.");
	    	sb.append(nameForm);
	    	sb.append(".newPag.value=pagina; ");
	    	sb.append("document.");
	    	sb.append(nameForm);
	    	sb.append(".method.value='pager'; ");
	    	sb.append("document.");
	    	sb.append(nameForm);
	    	sb.append(".action=document.");
	    	sb.append(nameForm);		
	    	sb.append(".listPager.value;");
	    	sb.append("document.");
	    	sb.append(nameForm);
	    	sb.append(".submit();} ");
	    	sb.append("</script>");
		}
    	sb.append("<input type=hidden name=newPag >");
    	sb.append("<input type=hidden name=nameForm value=\'");
    	sb.append(nameForm);	
    	sb.append("\'>");
    	sb.append("<input type=hidden name=listToPag value=\'");
    	sb.append(listaToPag);	
    	sb.append("\'>");
    	sb.append("<input type=hidden name=forwardPager value=\'");
    	sb.append(forwardPager);	
    	sb.append("\'>");
    	return sb.toString();
		}
	
	/*public void setUserSession(javax.servlet.http.HttpServletRequest request)
			throws java.lang.Exception{
		
		
		String idUserSession = request.getUserPrincipal().getName();
		System.out.println("BAJO EL USUARIO DE SESSION");
		BigDecimal id = new BigDecimal("1");
		UsuarioVO usuarioVO = new UsuarioVO();
		
		
		
		GestorUsuario usuarioUD = new GestorUsuario();
		
		id = usuarioUD.obtenerIdUsuario(idUserSession);
		
		usuarioVO = ConvertirClase.convertirUsuario(usuarioUD.getUsuarioById(id));
		
		request.getSession().setAttribute("usuario", usuarioVO);
		
		System.out.println("Usuario puesto en session " + usuarioVO);
	}
	
	
	public UsuarioVO getUserSession(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception{
	
		UsuarioVO usuario = new UsuarioVO();
		usuario =(UsuarioVO)request.getSession().getAttribute("usuario");
		if(usuario==null){
			setUserSession(request);
			usuario =(UsuarioVO)request.getSession().getAttribute("usuario");
		}
		
		return usuario;
	}
	*/
	
}

