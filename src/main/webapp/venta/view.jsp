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

<script type="text/javascript">
	function registraVenta(forma)
	{
		window.open('<%=request.getContextPath()%>/venta/reciboAnt.jsp','popup','width=400,height=650,scrollbars=yes,resizable=yes,menubar=yes')
	}
	
	function returnToFacturas(forma){
		forma.method.value='listFacturas';
		forma.submit();
	}
</script>
<html:form target="_self" action="/Venta.do">
	<input type="hidden" id="method" name="method" value="list"/>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="venta.title.detail" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				<logic:messagesPresent>
					<tr>
						<td colspan=3" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" />
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="venta.field.idventa" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idventa" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.fecha" /></td>
					<td width="5"></td>
					<td ><html:hidden property="fechaFormated" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.hora" /></td>
					<td width="5"></td>
					<td ><html:hidden property="horaFormated" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.idusuario" /></td>
					<td width="5"></td>
					<td >
						<html:hidden property="vendedor" write="true"></html:hidden>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.idmedico" /></td>
					<td width="5"></td>
					<td >
						<html:hidden property="medico" write="true"></html:hidden>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.valortotal" /></td>
					<td width="5"></td>
					<td >$<bean:write name="ventaForm" property="valortotalNum" format="#,##0.00"/></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.iva" /></td>
					<td width="5"></td>
					<td >$<bean:write name="ventaForm" property="ivaNum" format="#,##0.00"/></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.idcliente" /></td>
					<td width="5"></td>
					<td >
						<html:hidden property="cliente" write="true"></html:hidden>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="venta.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="venta.field.codigo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="codigo" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="venta.field.valor" /></td>
					<td width="5"></td>
					<td ><html:hidden property="valor" write="true"></html:hidden></td>
				</tr>
				
				
				<logic:notEmpty name="DETVENTAS" scope="session">
					<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td colspan="3"   align="center">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td><bean:message key="detventa.field.idproducto" /></td>
								<td><bean:message key="detventa.field.cantidad" /></td>
								<td><bean:message key="detventa.field.valorunit" /></td>
								<td><bean:message key="detventa.field.valor" /></td>
								<td>&nbsp;-&nbsp;</td>
								
							</tr>

							<logic:iterate indexId="ind" id="detventa" name="DETVENTAS"
								type="com.farmacia.domain.Detventa">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td><bean:write name="detventa" property="nombreProducto"	scope="page" /></td>
									<td align="right"><bean:write name="detventa" property="cantidad"	scope="page" />&nbsp;
										<logic:equal value="1" name="detventa" property="presentacion">CAJAS</logic:equal>
										<logic:equal value="2" name="detventa" property="presentacion">SOBRES</logic:equal>
									</td>
									<td align="right">$<bean:write name="detventa" property="valorunit"	format="#,##0.00" scope="page" /></td>
									<td align="right">$<bean:write name="detventa" property="valor" format="#,##0.00" scope="page" /></td>
									<td align="right">
										<logic:equal value="1" name="detventa" property="marca">X</logic:equal>
										<logic:equal value="0" name="detventa" property="presentacion">O</logic:equal>
									</td>
								

								</tr>
							</logic:iterate>
						</table>
						</td>
				</tr>
				</logic:notEmpty>
					

				<tr  align="center">
					<td colspan="3" >
					<logic:empty name="detailFactura" scope="session">
					<html:submit styleClass="boton"
						property="Regresar" >
						<bean:message key="label.global.regresar" />
					</html:submit>
					</logic:empty>
					<logic:notEmpty name="detailFactura" scope="session">
					<html:button styleClass="boton" property="backFacturas" onclick="returnToFacturas(this.form);">
						Regresar
					</html:button>
					</logic:notEmpty>
					&nbsp;
					<html:button styleClass="boton" property="regSale" onclick="registraVenta(this.form);">
						Imprimir Recibo
					</html:button>
					</td>
				</tr>
				
				
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
