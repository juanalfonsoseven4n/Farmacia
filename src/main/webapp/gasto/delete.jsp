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


<html:form target="_self" action="/Gasto.do?method=saveDelete">
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
				key="gasto.title.delete" /></td>
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
                    <td class="formulario"><bean:message key="gasto.field.idgasto" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idgasto" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.descripcion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="descripcion" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:hidden property="nombre" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.fecha" /></td>
					<td width="5"></td>
					<td ><html:hidden property="fecha" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.valor" /></td>
					<td width="5"></td>
					<td ><html:hidden property="valor" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.idusuario" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idusuario" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" align="center">
                    <td class="formulario"><bean:message key="gasto.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" write="true"></html:hidden></td>
				</tr>
				
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Eliminar" >
						<bean:message key="label.global.eliminar" />
					</html:submit>
					<input type="button" class="boton"
						id="Regresar" onclick="cambioAction(this.form,'<%=request.getContextPath()%>/Gasto.do?method=list');" 
						value="<bean:message key="label.global.regresar" />"	>

					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
