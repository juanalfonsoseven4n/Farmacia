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


<html:form target="_self" action="/Proveedor.do?method=saveDelete">
<script type="text/javascript">
	
	function cambioAction(forma, valor)
	{
			forma.action=valor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="proveedor.title.delete" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
				
				<logic:messagesPresent>
					<tr align="center">
						<td colspan=3" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.idproveedor" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idproveedor" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:hidden property="nombre" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.descripcion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="descripcion" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.codigo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="codigo" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.telefono" /></td>
					<td width="5"></td>
					<td ><html:hidden property="telefono" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.direccion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="direccion" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.representante" /></td>
					<td width="5"></td>
					<td ><html:hidden property="representante" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.telefono2" /></td>
					<td width="5"></td>
					<td ><html:hidden property="telefono2" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.mail" /></td>
					<td width="5"></td>
					<td ><html:hidden property="mail" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="proveedor.field.nit" /></td>
					<td width="5"></td>
					<td ><html:hidden property="nit" write="true"></html:hidden></td>
				</tr>
				
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Eliminar" >
						<bean:message key="label.global.eliminar" />
					</html:submit>
					<input type="button" class="boton"
						id="Regresar" onclick="cambioAction(this.form,'<%=request.getContextPath()%>/Proveedor.do?method=list');" 
						value="<bean:message key="label.global.regresar" />"	>

					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
