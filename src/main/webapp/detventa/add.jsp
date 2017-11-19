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


<html:form target="_self" action="/Detventa.do?method=saveAdd">
<script type="text/javascript">
	function enviar(forma)
	{
		document.getElementsByName('idventa')[0].value=forma.campoventa
		document.getElementsByName('idproducto')[0].value=forma.campoproducto
				forma.action=valor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="detventa.title.add" /></td>
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
                    <td class="formulario"><bean:message key="detventa.field.cantidad" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="cantidad" maxlength="11"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="detventa.field.valor" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valor" maxlength="13"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="detventa.field.iva" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="iva" maxlength="13"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="detventa.field.valorunit" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valorunit" maxlength="13"></html:text>
										</td>
				</tr>
				
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="detventa.field.idventa" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idventa" value="0"></html:hidden>
					<input type="text" class="selText"  name="campoventa" id="campoventa" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Venta.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descventa" id="descventa" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="detventa.field.idproducto" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idproducto" value="0"></html:hidden>
					<input type="text" class="selText"  name="campoproducto" id="campoproducto" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Producto.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descproducto" id="descproducto" readonly="readonly">
					</td>
									</tr>
								<tr >
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton"
						property="Agregar" >
						<bean:message key="label.global.agregar" />
					</html:submit></td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>