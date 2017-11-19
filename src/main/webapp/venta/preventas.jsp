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


<html:form target="_self" action="/Venta.do?method=preventas">
<script type="text/javascript">
	function limpiarFiltro(forma){
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
			
				<logic:notEmpty name="PREVENTAS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td><bean:message key="cliente.title" /></td>
								<td><bean:message key="cliente.field.telefono" /></td>
								<td><bean:message key="cliente.field.direccion" /></td>
								<td><bean:message key="producto.title" /></td>
								<td><bean:message key="detventa.field.cantidad" /></td>
								<td><bean:message key="producto.field.presentacion" /></td>
								<td><bean:message key="detventa.field.valor" /></td>
								<td><bean:message key="detventa.field.valorunit" /></td>
								<!--  td>< bean :message key="producto.field.precioventa" /></td-->
								<td><bean:message key="inventario.field.fechaing" /></td>
								<td><bean:message key="detventa.field.dias" /></td>
								<td><bean:message key="producto.field.idlaboratorio" /></td>
							</tr>

							<logic:iterate indexId="ind" id="ventaProd" name="PREVENTAS"
								type="com.farmacia.domain.Preventa">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">

								
									<td align="center"><bean:write name="ventaProd" property="nombre" scope="page" /> <bean:write name="ventaProd" property="apellido" scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="telefono" scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="direccion" scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="nombreProducto" scope="page" /></td>
									<td align="right"><bean:write name="ventaProd" property="cantidad"	scope="page"/></td>
									<td align="center"><bean:write name="ventaProd" property="presentacion"	scope="page"/></td>														
									<td align="right">$<bean:write name="ventaProd" property="valor" scope="page"  format="#,##0.00"/></td>
									<td align="right">$<bean:write name="ventaProd" property="valorunit" scope="page"  format="#,##0.00"/></td>
									<!-- td align="right">$< bean :write name="ventaProd" property="precioventa" scope="page"  format="#,##0.00"/></td -->
									<td align="center"><bean:write name="ventaProd" property="fechaVentaFormated"	scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="fechaProxVentaFormated"	scope="page" /></td>
									<td align="center"><bean:write name="ventaProd" property="nombreLaboratorio" scope="page" /></td>
									
								</tr>
							</logic:iterate>
							
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="PREVENTAS" scope="session">
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
			
				
			</table>
			</td>
			</tr>
			</table>
			
</html:form>