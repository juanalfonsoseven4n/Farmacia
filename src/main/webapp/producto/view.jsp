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


<html:form target="_self" action="/Producto.do?method=list">

	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos" ><bean:message
				key="producto.title.detail" /></td>
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

								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.idproducto" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idproducto" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.nombre" /></td>
					<td width="5"></td>
					<td ><html:hidden property="nombre" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.presentacion" /></td>
					<td width="5"></td>
					<td ><html:hidden property="presentacion" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.codigo" /></td>
					<td width="5"></td>
					<td ><html:hidden property="codigo" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.invima" /></td>
					<td width="5"></td>
					<td ><html:hidden property="invima" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.iva" /></td>
					<td width="5"></td>
					<td ><html:hidden property="iva" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="producto.field.valorunit" /></td>
					<td width="5"></td>
					<td ><html:hidden property="valorunit" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.valor" /></td>
					<td width="5"></td>
					<td ><html:hidden property="valor" write="true"></html:hidden></td>
				</tr>
								
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.precioventa" /></td>
					<td width="5"></td>
					<td ><html:hidden property="precioventa" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.cantidadmin" /></td>
					<td width="5"></td>
					<td ><html:hidden property="cantidadmin" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.idlaboratorio" /></td>
					<td width="5"></td>
					<td ><html:hidden property="labdesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.idcategoria" /></td>
					<td width="5"></td>
					<td ><html:hidden property="catdesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.idcategoriad" /></td>
					<td width="5"></td>
					<td ><html:hidden property="catdescd" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.comentarios" /></td>
					<td width="5"></td>
					<td ><html:hidden property="comentarios" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.indicaciones" /></td>
					<td width="5"></td>
					<td ><html:hidden property="indicaciones" write="true"></html:hidden></td>
				</tr>
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.idfamilia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="famdesc" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="producto.field.sobre" /></td>
					<td width="5"></td>
					<td ><html:hidden property="sobre" write="true"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.caja" /></td>
					<td width="5"></td>
					<td><html:hidden property="caja" write="true"></html:hidden></td>
				</tr>
				<tr >
                    <td colspan="3">
                    <table align="center" width="80%">
		                   <tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		                    <td class="titulos" colspan="7" style="text-align: center;"><bean:message key="provprod.title" />
		                    
		                    </td>
						</tr>	
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		                   <td>&nbsp;</td>
							<td  style="text-align: center;">
								<bean:message key="provprod.field.idprovprod" />
							</td>
							<td>&nbsp;</td>
							<td  style="text-align: center;"><bean:message key="provprod.field.valor" /></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						
						<logic:notEmpty name="provprodLista" scope="session">
						<logic:iterate indexId="ind" id="provprod" name="provprodLista"
								type="com.farmacia.domain.Provprod">
									<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
		                    <td>&nbsp;</td>
							<td style="text-align: center;">
								<bean:write name="provprod" property="provdesc"/>
							</td>
							<td>&nbsp;</td>
							<td style="text-align: center;">$<bean:write name="provprod" property="valor" format="#,##0.00"/></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						</logic:iterate>
						</logic:notEmpty>
                    </table>
                    </td>
				</tr>	
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:submit styleClass="boton" property="Regresar" >
						<bean:message key="label.global.regresar" />
					</html:submit></td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
