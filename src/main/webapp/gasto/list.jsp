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


<html:form target="_self" action="/Gasto.do?method=list">
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
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Gasto.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="gasto.title.list" /></td>
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
					<html:text  property="userdesc" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
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
				
				<logic:notEmpty name="GASTOS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
																	<td style="display: none;"><bean:message key="gasto.field.idgasto" /></td>
																	<td style="display: none;"><bean:message key="gasto.field.descripcion" /></td>
																	<td><bean:message key="gasto.field.nombre" /></td>
																	<td><bean:message key="gasto.field.fecha" /></td>
																	<td><bean:message key="gasto.field.valor" /></td>
																	<td><bean:message key="gasto.field.idusuario" /></td>
																	<td><bean:message key="gasto.field.idfarmacia" /></td>
																
								<td colspan="3"><bean:message key="label.global.acciones" /></td>
							</tr>

							<logic:iterate indexId="ind" id="gasto" name="GASTOS"
								type="com.farmacia.domain.Gasto">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
																	<td style="display: none;"><bean:write name="gasto" property="idgasto"	scope="page" /></td>
																	<td style="display: none;"><bean:write name="gasto" property="descripcion"	scope="page" /></td>
																	<td><bean:write name="gasto" property="nombre"	scope="page" /></td>
																	<td><bean:write name="gasto" property="fecha"	scope="page" /></td>
																	<td>$<bean:write name="gasto" property="valor"	scope="page" format="#,##0.00"/></td>
																	<td><bean:write name="gasto" property="userdesc"	scope="page" /></td>
																	<td><bean:write name="gasto" property="farmdesc"	scope="page" /></td>
								
									<td width="2%">
									<%
											java.util.HashMap map = new java.util.HashMap();
																				map.put("idgasto", String.valueOf(gasto.getIdgasto()));
																				pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Gasto.do?method=detail" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											</td>
										<td width="2%">
											<html:link href="/Farmacia/Gasto.do?method=edit" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/editar.gif"
													width="14" height="14" titleKey="label.global.editar" />
											</html:link>&nbsp;&nbsp;
											
										</td>
										<td width="2%">
											<html:link href="/Farmacia/Gasto.do?method=delete" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/eliminar.gif"
													width="14" height="14" titleKey="label.global.eliminar" />
											</html:link>&nbsp;&nbsp;
											
										</td>

								</tr>
							</logic:iterate>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="GASTOS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<tr  align="center" class="titulos">
					<td colspan="3" ><input type="button" class="boton"
						name="agregar" onclick="cambioAction(this.form, '<%=request.getContextPath()%>/Gasto.do?method=add')"
						value="<bean:message key="label.global.agregar" />">
					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>