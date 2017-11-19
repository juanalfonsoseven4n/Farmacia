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


<html:form target="_self" action="/Usuario.do?method=saveAdd">
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="usuario.title.add" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				
						
								
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="nombre"
 maxlength="30"></html:text>	<span class="requerido">&nbsp;*  &nbsp;</span>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.apellido" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="apellido"
 maxlength="30"></html:text><span class="requerido">&nbsp;*  &nbsp;</span>	
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.direccion" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="direccion"
 maxlength="40"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.mail" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="mail"
 maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.cedula" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="cedula"
 maxlength="16"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.telefono2" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="telefono2"
 maxlength="11"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.telefono" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="telefono"
 maxlength="11"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.especializacion" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="especializacion"
 maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.descripcion" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="descripcion"
 maxlength="50"></html:text><span class="requerido">&nbsp;*  &nbsp;</span>
										</td>
				</tr>
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.password" />	
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="password" maxlength="10"></html:text>
										<span class="requerido">&nbsp;*  &nbsp;</span></td>
				</tr>
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.idperfil" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:select property="idperfil" styleClass="sel">
							<html:option value="0">Seleccione</html:option>
							<html:options  collection="perfLista" labelProperty="nombre" property="idperfil" />
						</html:select>
										<span class="requerido">&nbsp;*  &nbsp;</span>	</td>
				</tr>
									<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.idfarmacia" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:select property="idfarmacia" styleClass="sel">
							<html:option value="0">Seleccione</html:option>
							<html:options  collection="farmLista" labelProperty="nombre" property="idfarmacia" />
						</html:select>
										<span class="requerido">&nbsp;*  &nbsp;</span>	</td>
				</tr>	
										
				
							<tr >
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Agregar" >
						<bean:message key="label.global.agregar" />
					</html:submit></td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>