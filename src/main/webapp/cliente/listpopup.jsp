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


<html:form target="_self" action="/Cliente.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idcliente
	, 	nombre
	, 	apellido
	, 	direccion
	, 	telefono
	, 	mail
	, 	cedula
		){

		eval("top.opener.document.getElementById('campocliente').value = \'"+idcliente+"\'")
		eval("top.opener.document.getElementById('desccliente').value = \'"+nombre+"\'")
		window.close();
	}   
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Cliente.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=100% align="center">
		<tr >
			<td align="center" class="titulos" ><bean:message
				key="cliente.title.list" /></td>
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


					<td align="center" colspan=3">Nombre: &nbsp;
					<html:text  property="nombre" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarNombre(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>

				</tr>

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">


					<td align="right" colspan=3"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></td>

				</tr>
				
				<logic:notEmpty name="CLIENTES" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="3" width="100%" align="center">
							<tr class="titulos">
								<td colspan="1"><bean:message key="label.global.acciones" /></td>
								<td  style="display: none;"><bean:message key="cliente.field.idcliente" /></td>
								<td><bean:message key="cliente.field.nombre" /></td>
								<td><bean:message key="cliente.field.apellido" /></td>
								<td  style="display: none;"><bean:message key="cliente.field.direccion" /></td>
								<td><bean:message key="cliente.field.telefono" /></td>
								<td><bean:message key="cliente.field.mail" /></td>
								<td><bean:message key="cliente.field.cedula" /></td>
								<td><bean:message key="cliente.field.idclasificacion" /></td>
																								

							</tr>

							<logic:iterate indexId="ind" id="cliente" name="CLIENTES"
								type="com.farmacia.domain.Cliente">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
									'<bean:write name="cliente" property="idcliente"	scope="page" />'
									,  		'<bean:write name="cliente" property="nombre"	scope="page" />'
									,  		'<bean:write name="cliente" property="apellido"	scope="page" />'
									,   	'<bean:write name="cliente" property="direccion"	scope="page" />'
									,  		'<bean:write name="cliente" property="telefono"	scope="page" />'
									,  		'<bean:write name="cliente" property="mail"	scope="page" />'
									,  		'<bean:write name="cliente" property="cedula"	scope="page" />'
											 										);" />
									</td>
									<td  style="display: none;"><bean:write name="cliente" property="idcliente"	scope="page" /></td>
									<td><bean:write name="cliente" property="nombre"	scope="page" /></td>
									<td><bean:write name="cliente" property="apellido"	scope="page" /></td>
									<td style="display: none;"><bean:write name="cliente" property="direccion"	scope="page" /></td>
									<td><bean:write name="cliente" property="telefono"	scope="page" /></td>
									<td><bean:write name="cliente" property="mail"	scope="page" /></td>
									<td><bean:write name="cliente" property="cedula"	scope="page" /></td>
									<td><bean:write name="cliente" property="clasdesc"	scope="page" /></td>
								</tr>
							</logic:iterate>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="CLIENTES" scope="session">
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