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
<script type="text/javascript">
	function enviar(forma, valor, idTabla)
	{
			forma.idTabla.value=idTabla;
			cambioAction(forma, valor);
	}
	function cambioAction(forma, valor)
	{
			forma.action=valor;
			forma.submit();
	}
	function limpiarFiltro(forma){
		document.getElementsByName('nombre')[0].value=''
		document.getElementsByName('idclasificacion')[0].value='0'
		forma.submit();
	}
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Cliente.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="cliente.title.list" /></span>
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
					<html:text styleClass="text" property="nombre" maxlength="50" onkeyup="this.v	alue=this.value.toUpperCase()"></html:text> &nbsp;&nbsp;
					<span class="spanName" ><bean:message key="cliente.field.idclasificacion" />:</span>
					<html:select property="idclasificacion" >
						<html:option value="0">Seleccione</html:option>
						<html:options collection="clasLista" labelProperty="nombre" property="idclasificacion" />
					</html:select>&nbsp;&nbsp;
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
				
				<logic:notEmpty name="CLIENTES" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th style="display: none;"><bean:message key="cliente.field.idcliente" /></th>
								<th><bean:message key="cliente.field.nombre" /></th>
								<th><bean:message key="cliente.field.apellido" /></th>
								<th><bean:message key="cliente.field.direccion" /></th>
								<th><bean:message key="cliente.field.telefono" /></th>
								<th style="display: none;"><bean:message key="cliente.field.mail" /></th>
								<th><bean:message key="cliente.field.cedula" /></th>
								<th><bean:message key="cliente.field.sexo" /></th>
								<th><bean:message key="cliente.field.edad" /></th>
								
								<th><bean:message key="cliente.field.idclasificacion" /></th>
								<th><bean:message key="cliente.field.idclasificacion2" /></th>
								<th><bean:message key="cliente.field.idclasificacion3" /></th>
								<th	><bean:message key="label.global.acciones" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="cliente" name="CLIENTES"
								type="com.farmacia.domain.Cliente">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td style="display: none;"><bean:write name="cliente" property="idcliente"	scope="page" /></td>
									<td><bean:write name="cliente" property="nombre"	scope="page" /></td>
									<td><bean:write name="cliente" property="apellido"	scope="page" /></td>
									<td><bean:write name="cliente" property="direccion"	scope="page" /></td>
									<td><bean:write name="cliente" property="telefono"	scope="page" /></td>
									<td style="display: none;"><bean:write name="cliente" property="mail"	scope="page" /></td>
									<td><bean:write name="cliente" property="cedula"	scope="page" /></td>
									<td><bean:write name="cliente" property="sexo"	scope="page" /></td>
									<td><bean:write name="cliente" property="edad"	scope="page" /></td>
									<td><bean:write name="cliente" property="clasdesc"	scope="page" /></td>
									<td><bean:write name="cliente" property="clasdesc2"	scope="page" /></td>
									<td><bean:write name="cliente" property="clasdesc3"	scope="page" /></td>

									<td nowrap="nowrap" align="center">
									<%
											java.util.HashMap map = new java.util.HashMap();
																				map.put("idcliente", String.valueOf(cliente.getIdcliente()));
																				pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Cliente.do?method=detail" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											<html:link href="/Farmacia/Cliente.do?method=edit" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/editar.gif"
													width="14" height="14" titleKey="label.global.editar" />
											</html:link>&nbsp;&nbsp;
											
											<html:link href="/Farmacia/Cliente.do?method=delete" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/eliminar.gif"
													width="14" height="14" titleKey="label.global.eliminar" />
											</html:link>&nbsp;&nbsp;
											
										</td>

								</tr>
							</logic:iterate>
						</tbody>
						</table>
						</div>

				</logic:notEmpty>


				<logic:empty name="CLIENTES" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<div class="row">
					<div class="contBtnFo">
						<input type="button" class="boton"
						name="agregar" onclick="cambioAction(this.form, '<%=request.getContextPath()%>/Cliente.do?method=add')"
						value="<bean:message key="label.global.agregar" />">
					</div>
				</div>
	</section>			
</html:form>