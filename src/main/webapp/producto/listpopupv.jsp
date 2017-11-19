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


<html:form target="_self" action="/Producto.do?method=listPopup">
<script type="text/javascript">
	function transfer(
	idproducto
	, 	nombre
	, 	presentacion
	, 	cantidad
	, 	codigo
	, 	iva
	, 	valorunit
	, 	valor
	, 	precioventa
	, 	cantidadmin
	, 	idlaboratorio
	, 	comentarios
	, 	indicaciones
	, 	idfamilia
		){

		eval("top.opener.document.getElementById('campoproducto').value = \'"+idproducto+"\'")
		eval("top.opener.document.getElementById('descproducto').value = \'"+nombre+"\'")
		eval("top.opener.document.getElementsByName('valorunit')[0].value = \'"+precioventa+"\'")
		if(precioventa!=''){
			eval("top.opener.document.getElementsByName('valorunit')[0].value = \'"+precioventa+"\'")
		}else{
			eval("top.opener.document.getElementsByName('valorunit')[0].value = '0'")
		}
		if(valor!=''){
			eval("top.opener.document.getElementsByName('valorunitsobre')[0].value = \'"+valor+"\'")
		}else{
			eval("top.opener.document.getElementsByName('valorunitsobre')[0].value = '0'")
		}
		if(iva!=''){
			eval("top.opener.document.getElementsByName('ivadet')[0].value = \'"+iva+"\'")
		}else{
			eval("top.opener.document.getElementsByName('ivadet')[0].value = '0'")
		}
		window.close();
	}   
</script>
	<input type="hidden" name="listPager" id="listPager" value="<%=request.getContextPath()%>/Producto.do?method=pager" />
	<html:hidden property="strutsAction" />
	<input type="hidden" name="idTabla" id="idTabla"/>
	<input type="hidden" name="venta" id="venta" value="venta"/>
	<html:hidden property="strutsOrderby" />


	<table border="0" cellpadding="0" cellspacing="0" width=100% align="center">
		<tr >
			<td align="center" class="titulos" ><bean:message
				key="producto.title.list" /></td>
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


					<td align="center" colspan=3" >Nombre: &nbsp;
					<html:text  property="nombre" maxlength="50" onkeyup="this.value=this.value.toUpperCase()"></html:text> &nbsp;
					<html:submit styleClass="boton"
						property="Buscar" >
						<bean:message key="label.global.buscar" />
					</html:submit>&nbsp;
					<html:button styleClass="boton"	property="LimpiarBt" onclick="limpiarNombre(this.form);">
						<bean:message key="label.global.limpiar" />
					</html:button>
					</td>

				</tr>

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">


					<td align="right" colspan=3"><c:out
						value="${sessionScope.stringpag}" escapeXml="false" /></td>

				</tr>
				
				<logic:notEmpty name="PRODUCTOS" scope="session">
					<tr>
						<td colspan="3">
						<table border="0" cellspacing="2" cellpadding="3" width="100%" align="center">
							<tr class="titulos">
								<td colspan="1"><bean:message key="label.global.acciones" /></td>
								<td style="display: none;"><bean:message key="producto.field.idproducto" /></td>
								<td><bean:message key="producto.field.nombre" /></td>
								<td><bean:message key="producto.field.idfamilia" /></td>
								<td><bean:message key="producto.field.presentacion" /></td>
								<td style="display: none;"><bean:message key="producto.field.idcategoria" /></td>
								<td style="display: none;"><bean:message key="producto.field.idcategoriad" /></td>
								<td><bean:message key="producto.field.codigobarras" /></td>
								<td style="display: none;"><bean:message key="producto.field.iva" /></td>
								<td style="display: none;"><bean:message key="producto.field.valorunit" /></td>
								<td><bean:message key="producto.field.valor" /></td>
								<td><bean:message key="producto.field.precioventa" /></td>
								<td style="display: none;"><bean:message key="producto.field.cantidadmin" /></td>
								<td style="display: none;"><bean:message key="producto.field.comentarios" /></td>
								<td style="display: none;"><bean:message key="producto.field.indicaciones" /></td>
								<td style="display: none;"><bean:message key="producto.field.idlaboratorio" /></td>
																								

							</tr>

							<logic:iterate indexId="ind" id="producto" name="PRODUCTOS"
								type="com.farmacia.domain.Producto">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>
										<input type="radio" class="radio" name="item" id="item" 
										onclick="transfer('<bean:write name="producto" property="idproducto"	scope="page" />'
											,  				'<bean:write name="producto" property="nombre"	scope="page" />'
											,  				'<bean:write name="producto" property="presentacion"	scope="page" />'
											,  				'<bean:write name="producto" property="idcategoria"	scope="page" />'
											,  				'<bean:write name="producto" property="codigo"	scope="page" />'
											,  				'<bean:write name="producto" property="iva"	scope="page" />'
											,  				'<bean:write name="producto" property="valorunit"	scope="page" />'
											,  				'<bean:write name="producto" property="valor"	scope="page" />'
											,  				'<bean:write name="producto" property="precioventa"	scope="page" />'
											,  				'<bean:write name="producto" property="cantidadmin"	scope="page" />'
											,  				'<bean:write name="producto" property="idlaboratorio"	scope="page" />'
											,  				'<bean:write name="producto" property="comentarios"	scope="page" />'
											,  				'<bean:write name="producto" property="indicaciones"	scope="page" />'
											,  				'<bean:write name="producto" property="idfamilia"	scope="page" />'
											 			);" />
									</td>
									<td><bean:write name="producto" property="nombre"	scope="page" /></td>
									<td><bean:write name="producto" property="famdesc"	scope="page" /></td>
									<td><bean:write name="producto" property="presentacion"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="idcategoria"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="idcategoriad"	scope="page" /></td>
									<td><bean:write name="producto" property="codigo"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="iva"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="valorunit"	scope="page" /></td>
									<td align="right">$<bean:write name="producto" property="valor" scope="page" format="#,##0.00"/></td>
									<td align="right">$<bean:write name="producto" property="precioventa" scope="page" format="#,##0.00"/></td>
									<td style="display: none;"><bean:write name="producto" property="cantidadmin"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="comentarios"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="indicaciones"	scope="page" /></td>
									<td style="display: none;"><bean:write name="producto" property="labdesc"	scope="page" /></td>
										
								</tr>
							</logic:iterate>
						</table>
						</td>
					</tr>

				</logic:notEmpty>


				<logic:empty name="PRODUCTOS" scope="session">
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>	
						<td colspan="3" align="center"><b><bean:message key="label.global.noregisters" /></b></td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
				</logic:empty>
			
			</table>
			</td>
			</tr>
			</table>
			
</html:form>