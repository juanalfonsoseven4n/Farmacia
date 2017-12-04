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


<html:form target="_self" action="/Movimiento.do?method=saldo">
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
		forma.submit();
	}
</script>
<section class="main">
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


		<div class="tit">
		<span><bean:message
				key="movimiento.title.listSaldo" /></span>
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
			<span class="spanName" >Nombre de <bean:message key="movimiento.field.idproducto"/>:</span>
			<html:text  property="proddesc" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text>
						
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
		</div>
	</div>

				
				
				<logic:notEmpty name="SALDOS" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="movimiento.field.idproducto" /></th>
								<th><bean:message key="producto.field.codigobarras" /></th>
								<th width="12%"><bean:message key="movimiento.field.cantidadCaja" /></th>
								<th width="12%"><bean:message key="movimiento.field.cantidadSobre" /></th>
								<th width="12%"><bean:message key="movimiento.field.preciocompra" /></th>
								<th width="12%"><bean:message key="movimiento.field.precioventa" /></th>
								<th width="12%"><bean:message key="movimiento.field.valorMercanciaCompra" /></th>
								<th width="12%"><bean:message key="movimiento.field.valorMercancia" /></th>	
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="movimiento" name="SALDOS"
								type="com.farmacia.domain.Movimiento">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td><bean:write name="movimiento" property="proddesc"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="codigoBarras"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="cantidad"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="unidades"	scope="page" /></td>
									<td align="right">$<bean:write name="movimiento" property="preciocosto"	scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="movimiento" property="precio"	scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="movimiento" property="valorMercanciaCompra"	scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="movimiento" property="valorMercancia"	scope="page" format="#,##0.00"/></td>
								</tr>
							</logic:iterate>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="movimiento.field.totalcompras" /> : $<bean:write name="movimientoForm" property="totalCompras" format="#,##0.00"/> &nbsp; <br>
			                    </td>
							</tr>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="movimiento.field.totalventas" /> : $<bean:write name="movimientoForm" property="totalVentas" format="#,##0.00"/> &nbsp; <br>
			                    </td>
							</tr>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="movimiento.field.totalmercanciacompra" /> : $<bean:write name="movimientoForm" property="totalMercanciaCompra" format="#,##0.00"/> &nbsp;                     	
			                    </td>
							</tr>
							<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
			                    <td colspan="8" align="right">
			                    	<bean:message key="movimiento.field.totalmercancia" /> : $<bean:write name="movimientoForm" property="totalMercancia" format="#,##0.00"/> &nbsp;                     	
			                    </td>
							</tr>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="SALDOS" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
							
		</section>
			
</html:form>