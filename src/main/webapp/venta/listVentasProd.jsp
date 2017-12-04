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
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Venta.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


		<div class="tit">
		<span><bean:message
				key="venta.title.list" /></span>
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

		
		<div class="contBus">
			<span class="spanName" ><bean:message key="producto.field.idlaboratorio" /></span>
					<html:select property="idlaboratorio" >
						<html:option value="0">Seleccione</html:option>
						<html:options collection="labLista" labelProperty="nombre" property="idlaboratorio" />
					</html:select>
					
					<span class="spanName" ><bean:message key="producto.title" />:</span>
					<html:text styleClass="text" property="descproducto" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
					
					<span class="spanName" ><bean:message key="movimiento.field.fechaini"/>:</span>
					<html:text styleClass="text" property="fechaini" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				 		alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');">
					
					<span class="spanName" ><bean:message key="movimiento.field.fechafin"/>:</span>
					<html:text styleClass="text" property="fechafin" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   		alt="Obtener Fecha" onclick="return showCalendar('fechafin', 'y/mm/dd');"> 			
					
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				
				<%
					double totalValorPag=0; 
					double totalCantidadCaj=0; 	
					double totalCantidadUni=0; 	
					String strTotalValorPag="0"; 
					String strTotalCantidadCaj="0"; 	
					String strTotalCantidadUni="0"; 	
				%>
				<logic:notEmpty name="VENTASLISTPROD" scope="session">
					
						<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="venta.field.fecha" /></th>
								<th><bean:message key="venta.field.idusuario" /></th>
								<th><bean:message key="detventa.field.idproducto" /></th>
								<th><bean:message key="detventa.field.cantidad" /></th>
								<th><bean:message key="venta.field.valortotal" /></th>
								<th><bean:message key="producto.field.idlaboratorio" /></th>
							</tr>
							</thead>
							<tbody>
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
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="6" align="right">
			                    	La suma de los valores es: $<%= strTotalValorPag %> &nbsp; <br>
			                    </td>
							</tr>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="6" align="right">
			                    	La suma de las cantidades (CAJAS)es: <%= strTotalCantidadCaj %> &nbsp; <br>
			                    	La suma de las cantidades (UNIDADES)es: <%= strTotalCantidadUni %> &nbsp; <br>
			                    </td>
							</tr>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="VENTASLISTPROD" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				
				
				
			</section>
			
</html:form>