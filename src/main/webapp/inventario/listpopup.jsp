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

<html:form target="_self" action="/Inventario.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idinventario
	, 	idproducto
	, 	cantidad
	, 	fechaexpir
	, 	fechaing
	, 	codigo
	, 	preciocosto
	, 	idfarmacia
		){

		eval("top.opener.document.getElementById('campoinventario').value = \'"+idinventario+"\'")
		eval("top.opener.document.getElementById('descinventario').value = \'"+codigo+"\'")
		window.close();
	}   
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Inventario.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="inventario.title.list" /></span>
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
						
				<logic:notEmpty name="INVENTARIOS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th colspan="1"><bean:message key="label.global.acciones" /></th>
								<th><bean:message key="inventario.field.idinventario" /></th>
								<th style="display: none;"><bean:message key="inventario.field.idproducto" /></th>
								<th><bean:message key="inventario.field.cantidad" /></th>
								<th><bean:message key="inventario.field.fechaexpir" /></th>
								<th><bean:message key="inventario.field.fechaing" /></th>
								<th><bean:message key="inventario.field.codigo" /></th>
								<th><bean:message key="inventario.field.preciocosto" /></th>
								<th><bean:message key="inventario.field.idfarmacia" /></th>																								

							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="inventario" name="INVENTARIOS"
								type="com.farmacia.domain.Inventario">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="inventario" property="idinventario"	scope="page" />'
											,  										'<bean:write name="inventario" property="idproducto"	scope="page" />'
											,  										'<bean:write name="inventario" property="cantidad"	scope="page" />'
											,  										'<bean:write name="inventario" property="fechaexpir"	scope="page" />'
											,  										'<bean:write name="inventario" property="fechaing"	scope="page" />'
											,  										'<bean:write name="inventario" property="codigo"	scope="page" />'
											,  										'<bean:write name="inventario" property="preciocosto"	scope="page" />'
											,  										'<bean:write name="inventario" property="idfarmacia"	scope="page" />'
											 										);" />
										</td>
																				<td><bean:write name="inventario" property="idinventario"	scope="page" /></td>
																				<td style="display: none;"><bean:write name="inventario" property="idproducto"	scope="page" /></td>
																				<td><bean:write name="inventario" property="cantidad"	scope="page" /></td>
																				<td><bean:write name="inventario" property="fechaexpir"	scope="page" /></td>
																				<td><bean:write name="inventario" property="fechaing"	scope="page" /></td>
																				<td><bean:write name="inventario" property="codigo"	scope="page" /></td>
																				<td><bean:write name="inventario" property="preciocosto"	scope="page" /></td>
																				<td><bean:write name="inventario" property="idfarmacia"	scope="page" /></td>
																		
									

									

								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="INVENTARIOS" scope="session">
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="3"><bean:message key="label.global.noregisters" /></td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</logic:empty>
			</section>
			
</html:form>