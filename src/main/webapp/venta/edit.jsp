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


<html:form target="_self" action="/Venta.do?method=saveEdit">
<script type="text/javascript">
	function enviar(forma)
	{
		document.getElementsByName('idfarmacia')[0].value=forma.campofarmacia
		document.getElementsByName('idcliente')[0].value=forma.campocliente
		document.getElementsByName('idmedico')[0].value=forma.campousuario
		document.getElementsByName('idusuario')[0].value=forma.campousuario
				forma.action=valor;
			forma.submit();
	}
</script>
<script type="text/javascript">
	
	function cambioAction(forma, valor)
	{
			forma.action=valor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="venta.title.edit" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				<logic:messagesPresent>
					<tr>
						<td colspan=3" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"><logic:messagesPresent>
							<html:messages id="error">
								<bean:write name="error" /><br>
							</html:messages>
						</logic:messagesPresent></td>
					</tr>
				</logic:messagesPresent>

								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.idventa" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="idventa"
 readonly="true" maxlength="11"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.fecha" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="fecha"
 maxlength="9"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.valortotal" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valortotal"
 maxlength="13"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.iva" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="iva"
 maxlength="13"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.codigo" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="codigo"
 maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.valor" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valor"
 maxlength="13"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="venta.field.hora" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="hora"
 maxlength="7"></html:text>
										</td>
				</tr>
				
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="venta.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" ></html:hidden>
					<input type="text" class="selText"  name="campofarmacia" id="campofarmacia" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Farmacia.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descfarmacia" id="descfarmacia" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="venta.field.idcliente" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idcliente" ></html:hidden>
					<input type="text" class="selText"  name="campocliente" id="campocliente" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Cliente.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="desccliente" id="desccliente" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="venta.field.idmedico" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idmedico" ></html:hidden>
					<input type="text" class="selText"  name="campousuario" id="campousuario" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Usuario.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descusuario" id="descusuario" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="venta.field.idusuario" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idusuario" ></html:hidden>
					<input type="text" class="selText"  name="campousuario" id="campousuario" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Usuario.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descusuario" id="descusuario" readonly="readonly">
					</td>
									</tr>
									<tr>
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Editar" >
						<bean:message key="label.global.editar" />
					</html:submit>
						<input type="button" class="boton"
						id="Regresar" onclick="cambioAction(this.form,'<%=request.getContextPath()%>/Venta.do?method=list');" 
						value="<bean:message key="label.global.regresar" />"	>
					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
