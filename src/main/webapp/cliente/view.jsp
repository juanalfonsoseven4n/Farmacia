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


<html:form target="_self" action="/Cliente.do?method=list">

	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="cliente.title.detail" /></td>
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
                    <td class="formulario"><bean:message key="cliente.field.idcliente" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idcliente" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:hidden property="nombre" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.apellido" /></td>
					<td width="5"></td>
					<td ><html:hidden property="apellido" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.direccion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="direccion" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.telefono" /></td>
					<td width="5"></td>
					<td ><html:hidden property="telefono" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.mail" /></td>
					<td width="5"></td>
					<td ><html:hidden property="mail" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.cedula" /></td>
					<td width="5"></td>
					<td ><html:hidden property="cedula" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.observacion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="observacion" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.idclasificacion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="clasdesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.idclasificacion2" /></td>
					<td width="5"></td>
					<td ><html:hidden property="clasdesc2" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.idclasificacion3" /></td>
					<td width="5"></td>
					<td ><html:hidden property="clasdesc3" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.sexo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="sexo" write="true"></html:hidden></td>
				</tr>			
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.fechanac" /></td>
					<td width="5"></td>
					<td ><html:hidden property="fechanac" write="true"></html:hidden></td>
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
