<%@ page contentType="text/html; charset=iso-8859-1"%>
<%@ page language="java" errorPage="/error.jsp"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean-el" prefix="bean-el"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html-el" prefix="html-el"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic-el" prefix="logic-el"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tiles.tld" prefix="comp"%>

<%@page import="java.text.DecimalFormat"%>
<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">


<html:form target="_self" action="/Venta.do?method=listVentasProd">
<script type="text/javascript">
	function enviar(forma, valor, idTabla)
	{
			forma.idTabla.value=idTabla;
			cambioAction(forma, valor);
	}
	function cambioAction(forma, valor)
	{
			forma.action=valor;
			forma.submit();
	}
	function limpiarFiltro(forma){
		document.getElementsByName('idlaboratorio')[0].value=''
		document.getElementsByName('descproducto')[0].value=''
		document.getElementsByName('fechaini')[0].value=''
		document.getElementsByName('fechafin')[0].value=''
		forma.submit();
	}
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Venta.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="venta.title.list" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<logic:present name="mensaje" scope="request">
					<tr>			
						<td class="exito" colspan="2" align="center">
							<bean:message name="mensaje" scope="request"/>
						</td>
					</tr>
				</logic:present>
				<logic:messagesPresent>
					<tr>
						<td colspan=3"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">

					<td align="center" colspan=3">
					
					<bean:message key="producto.field.idlaboratorio" />
					<html:select property="idlaboratorio" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="labLista" labelProperty="nombre" property="idlaboratorio" />
					</html:select>&nbsp; 
					
					<bean:message key="producto.title" />: &nbsp;
					<html:text  property="descproducto" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					
					<bean:message key="movimiento.field.fechaini"/>: &nbsp;
					<html:text styleClass="selText"    property="fechaini" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				 		alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');"> &nbsp;
					
					<bean:message key="movimiento.field.fechafin"/>: &nbsp;
					<html:text styleClass="selText"    property="fechafin" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   		alt="Obtener Fecha" onclick="return showCalendar('fechafin', 'y/mm/dd');"> &nbsp;			
					
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>

				</tr>

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">


					<td align="right" colspan=3"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></td>

				</tr>
				<%
					double totalValorPag=0; 
					double totalCantidadCaj=0; 	
					double totalCantidadUni=0; 	
					String strTotalValorPag="0"; 
					String strTotalCantidadCaj="0"; 	
					String strTotalCantidadUni="0"; 	
				%>
				<logic:notEmpty name="VENTASLISTPROD" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td><bean:message key="venta.field.fecha" /></td>
								<td><bean:message key="venta.field.idusuario" /></td>
								<td><bean:message key="detventa.field.idproducto" /></td>
								<td><bean:message key="detventa.field.cantidad" /></td>
								<td><bean:message key="venta.field.valortotal" /></td>
								<td><bean:message key="producto.field.idlaboratorio" /></td>
							</tr>

							<logic:iterate indexId="ind" id="ventaProd" name="VENTASLISTPROD"
								type="com.farmacia.domain.DetVentaProd">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td align="center"><bean:write name="ventaProd" property="fechaFormated"	scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="usuario" scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="nombreProducto" scope="page" /></td>
									<td align="right"><bean:write name="ventaProd" property="cantidad"	scope="page"/> 
									<logic:equal value="1" name="ventaProd" property="presentacion">
									CAJAS
								</logic:equal>
								<logic:notEqual value="1" name="ventaProd" property="presentacion">
									UNIDADES
								</logic:notEqual>
									</td>
									<td align="right">$<bean:write name="ventaProd" property="valor" scope="page"  format="#,##0.00"/></td>
									<td align="center"><bean:write name="ventaProd" property="labdesc"	scope="page"/></td>
										
								
									<%
										totalValorPag=totalValorPag+ventaProd.getValor().doubleValue();	
									if(ventaProd.getPresentacion().doubleValue()==1){
									totalCantidadCaj=totalCantidadCaj+ventaProd.getCantidad().doubleValue();	
									}else if(ventaProd.getPresentacion().doubleValue()==2){
										totalCantidadUni=totalCantidadUni+ventaProd.getCantidad().doubleValue();	
									}
										
									%>
											
										

								</tr>
							</logic:iterate>
							<%
									DecimalFormat format = new DecimalFormat("#,##0.00");
									strTotalValorPag =format.format(totalValorPag);
									strTotalCantidadCaj =format.format(totalCantidadCaj);
									strTotalCantidadUni =format.format(totalCantidadUni);
								%>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="VENTASLISTPROD" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<tr  align="center" class="titulos" >
					<td colspan="3" >&nbsp;
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td colspan="3" align="right">
                    	La suma de los valores es: $<%= strTotalValorPag %> &nbsp; <br>
                    </td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td colspan="3" align="right">
                    	La suma de las cantidades (CAJAS)es: <%= strTotalCantidadCaj %> &nbsp; <br>
                    	La suma de las cantidades (UNIDADES)es: <%= strTotalCantidadUni %> &nbsp; <br>
                    </td>
				</tr>
				
			</table>
			</td>
			</tr>
			</table>
			
</html:form>