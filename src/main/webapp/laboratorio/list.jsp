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


<html:form target="_self" action="/Laboratorio.do?method=list">
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
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Laboratorio.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="laboratorio.title.list" /></span>
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
			<span class="spanName" >Nombre:</span> &nbsp;
					<html:text styleClass="text" property="nombre" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
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
								<th><bean:message key="laboratorio.field.idlaboratorio" /></th>
								<th><bean:message key="laboratorio.field.nombre" /></th>
								<th><bean:message key="laboratorio.field.descripcion" /></th>
								<th ><bean:message key="label.global.acciones" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="laboratorio" name="LABORATORIOS"
								type="com.farmacia.domain.Laboratorio">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
																	<td><bean:write name="laboratorio" property="idlaboratorio"	scope="page" /></td>
																	<td><bean:write name="laboratorio" property="nombre"	scope="page" /></td>
																	<td><bean:write name="laboratorio" property="descripcion"	scope="page" /></td>
								
									<td nowrap="nowrap" align="center">
									<%
											java.util.HashMap map = new java.util.HashMap();
																				map.put("idlaboratorio", String.valueOf(laboratorio.getIdlaboratorio()));
																				pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Laboratorio.do?method=detail" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											
											<html:link href="/Farmacia/Laboratorio.do?method=edit" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/editar.gif"
													width="14" height="14" titleKey="label.global.editar" />
											</html:link>&nbsp;&nbsp;
										
											<html:link href="/Farmacia/Laboratorio.do?method=delete" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/eliminar.gif"
													width="14" height="14" titleKey="label.global.eliminar" />
											</html:link>&nbsp;&nbsp;
											
										</td>

								</tr>
							</logic:iterate>
						</table>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="LABORATORIOS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<div class="row">
					<div class="contBtnFo">
						<input type="button" class="boton"
						name="agregar" onclick="cambioAction(this.form, '<%=request.getContextPath()%>/Laboratorio.do?method=add')"
						value="<bean:message key="label.global.agregar" />">
					</div>
				</div>
							
		</section>
</html:form>