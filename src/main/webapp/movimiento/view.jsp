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


<html:form target="_self" action="/Movimiento.do?method=list">

	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="movimiento.title.detail" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				<logic:messagesPresent>
					<tr>
						<td colspan=3" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

							
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.fecha" /></td>
					<td width="5"></td>
					<td ><html:hidden property="fecha" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.fechaexp" /></td>
					<td width="5"></td>
					<td ><html:hidden property="fechaexp" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.idproducto" /></td>
					<td width="5"></td>
					<td ><html:hidden property="proddesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="movimiento.field.valor" /></td>
					<td width="5"></td>
					<td ><html:hidden property="valor" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.tipo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="tipo"></html:hidden>
					<logic:equal value="1" name="movimientoForm" property="tipo">ENTRADA</logic:equal>
					<logic:equal value="2" name="movimientoForm" property="tipo">SALIDA</logic:equal>
					<logic:equal value="3" name="movimientoForm" property="tipo">VENTA</logic:equal>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.cantidad" /></td>
					<td width="5"></td>
					<td ><html:hidden property="cantidad" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.preciocosto" /></td>
					<td width="5"></td>
					<td >$ <html:hidden property="preciocosto" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.precio" /></td>
					<td width="5"></td>
					<td >$ <html:hidden property="precio" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="movimiento.field.idmovimiento" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idmovimiento" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="farmdesc" write="true"></html:hidden></td>
				</tr>
								
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.hora" /></td>
					<td width="5"></td>
					<td ><html:hidden property="horas" write="true"></html:hidden>:<html:hidden property="minutos" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.idusuario" /></td>
					<td width="5"></td>
					<td ><html:hidden property="usudesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.codigo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="codigo" write="true"></html:hidden></td>
				</tr>				
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.lote" /></td>
					<td width="5"></td>
					<td ><html:hidden property="lote" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.codigofac" /></td>
					<td width="5"></td>
					<td ><html:hidden property="codigofac" write="true"></html:hidden></td>
				</tr>	
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Regresar" >
						<bean:message key="label.global.regresar" />
					</html:submit></td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
