package com.farmacia.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;


public class ServiciosPlugIn implements PlugIn
{

  
  public void init(ActionServlet servlet,ModuleConfig  moduleConfig)  throws ServletException
  {
    try{
    IServiceLocator servicios=new ServiceLocator();
    ServletContext context=servlet.getServletContext();
    context.setAttribute("servicios",servicios);
    }catch(Exception e)
    {
      throw new ServletException("Error al Iniciar los Servicios");  
    }
  }
  
  public void destroy()
  {
    
  }
  
}