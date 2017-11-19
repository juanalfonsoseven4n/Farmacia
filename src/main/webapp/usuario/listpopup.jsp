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


<html:form target="_self" action="/Usuario.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idusuario
	, 	nombre
	, 	apellido
	, 	direccion
	, 	mail
	, 	cedula
	, 	telefono2
	, 	telefono
	, 	especializacion
	, 	descripcion
		){

		eval("top.opener.document.getElementById('campousuario').value = \'"+idusuario+"\'")
		eval("top.opener.document.getElementById('descusuario').value = \'"+nombre+"\'")
		window.close();
	}   
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Usuario.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=100% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="usuario.title.list" /></td>
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


					<td align="right" colspan=3"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></td>

				</tr>
				
				<logic:notEmpty name="USUARIOS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="3" width="100%" align="center">
							<tr class="titulos">
								<td colspan="1"><bean:message key="label.global.acciones" /></td>
								<td><bean:message key="usuario.field.nombre" /></td>
								<td><bean:message key="usuario.field.apellido" /></td>
								<td><bean:message key="usuario.field.idusuario" /></td>
								<td style="display: none;"><bean:message key="usuario.field.direccion" /></td>
								<td><bean:message key="usuario.field.telefono" /></td>
								<td style="display: none;"><bean:message key="usuario.field.especializacion" /></td>
								<td style="display: none;"><bean:message key="usuario.field.descripcion" /></td>
						
							</tr>

							<logic:iterate indexId="ind" id="usuario" name="USUARIOS"
								type="com.farmacia.domain.Usuario">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="usuario" property="idusuario"	scope="page" />'
											,  										'<bean:write name="usuario" property="nombre"	scope="page" />'
											,  										'<bean:write name="usuario" property="apellido"	scope="page" />'
											,  										'<bean:write name="usuario" property="direccion"	scope="page" />'
											,  										'<bean:write name="usuario" property="mail"	scope="page" />'
											,  										'<bean:write name="usuario" property="cedula"	scope="page" />'
											,  										'<bean:write name="usuario" property="telefono2"	scope="page" />'
											,  										'<bean:write name="usuario" property="telefono"	scope="page" />'
											,  										'<bean:write name="usuario" property="especializacion"	scope="page" />'
											,  										'<bean:write name="usuario" property="descripcion"	scope="page" />'
											 										);" />
									</td>
									<td><bean:write name="usuario" property="nombre"	scope="page" /></td>
									<td><bean:write name="usuario" property="apellido"	scope="page" /></td>
									<td><bean:write name="usuario" property="idusuario"	scope="page" /></td>
									<td style="display: none;"><bean:write name="usuario" property="direccion"	scope="page" /></td>
									<td><bean:write name="usuario" property="telefono"	scope="page" /></td>
									<td style="display: none;"><bean:write name="usuario" property="especializacion"	scope="page" /></td>
									<td style="display: none;"><bean:write name="usuario" property="descripcion"	scope="page" /></td>
								
								</tr>
							</logic:iterate>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="USUARIOS" scope="session">
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="3"><bean:message key="label.global.noregisters" /></td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</logic:empty>
			
			</table>
			</td>
			</tr>
			</table>
			
</html:form>