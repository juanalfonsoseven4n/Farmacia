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


<html:form target="_self" action="/Movimiento.do?method=listCuarentena">
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
				key="movimiento.title.listcuarentena" /></span>
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

				
				
				<logic:notEmpty name="PRODSCUARENTENA" scope="session">
					<div class="tableCont">
						<table cellspacing="0">
							<thead>
							<tr>
								<th><bean:message key="movimiento.field.idproducto" /></th>
								<th width="10%"><bean:message key="movimiento.field.cantidadCaja" /></th>
								<th width="10%"><bean:message key="movimiento.field.cantidadSobre" /></th>
								<th width="10%"><bean:message key="movimiento.field.fechaexp" /></th>
								<th width="15%"><bean:message key="producto.field.idcategoria" /></th>	
								<th width="15%"><bean:message key="producto.field.idcategoriad" /></th>								
							</tr>
							</thead>
							<tbody>
							<logic:iterate indexId="ind" id="movimiento" name="PRODSCUARENTENA"
								type="com.farmacia.domain.Movimiento">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td><bean:write name="movimiento" property="proddesc"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="cantidad"	scope="page" /></td>
									<td align="right"><bean:write name="movimiento" property="unidades"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="fechaexpFormated" scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="catdesc"	scope="page" /></td>
									<td align="center"><bean:write name="movimiento" property="catdescd" scope="page" /></td>
								</tr>
							</logic:iterate>
							</tbody>
						</table>
						</div>
				</logic:notEmpty>


				<logic:empty name="PRODSCUARENTENA" scope="session">
					<tr align="center">
						<td colspan="1">&nbsp;</td>
						<td colspan="1"><bean:message key="label.global.noregisters" /></td>
						<td colspan="1">&nbsp;</td>
					</tr>
				</logic:empty>
							
		</section>
			
</html:form>