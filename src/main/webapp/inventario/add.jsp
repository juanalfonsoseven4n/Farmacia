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


<html:form target="_self" action="/Inventario.do?method=saveAdd">
<script type="text/javascript">
	function enviar(forma)
	{
	//	document.getElementsByName('idfarmacia')[0].value=forma.campofarmacia
	//	document.getElementsByName('idproducto')[0].value=forma.campoproducto
				forma.action=valor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="inventario.title.add" /></td>
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
                    <td class="formulario"><bean:message key="inventario.field.cantidad" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="cantidad" maxlength="11"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="inventario.field.fechaexpir" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:text styleClass="selText"    property="fechaexpir" size="10" maxlength="10" onfocus="this.select()" 
																			   onblur="this.value=this.value.toUpperCase()" readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
																			   alt="Obtener Fecha" onclick="return showCalendar('fechaexpir', 'y/mm/dd');">
																	
					
					
					
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="inventario.field.fechaing" />
                    
                    </td>
					<td width="5"></td>
					<td >
										<html:text styleClass="selText"  property="fechaing" size="10" maxlength="10" onfocus="this.select()" 
																			   onblur="this.value=this.value.toUpperCase()" readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
																			   alt="Obtener Fecha" onclick="return showCalendar('fechaing', 'y/mm/dd');">
										
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="inventario.field.codigo" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="codigo" maxlength="30"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="inventario.field.preciocosto" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="preciocosto" maxlength="13"></html:text>
										</td>
				</tr>
				
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="inventario.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" value="0"></html:hidden>
					<input type="text" class="selText"  name="campofarmacia" id="campofarmacia" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Farmacia.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descfarmacia" id="descfarmacia" readonly="readonly">
					</td>
									</tr>
			<tr style="display: none;" class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		 <td class="formulario"><bean:message key="inventario.field.idproducto" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idproducto" value="0"></html:hidden>
					
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