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

<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">


<html:form target="_self" action="/Venta.do?method=listVentas">
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
		document.getElementsByName('usuario')[0].value=''
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
			<span class="spanName" >Nombre del <bean:message key="venta.field.idusuario"/>:</span>
					<html:text styleClass="text" property="usuario" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
					<span class="spanName" ><bean:message key="producto.title" />:</span>
					<html:text styleClass="text" property="descproducto" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
					<span class="spanName" ><bean:message key="movimiento.field.fechaini"/>:</span>
					<html:text styleClass="text" property="fechaini" size="10" maxlength="10" onfocus="this.select()"
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');"> &nbsp;
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
						
				
				<%double totalpag=0; %>
				<logic:notEmpty name="VENTASLIST" scope="session">
					
						<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="venta.field.fecha" /></th>
								<th><bean:message key="venta.field.hora" /></th>
								<th><bean:message key="venta.field.idusuario" /></th>
								<th><bean:message key="venta.field.idmedico" /></th>
								<th><bean:message key="venta.field.valortotal" /></th>
								<th><bean:message key="venta.field.iva" /></th>
								<th><bean:message key="venta.field.idcliente" /></th>
								<th style="display: none;"><bean:message key="venta.field.codigo" /></th>
								<th><bean:message key="label.global.acciones" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="venta" name="VENTASLIST"
								type="com.farmacia.domain.Venta">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td align="center"><bean:write name="venta" property="fechaFormated"	scope="page" /></td>
									<td align="center"><bean:write name="venta" property="horaFormated"	scope="page" /></td>
									<td align="center"><bean:write name="venta" property="vendedor.descripcion" scope="page" /></td>
									<td align="center"><bean:write name="venta" property="medico.descripcion" scope="page" /></td>
									<td align="right">$<bean:write name="venta" property="valortotal"	scope="page"  format="#,##0.00"/></td>
									<td align="right">$<bean:write name="venta" property="iva"	scope="page"  format="#,##0.00"/></td>
									<td align="center">
										<bean:write name="venta" property="cliente.nombre" scope="page" />&nbsp;
										<bean:write name="venta" property="cliente.apellido" scope="page" />
									</td>
									<td style="display: none;"><bean:write name="venta" property="codigo"	scope="page" /></td>
																	
								
									<td align="center" width="2%">
									<%
											totalpag=totalpag+venta.getValortotal().doubleValue();		
											java.util.HashMap map = new java.util.HashMap();
											map.put("idventa", String.valueOf(venta.getIdventa()));
											pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Venta.do?method=detailVenta" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											</td>
										

								</tr>
							</logic:iterate>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="venta.comision" /> (10%) : $<%= totalpag*10/100 %> &nbsp; <br>
			                    </td>
							</tr>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="venta.field.totalVentasPagina" /> : $<%= totalpag %> &nbsp; <br>
			                    </td>
							</tr>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="VENTASLIST" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				
				
				
			</section>
			
</html:form>