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
			<span class="spanName" ><bean:message key="movimiento.field.fechaini"/>:</span>
			<html:text styleClass="selText"    property="fechaini" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				 		alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');"> &nbsp;
					
			<span class="spanName" ><bean:message key="movimiento.field.fechafin"/>:</span>
			<html:text styleClass="selText"    property="fechafin" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   		alt="Obtener Fecha" onclick="return showCalendar('fechafin', 'y/mm/dd');"> &nbsp;			
					
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>
					
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
		</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="PREVENTAS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="cliente.title" /></th>
								<th><bean:message key="cliente.field.telefono" /></th>
								<th><bean:message key="cliente.field.direccion" /></th>
								<th><bean:message key="producto.title" /></th>
								<th><bean:message key="detventa.field.cantidad" /></th>
								<th><bean:message key="producto.field.presentacion" /></th>
								<th><bean:message key="detventa.field.valor" /></th>
								<th><bean:message key="detventa.field.valorunit" /></th>
								<!--  th>< bean :message key="producto.field.precioventa" /></th-->
								<th><bean:message key="inventario.field.fechaing" /></th>
								<th><bean:message key="detventa.field.dias" /></th>
								<th><bean:message key="producto.field.idlaboratorio" /></th>
							</tr>
							</thead>
							<tbody>
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
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="PREVENTAS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
							
		</section>
			
</html:form>