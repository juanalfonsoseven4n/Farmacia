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


<html:form target="_self" action="/Venta.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idventa
	, 	fecha
	, 	idusuario
	, 	idmedico
	, 	valortotal
	, 	iva
	, 	idcliente
	, 	idfarmacia
	, 	codigo
	, 	valor
	, 	hora
		){

		eval("top.opener.document.getElementById('campoventa').value = \'"+idventa+"\'")
		eval("top.opener.document.getElementById('descventa').value = \'"+codigo+"\'")
		window.close();
	}   
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Venta.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="venta.title.list" /></td>
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
				
				<logic:notEmpty name="VENTAS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td colspan="1"><bean:message key="label.global.acciones" /></td>
																	<td><bean:message key="venta.field.idventa" /></td>
																	<td><bean:message key="venta.field.fecha" /></td>
																	<td><bean:message key="venta.field.idusuario" /></td>
																	<td><bean:message key="venta.field.idmedico" /></td>
																	<td><bean:message key="venta.field.valortotal" /></td>
																	<td><bean:message key="venta.field.iva" /></td>
																	<td><bean:message key="venta.field.idcliente" /></td>
																	<td><bean:message key="venta.field.idfarmacia" /></td>
																	<td><bean:message key="venta.field.codigo" /></td>
																	<td><bean:message key="venta.field.valor" /></td>
																	<td><bean:message key="venta.field.hora" /></td>
																								

							</tr>

							<logic:iterate indexId="ind" id="venta" name="VENTAS"
								type="com.farmacia.domain.Venta">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer(
																				'<bean:write name="venta" property="idventa"	scope="page" />'
											,  										'<bean:write name="venta" property="fecha"	scope="page" />'
											,  										'<bean:write name="venta" property="idusuario"	scope="page" />'
											,  										'<bean:write name="venta" property="idmedico"	scope="page" />'
											,  										'<bean:write name="venta" property="valortotal"	scope="page" />'
											,  										'<bean:write name="venta" property="iva"	scope="page" />'
											,  										'<bean:write name="venta" property="idcliente"	scope="page" />'
											,  										'<bean:write name="venta" property="idfarmacia"	scope="page" />'
											,  										'<bean:write name="venta" property="codigo"	scope="page" />'
											,  										'<bean:write name="venta" property="valor"	scope="page" />'
											,  										'<bean:write name="venta" property="hora"	scope="page" />'
											 										);" />
										</td>
																				<td><bean:write name="venta" property="idventa"	scope="page" /></td>
																				<td><bean:write name="venta" property="fecha"	scope="page" /></td>
																				<td><bean:write name="venta" property="idusuario"	scope="page" /></td>
																				<td><bean:write name="venta" property="idmedico"	scope="page" /></td>
																				<td><bean:write name="venta" property="valortotal"	scope="page" /></td>
																				<td><bean:write name="venta" property="iva"	scope="page" /></td>
																				<td><bean:write name="venta" property="idcliente"	scope="page" /></td>
																				<td><bean:write name="venta" property="idfarmacia"	scope="page" /></td>
																				<td><bean:write name="venta" property="codigo"	scope="page" /></td>
																				<td><bean:write name="venta" property="valor"	scope="page" /></td>
																				<td><bean:write name="venta" property="hora"	scope="page" /></td>
																		
									

									

								</tr>
							</logic:iterate>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="VENTAS" scope="session">
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