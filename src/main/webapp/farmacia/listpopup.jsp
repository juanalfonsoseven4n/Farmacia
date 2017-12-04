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

<html:form target="_self" action="/Farmacia.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idfarmacia
	, 	nombre
	, 	descripcion
	, 	representante
	, 	telefono
	, 	direccion
	, 	telefono2
	, 	mail
	, 	nit
		){

		eval("top.opener.document.getElementById('campofarmacia').value = \'"+idfarmacia+"\'")
		eval("top.opener.document.getElementById('descfarmacia').value = \'"+nombre+"\'")
		window.close();
	}   
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Farmacia.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />

	<div class="tit">
			<span><bean:message
				key="farmacia.title.list" /></span>
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
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="FARMACIAS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th colspan="1"><bean:message key="label.global.acciones" /></th>
								<th><bean:message key="farmacia.field.idfarmacia" /></th>
								<th><bean:message key="farmacia.field.nombre" /></th>
								<th><bean:message key="farmacia.field.descripcion" /></th>
								<th><bean:message key="farmacia.field.representante" /></th>
								<th><bean:message key="farmacia.field.telefono" /></th>
								<th><bean:message key="farmacia.field.direccion" /></th>
								<th><bean:message key="farmacia.field.telefono2" /></th>
								<th><bean:message key="farmacia.field.mail" /></th>
								<th><bean:message key="farmacia.field.nit" /></th>																								

							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="farmacia" name="FARMACIAS"
								type="com.farmacia.domain.Farmacia">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="farmacia" property="idfarmacia"	scope="page" />'
											,  										'<bean:write name="farmacia" property="nombre"	scope="page" />'
											,  										'<bean:write name="farmacia" property="descripcion"	scope="page" />'
											,  										'<bean:write name="farmacia" property="representante"	scope="page" />'
											,  										'<bean:write name="farmacia" property="telefono"	scope="page" />'
											,  										'<bean:write name="farmacia" property="direccion"	scope="page" />'
											,  										'<bean:write name="farmacia" property="telefono2"	scope="page" />'
											,  										'<bean:write name="farmacia" property="mail"	scope="page" />'
											,  										'<bean:write name="farmacia" property="nit"	scope="page" />'
											 										);" />
										</td>
																				<td><bean:write name="farmacia" property="idfarmacia"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="nombre"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="descripcion"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="representante"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="telefono"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="direccion"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="telefono2"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="mail"	scope="page" /></td>
																				<td><bean:write name="farmacia" property="nit"	scope="page" /></td>
																		
									

									

								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="FARMACIAS" scope="session">
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="3"><bean:message key="label.global.noregisters" /></td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</logic:empty>
						
	</section>			
</html:form>