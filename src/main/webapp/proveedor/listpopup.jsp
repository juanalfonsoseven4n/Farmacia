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
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/responsive.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/internas.css" rel="stylesheet" type="text/css">

<html:form target="_self" action="/Proveedor.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idproveedor
	, 	nombre
	, 	descripcion
	, 	codigo
	, 	telefono
	, 	direccion
	, 	representante
	, 	telefono2
	, 	mail
	, 	nit
		){

		eval("top.opener.document.getElementById('campoproveedor').value = \'"+idproveedor+"\'")
		eval("top.opener.document.getElementById('descproveedor').value = \'"+nombre+"\'")
		window.close();
	}   
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Proveedor.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="proveedor.title.list" /></span>
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
			<span class="spanName" >Nombre:</span>
			<html:text  property="nombre" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>
					<html:button styleClass="boton"	property="LimpiarBt" property="Buscar" onclick="limpiarNombre(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>
		</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="PROVEEDORS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th colspan="1"><bean:message key="label.global.acciones" /></th>
								<th><bean:message key="proveedor.field.idproveedor" /></th>
								<th><bean:message key="proveedor.field.nombre" /></th>
								<th><bean:message key="proveedor.field.descripcion" /></th>
								<th style="display: none;"><bean:message key="proveedor.field.codigo" /></th>
								<th><bean:message key="proveedor.field.telefono" /></th>
								<th style="display: none;"><bean:message key="proveedor.field.direccion" /></th>
								<th><bean:message key="proveedor.field.representante" /></th>
								<th style="display: none;"><bean:message key="proveedor.field.telefono2" /></th>
								<th style="display: none;"><bean:message key="proveedor.field.mail" /></th>
								<th><bean:message key="proveedor.field.nit" /></th>																								

							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="proveedor" name="PROVEEDORS"
								type="com.farmacia.domain.Proveedor">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="proveedor" property="idproveedor"	scope="page" />'
											,  										'<bean:write name="proveedor" property="nombre"	scope="page" />'
											,  										'<bean:write name="proveedor" property="descripcion"	scope="page" />'
											,  										'<bean:write name="proveedor" property="codigo"	scope="page" />'
											,  										'<bean:write name="proveedor" property="telefono"	scope="page" />'
											,  										'<bean:write name="proveedor" property="direccion"	scope="page" />'
											,  										'<bean:write name="proveedor" property="representante"	scope="page" />'
											,  										'<bean:write name="proveedor" property="telefono2"	scope="page" />'
											,  										'<bean:write name="proveedor" property="mail"	scope="page" />'
											,  										'<bean:write name="proveedor" property="nit"	scope="page" />'
											 										);" />
										</td>
																				<td><bean:write name="proveedor" property="idproveedor"	scope="page" /></td>
																				<td><bean:write name="proveedor" property="nombre"	scope="page" /></td>
																				<td><bean:write name="proveedor" property="descripcion"	scope="page" /></td>
																				<td style="display: none;"><bean:write name="proveedor" property="codigo"	scope="page" /></td>
																				<td><bean:write name="proveedor" property="telefono"	scope="page" /></td>
																				<td style="display: none;"><bean:write name="proveedor" property="direccion"	scope="page" /></td>
																				<td><bean:write name="proveedor" property="representante"	scope="page" /></td>
																				<td style="display: none;"><bean:write name="proveedor" property="telefono2"	scope="page" /></td>
																				<td style="display: none;"><bean:write name="proveedor" property="mail"	scope="page" /></td>
																				<td><bean:write name="proveedor" property="nit"	scope="page" /></td>
																		
									

									

								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="PROVEEDORS" scope="session">
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="3"><bean:message key="label.global.noregisters" /></td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</logic:empty>
			
	</section>
			
</html:form>