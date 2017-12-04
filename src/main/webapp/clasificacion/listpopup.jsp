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

<html:form target="_self" action="/Clasificacion.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idclasificacion
	, 	nombre
	, 	descripcion
		){

		eval("top.opener.document.getElementById('campoclasificacion').value = \'"+idclasificacion+"\'")
		eval("top.opener.document.getElementById('descclasificacion').value = \'"+nombre+"\'")
		window.close();
	}   
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Clasificacion.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="clasificacion.title.list" /></span>
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
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarNombre(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
		</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="LABORATORIOS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th colspan="1"><bean:message key="label.global.acciones" /></th>
								<th><bean:message key="clasificacion.field.idclasificacion" /></th>
								<th><bean:message key="clasificacion.field.nombre" /></th>
								<th><bean:message key="clasificacion.field.descripcion" /></th>																								

							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="clasificacion" name="LABORATORIOS"
								type="com.farmacia.domain.Clasificacion">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="clasificacion" property="idclasificacion"	scope="page" />'
											,  										'<bean:write name="clasificacion" property="nombre"	scope="page" />'
											,  										'<bean:write name="clasificacion" property="descripcion"	scope="page" />'
											 										);" />
										</td>
																				<td><bean:write name="clasificacion" property="idclasificacion"	scope="page" /></td>
																				<td><bean:write name="clasificacion" property="nombre"	scope="page" /></td>
																				<td><bean:write name="clasificacion" property="descripcion"	scope="page" /></td>
																		
									

									

								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="LABORATORIOS" scope="session">
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="3"><bean:message key="label.global.noregisters" /></td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</logic:empty>
			
			
	</section>			
</html:form>