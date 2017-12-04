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


<html:form target="_self" action="/Movimiento.do?method=listExistenciasLab">
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
		document.getElementsByName('idcategoria')[0].value='0'
		forma.submit();
	}
</script>
<section class="main">
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


		<div class="tit">
		<span><bean:message
				key="movimiento.title.listexistentes" /></span>
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
			<span class="spanName" >
				<bean:message key="producto.field.idlaboratorio" /></span>
			<html:select property="idlaboratorio" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="labLista" labelProperty="nombre" property="idlaboratorio" />
					</html:select>&nbsp;
					
					<bean:message key="producto.field.idcategoria" /></span>
			<html:select property="idcategoria" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="catLista" labelProperty="nombre" property="idcategoria" />
					</html:select> &nbsp;
					Nombre de <bean:message key="movimiento.field.idproducto"/>:</span>
			<html:text  property="proddesc" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
		</div>
	</div>

				
				<logic:notEmpty name="EXISTENTESLAB" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="movimiento.field.idproducto" /></th>
								<th width="13%"><bean:message key="producto.field.presentacion" /></th>
								<th width="13%"><bean:message key="producto.field.idfamilia" /></th>
								<th width="10%"><bean:message key="producto.field.codigobarras" /></th>
								<th width="6%"><bean:message key="movimiento.field.cantidadCaja" /></th>
								<th width="6%"><bean:message key="producto.field.precioventa" /></th>
								<th width="15%"><bean:message key="producto.field.idcategoria" /></th>
								<th width="10%"><bean:message key="producto.field.idlaboratorio" /></th>
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="movimiento" name="EXISTENTESLAB"
								type="com.farmacia.domain.MovimientoProd">
								<logic:equal value="1" name="movimiento" property="cuarentena">
									<tr class="navcuarentena" onmouseover="className='navon'" onmouseout="className='navcuarentena'">
								</logic:equal>
								<logic:notEqual value="1" name="movimiento" property="cuarentena">
									<logic:equal value="1" name="movimiento" property="prioritario">
										<tr class="navprioridad" onmouseover="className='navon'" onmouseout="className='navprioridad'">
									</logic:equal>
									<logic:notEqual value="1" name="movimiento" property="prioritario">
										<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									</logic:notEqual>
								</logic:notEqual>
									<td><bean:write name="movimiento" property="proddesc"	scope="page" /></td>
									<td><bean:write name="movimiento" property="presentacion"	scope="page" /></td>
									<td><bean:write name="movimiento" property="farmdesc"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="codigoBarras"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="cantidad"	scope="page" /></td>
									<td align="right">$<bean:write name="movimiento" property="precioVentaCaja"	scope="page" format="#,##0.00"/></td>
									<td align="center"><bean:write name="movimiento" property="catdesc"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="labdesc" scope="page" /></td>
								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="EXISTENTESLAB" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
							
		</section>
			
</html:form>