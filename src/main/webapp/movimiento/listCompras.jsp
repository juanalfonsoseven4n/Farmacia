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

<%@page import="java.text.DecimalFormat"%>
<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">


<html:form target="_self" action="/Movimiento.do?method=listCompras">
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
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="movimiento.title.list" /></td>
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


					<td align="center" colspan=3">Nombre de <bean:message key="movimiento.field.idproducto"/>: &nbsp;
					<html:text  property="proddesc" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<bean:message key="movimiento.field.fechaini"/>: &nbsp;
					<html:text styleClass="selText"    property="fechaini" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechaini', 'y/mm/dd');"> &nbsp;
					<bean:message key="movimiento.field.fechafin"/>: &nbsp;
					<html:text styleClass="selText"    property="fechafin" size="10" maxlength="10" onfocus="this.select()" 
					    readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechafin', 'y/mm/dd');"> &nbsp;			
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>

				</tr>

				<%
					double totalPag=0; 
					String total="0";
				%>
				
				<logic:notEmpty name="COMPRAS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td><bean:message key="movimiento.field.fecha" /></td>
								<td><bean:message key="movimiento.field.idproducto" /></td>
								<td style="display: none;"><bean:message key="movimiento.field.valor" /></td>
								<td style="display: none;"><bean:message key="movimiento.field.codigo" /></td>
								<td><bean:message key="movimiento.field.cantidad" /></td>
								<td><bean:message key="movimiento.field.precio" /></td>
								<td><bean:message key="movimiento.field.preciocosto" /></td>
								<td><bean:message key="movimiento.field.fechaexp" /></td>
								<td><bean:message key="movimiento.field.idusuario" /></td>
								<td style="display: none;"><bean:message key="movimiento.field.idmovimiento" /></td>
								<td style="display: none;"><bean:message key="movimiento.field.idfarmacia" /></td>
								<td style="display: none;"><bean:message key="movimiento.field.hora" /></td>
								
							</tr>

							<logic:iterate indexId="ind" id="movimiento" name="COMPRAS"
								type="com.farmacia.domain.Movimiento">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td  align="center"><bean:write name="movimiento" property="fechaFormated"	scope="page" /></td>
									<td><bean:write name="movimiento" property="proddesc"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="valor"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="codigo"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="cantidad"	scope="page" />&nbsp;
										<logic:equal value="1" name="movimiento" property="valor">CAJAS</logic:equal>
										<logic:equal value="2" name="movimiento" property="valor">SOBRES</logic:equal>
									</td>
									<td align="right">$<bean:write name="movimiento" property="precio"	scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="movimiento" property="preciocosto"	scope="page" format="#,##0.00"/></td>
									<td align="center"><bean:write name="movimiento" property="fechaexpFormated"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="usudesc" scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="idmovimiento"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="idfarmacia"	scope="page" /></td>
									<td style="display: none;"><bean:write name="movimiento" property="hora"	scope="page" /></td>
								<%
									totalPag=totalPag+movimiento.getPreciocosto().doubleValue();	
								%>
									

								</tr>
							</logic:iterate>
								<%
									DecimalFormat format = new DecimalFormat("#,##0.00");
									total =format.format(totalPag);
								%>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="COMPRAS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
				<tr  align="center" class="titulos" >
					<td colspan="3" >&nbsp;
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td colspan="3" align="right">
                    	La suma de los valores es: $<%= total %> &nbsp; <br>
                    </td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>