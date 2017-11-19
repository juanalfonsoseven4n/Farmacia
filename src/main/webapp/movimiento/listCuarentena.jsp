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
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="movimiento.title.listcuarentena" /></td>
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
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarFiltro(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>

				</tr>

				
				
				<logic:notEmpty name="PRODSCUARENTENA" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="0" width="100%" align="center">
							<tr class="titulos">
								<td><bean:message key="movimiento.field.idproducto" /></td>
								<td width="10%"><bean:message key="movimiento.field.cantidadCaja" /></td>
								<td width="10%"><bean:message key="movimiento.field.cantidadSobre" /></td>
								<td width="10%"><bean:message key="movimiento.field.fechaexp" /></td>
								<td width="15%"><bean:message key="producto.field.idcategoria" /></td>	
								<td width="15%"><bean:message key="producto.field.idcategoriad" /></td>								
							</tr>
	
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
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="PRODSCUARENTENA" scope="session">
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
			</table>
			</td>
			</tr>
			</table>
			
</html:form>