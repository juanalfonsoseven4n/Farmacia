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


<html:form target="_self" action="/Movimiento.do?method=list">
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
		document.getElementsByName('proddesc')[0].value=''
		document.getElementsByName('fechaini')[0].value=''
		document.getElementsByName('fechafin')[0].value=''
		forma.submit();
	}
</script>
<section class="main">
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Movimiento.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<div class="tit">
		<span><bean:message
				key="movimiento.title.list" /></span>
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
			<span class="spanName" >Nombre de <bean:message key="movimiento.field.idproducto"/>:</span> &nbsp;
					<html:text styleClass="text" property="proddesc" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<span class="spanName" ><bean:message key="movimiento.field.fechaini"/>:</span> &nbsp;
					<html:text styleClass="text" property="fechaini" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');"> &nbsp;
					<span class="spanName" ><bean:message key="movimiento.field.fechafin"/>:</span> &nbsp;
					<html:text styleClass="text" property="fechafin" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechafin', 'y/mm/dd');"> &nbsp;			
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</div>
	</div>
	<div class="prevNext"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="MOVIMIENTOS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="movimiento.field.fecha" /></th>
								<th ><bean:message key="movimiento.field.idmovimiento" /></th>
								<th><bean:message key="movimiento.field.idproducto" /></th>
								<th style="display: none;"><bean:message key="movimiento.field.valor" /></th>
								<th style="display: none;"><bean:message key="movimiento.field.codigo" /></th>
								<th><bean:message key="movimiento.field.tipo" /></th>
								<th><bean:message key="movimiento.field.cantidad" /></th>
								<th><bean:message key="movimiento.field.precio" /></th>
								<th><bean:message key="movimiento.field.preciocosto" /></th>
								<th><bean:message key="movimiento.field.fechaexp" /></th>
								<th><bean:message key="movimiento.field.idusuario" /></th>
								<th style="display: none;"><bean:message key="movimiento.field.idfarmacia" /></th>
								<th style="display: none;"><bean:message key="movimiento.field.hora" /></th>
								<th ><bean:message key="label.global.acciones" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="movimiento" name="MOVIMIENTOS"
								type="com.farmacia.domain.Movimiento">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td align="center"><bean:write name="movimiento" property="fechaFormated"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="idmovimiento"	scope="page" /></td>
									<td><bean:write name="movimiento" property="proddesc"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="valor"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="codigo"	scope="page" /></td>
									<td align="center">
										<logic:equal value="1" name="movimiento" property="tipo">ENTRADA</logic:equal>
										<logic:equal value="2" name="movimiento" property="tipo">SALIDA</logic:equal>
										<logic:equal value="3" name="movimiento" property="tipo">VENTA</logic:equal>
									</td>
									<td align="right"><bean:write name="movimiento" property="cantidad"	scope="page" />&nbsp;
										<logic:equal value="1" name="movimiento" property="valor">CAJAS</logic:equal>
										<logic:equal value="2" name="movimiento" property="valor">SOBRES</logic:equal>
									</td>
									<td align="right">$<bean:write name="movimiento" property="precio"	scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="movimiento" property="preciocosto"	scope="page" format="#,##0.00"/></td>
									<td align="center"><bean:write name="movimiento" property="fechaexpFormated"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="usudesc" scope="page" /></td>
									
									<td style="display: none;"><bean:write name="movimiento" property="idfarmacia"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="hora"	scope="page" /></td>
								
									<td nowrap="nowrap" align="center">
									<%
											java.util.HashMap map = new java.util.HashMap();
																				map.put("idmovimiento", String.valueOf(movimiento.getIdmovimiento()));
																				pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Movimiento.do?method=detail" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											<html:link href="/Farmacia/Movimiento.do?method=edit" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/editar.gif"
													width="14" height="14" titleKey="label.global.editar" />
											</html:link>&nbsp;&nbsp;
										
											<html:link href="/Farmacia/Movimiento.do?method=delete" name="map"	scope="page">
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


				<logic:empty name="MOVIMIENTOS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<div class="row">
					<div class="contBtnFo">
						<input type="button" class="boton"
						name="agregar" onclick="cambioAction(this.form, '<%=request.getContextPath()%>/Movimiento.do?method=add')"
						value="<bean:message key="label.global.agregar" />">
					</div>
				</div>
							
		</section>
</html:form>