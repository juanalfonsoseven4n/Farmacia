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


<html:form target="_self" action="/Gasto.do?method=saveAdd">
<script type="text/javascript">
	function enviar(forma)
	{
		//document.getElementsByName('idfarmacia')[0].value=forma.campofarmacia.value
		//document.getElementsByName('idusuario')[0].value=forma.campousuario.value
					//forma.action=valor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="gasto.title.add" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				
							
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="gasto.field.descripcion" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="descripcion" maxlength="100"></html:text>
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="gasto.field.nombre" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="nombre" maxlength="30"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="gasto.field.fecha" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:text styleClass="selText"  property="fecha" size="10" maxlength="10" onfocus="this.select()" 
					   onblur="this.value=this.value.toUpperCase()" readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fecha', 'y/mm/dd');">
										</td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="gasto.field.valor" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valor" maxlength="13"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
				
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
		 <td class="formulario"><bean:message key="gasto.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" value="0"></html:hidden>
					<input type="text" class="selText"  name="campofarmacia" id="campofarmacia" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Farmacia.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descfarmacia" id="descfarmacia" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'"  style="display: none;">
		 <td class="formulario"><bean:message key="gasto.field.idusuario" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idusuario" value="0"></html:hidden>
					<input type="text" class="selText"  name="campousuario" id="campousuario" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Usuario.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descusuario" id="descusuario" readonly="readonly">
					</td>
									</tr>
								<tr >
					<td class="formulario" colspan="3" align="center">
						<span class="requerido"> <bean:message key="campos.requeridos"/> </span>
    				</td>
				</tr> 
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:button styleClass="boton" onclick="enviar(this.form)"
						property="Agregar" >
						<bean:message key="label.global.agregar" />
					</html:button></td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>