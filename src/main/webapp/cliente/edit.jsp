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


<html:form target="_self" action="/Cliente.do?method=saveEdit">
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
				key="cliente.title.edit" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				<logic:messagesPresent>
					<tr>
						<td colspan=3" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" /><br>
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.idcliente" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="idcliente"
 readonly="true" maxlength="11"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="nombre"
 maxlength="30"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.apellido" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="apellido"
 maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.direccion" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="direccion"
 maxlength="40"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.telefono" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="telefono"
 maxlength="50"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.mail" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="mail"
 maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.cedula" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="cedula"
 maxlength="16"></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="cliente.field.observacion" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="observacion" maxlength="255" size="70"></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="cliente.field.idclasificacion" /></td>
					<td width="5"></td>
					<td><html:select property="idclasificacion" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="clasLista" labelProperty="nombre" property="idclasificacion" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="cliente.field.idclasificacion2" /></td>
					<td width="5"></td>
					<td><html:select property="idclasificacion2" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="clasLista" labelProperty="nombre" property="idclasificacion" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="cliente.field.idclasificacion3" /></td>
					<td width="5"></td>
					<td><html:select property="idclasificacion3" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="clasLista" labelProperty="nombre" property="idclasificacion" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="cliente.field.sexo" /></td>
					<td width="5"></td>
					<td><html:select property="sexo" styleClass="sel">
						<html:option value="FEMENINO">FEMENINO</html:option>
						<html:option value="MASCULINO">MASCULINO</html:option>
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="cliente.field.fechanac" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText"    property="fechanac" size="10" maxlength="10" onfocus="this.select()" 
					   onblur="this.value=this.value.toUpperCase()" />&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechanac', 'y/mm/dd');">
				    <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
								<tr>
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Editar" >
						<bean:message key="label.global.editar" />
					</html:submit>
						<input type="button" class="boton"
						id="Regresar" onclick="cambioAction(this.form,'<%=request.getContextPath()%>/Cliente.do?method=list');" 
						value="<bean:message key="label.global.regresar" />"	>
					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
