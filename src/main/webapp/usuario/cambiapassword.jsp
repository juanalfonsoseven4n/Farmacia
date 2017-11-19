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


<html:form target="_self" action="/Usuario.do?method=changePassword">
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
				key="usuario.title.changepass" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
			
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.descripcion" />	</td>
					<td width="5"></td>
					<td >
						<html:text styleClass="selText"  property="descripcion" readonly="true" maxlength="11"></html:text>
									</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.passwordold" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="passwordold" readonly="true" maxlength="10"></html:text>	
										</td>
				</tr>
						
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.password" /><span class="requerido">&nbsp;*  &nbsp;</span>	
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="password" maxlength="10"></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="usuario.field.passwordconf" /><span class="requerido">&nbsp;*  &nbsp;</span>	
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="passwordconf" maxlength="10"></html:text>
										</td>
				</tr>
				<tr >
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" >
					<html:submit styleClass="boton" property="Editar" >
						<bean:message key="label.global.editar" />
					</html:submit>
						
					</td>
				</tr>
				<logic:present name="mensaje" scope="request">
					<tr>			
						<td class="exito" colspan="3">
							<bean:message name="mensaje" scope="request"/>
						</td>
					</tr>
				</logic:present>
				<logic:messagesPresent>
					<tr>
						<td class="formulario" colspan="3">
						<logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
