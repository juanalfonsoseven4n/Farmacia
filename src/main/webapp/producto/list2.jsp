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


<html:form target="_self" action="/Producto.do?method=list">
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
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Producto.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />

	<div class="tit">
		<span><bean:message key="producto.title.list" /></span>
		<logic:present name="mensaje" scope="request">
					<span><tr>			
						<td class="exito" colspan="2" align="center">
							<bean:message name="mensaje" scope="request"/>
						</td>
					</tr></span>
				</logic:present>
				<logic:messagesPresent>
					<span><tr>
						<td colspan=3"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr></span>
				</logic:messagesPresent>
		<div class="contBus">
			<html:text styleClass="big" title="Nombre1" alt="Nombre2"  property="nombre" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
			<html:submit styleClass="boton" property="Buscar" >
				<bean:message key="label.global.buscar" />
			</html:submit>&nbsp;
			<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarNombre(this.form);">
				<bean:message key="label.global.limpiar" />
			</html:button>
		</div>
	</div>
	<div class="prevNext"><c:out value="${sessionScope.stringpag}" escapeXml="false" /></div>
						
				<logic:notEmpty name="PRODUCTOS" scope="session">
					
						<div class="tableCont">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<thead>
							<tr>
								<th style="display: none;"><bean:message key="producto.field.idproducto" /></th>
								<th><bean:message key="producto.field.nombre" /></th>
								<th><bean:message key="producto.field.idfamilia" /></th>
								<th><bean:message key="producto.field.presentacion" /></th>
								<th><bean:message key="producto.field.sobre" /></th>
								<th><bean:message key="producto.field.caja" /></th>

								<th><bean:message key="producto.field.codigobarras" /></th>
								<th><bean:message key="producto.field.invima" /></th>
								<th style="display: none;"><bean:message key="producto.field.iva" /></th>
								<th style="display: none;"><bean:message key="producto.field.valorunit" /></th>
								<th><bean:message key="producto.field.valor" /></th>
								<th><bean:message key="producto.field.precioventa" /></th>
								<th style="display: none;"><bean:message key="producto.field.cantidadmin" /></th>
								
								<th style="display: none;"><bean:message key="producto.field.comentarios" /></th>
								<th style="display: none;"><bean:message key="producto.field.indicaciones" /></th>
								<th><bean:message key="producto.field.idlaboratorio" /></th>
								<th><bean:message key="producto.field.idcategoria" /></th>
								<th><bean:message key="producto.field.idcategoriad" /></th>																
								<th colspan="3"><bean:message key="label.global.acciones" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="producto" name="PRODUCTOS"
								type="com.farmacia.domain.Producto">
								
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"> 
									<td style="display: none;"><bean:write name="producto" property="idproducto"	scope="page" /></td>
									<td><bean:write name="producto" property="nombre"	scope="page" /></td>
									<td><bean:write name="producto" property="famdesc"	scope="page" /></td>
									<td><bean:write name="producto" property="presentacion"	scope="page" /></td>
									<td align="right"><bean:write name="producto" property="sobre"	scope="page" /></td>
									<td align="right"><bean:write name="producto" property="caja"	scope="page" /></td>
									<td><bean:write name="producto" property="codigo"	scope="page" /></td>
									<td><bean:write name="producto" property="invima"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="iva"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="valorunit"	scope="page" /></td>
									<td align="right">$<bean:write name="producto" property="valor" scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="producto" property="precioventa" scope="page" format="#,##0.00"/></td>
									<td style="display: none;"><bean:write name="producto" property="cantidadmin"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="comentarios"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="indicaciones"	scope="page" /></td>
									<td><bean:write name="producto" property="labdesc"	scope="page" /></td>
									<td><bean:write name="producto" property="catdesc"	scope="page" /></td>
									<td><bean:write name="producto" property="catdescd"	scope="page" /></td>
									
									<td width="2%">
									<%
											java.util.HashMap map = new java.util.HashMap();
																				map.put("idproducto", String.valueOf(producto.getIdproducto()));
																				pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
									%>
											<html:link href="/Farmacia/Producto.do?method=detail" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/ver.gif"
													width="14" height="14" titleKey="label.global.ver" />
											</html:link>&nbsp;&nbsp;
											
											</td>
										<td width="2%">
											<html:link href="/Farmacia/Producto.do?method=edit" name="map"	scope="page">
												<html:img border="0" src="/Farmacia/images/editar.gif"
													width="14" height="14" titleKey="label.global.editar" />
											</html:link>&nbsp;&nbsp;
											
										</td>
										<td width="2%">
											<html:link href="/Farmacia/Producto.do?method=delete" name="map"	scope="page">
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


				<logic:empty name="PRODUCTOS" scope="session">
					<table>
						<tr align="center">
							<td colspan="1">&nbsp;</td>
							<td colspan="1"><bean:message key="label.global.noregisters" /></td>
							<td colspan="1">&nbsp;</td>
						</tr>
					</table>
				</logic:empty>
				
				<div class="row">
					<div class="contBtnFo">
						<input type="button" class="boton"
						name="agregar" onclick="cambioAction(this.form, '<%=request.getContextPath()%>/Producto.do?method=add')"
						value="<bean:message key="label.global.agregar" />">
					</div>
				</div>
							
		</section>	
</html:form>
