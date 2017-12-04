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


<html:form target="_self" action="/Producto.do?method=saveAdd">
	<script type="text/javascript">
	function enviar(forma)
	{

		document.getElementsByName('idfamilia')[0].value=forma.campofamilia.value
			//	forma.action=valor;
			forma.submit();
	}
	
	function agregarPP(forma)
	{

		document.getElementsByName('idfamilia')[0].value=forma.campofamilia.value
				forma.action='Producto.do?method=agregaProvProd';
			forma.submit();
	}
	function borrarPP(forma,proveedor)
	{

		document.getElementsByName('idfamilia')[0].value=forma.campofamilia.value
				forma.action='Producto.do?method=borraProvProd';
				forma.proveedorID.value= proveedor;
			forma.submit();
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />
	<input type="hidden" name="proveedorID" id="proveedorID" />
	<input type="hidden" name="pageSource" id="pageSource" value="toadd" />
	<section class="main">
	<div class="tit">
		<span>Agregar producto</span>
	</div>
	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		
	

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%">



				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.nombre" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="nombre" maxlength="80" onkeyup="this.value=this.value.toUpperCase()"></html:text> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.presentacion" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="presentacion" maxlength="80"></html:text> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.codigo" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="codigo" maxlength="30"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.invima" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="invima" maxlength="30"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.iva" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="iva" maxlength="13"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
					<td class="formulario"><bean:message key="producto.field.valorunit" /></td>
					<td width="5"></td>
					<td><html:hidden styleClass="selText" property="valorunit" value="0"></html:hidden></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" >
					<td class="formulario"><bean:message key="producto.field.valor" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="valor" maxlength="13"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.precioventa" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="precioventa" maxlength="13"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.sobre" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="sobre" maxlength="5" value="1"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.cantidadmin" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="cantidadmin" maxlength="11"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.idlaboratorio" /></td>
					<td width="5"></td>
					<td><html:select property="idlaboratorio" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="labLista" labelProperty="nombre" property="idlaboratorio" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.idcategoria" /></td>
					<td width="5"></td>
					<td><html:select property="idcategoria" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="catLista" labelProperty="nombre" property="idcategoria" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.idcategoriad" /></td>
					<td width="5"></td>
					<td><html:select property="idcategoriad" styleClass="sel">
						<html:option value="0">Seleccione</html:option>
						<html:options collection="catLista" labelProperty="nombre" property="idcategoria" />
					</html:select> <span class="requerido">&nbsp;* &nbsp;</span></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.idfamilia" /></td>
					<td width="5"></td>
					<td><html:hidden property="idfamilia" name="productoForm"></html:hidden> 
						<input type="hidden" class="selText" name="campofamilia" id="campofamilia" readonly="readonly" value="<bean:write property="idfamilia" name="productoForm"/>"> 
						<input type="text" class="selText" name="descfamilia" id="descfamilia" readonly="readonly" value="<bean:write property="famdesc" name="productoForm"/>" size="50">
						<IMG src="<%=request.getContextPath()%>/images/lupa.gif"
						onclick=" window.open('<%=request.getContextPath()%>/Familia.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')"
						style="cursor: hand;">  <span class="requerido">&nbsp;* &nbsp;</span></td>

				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.comentarios" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="comentarios" maxlength="500" size="100"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.indicaciones" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="indicaciones" maxlength="500" size="100"></html:text></td>
				</tr>
				
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="producto.field.caja" /></td>
					<td width="5"></td>
					<td><html:select property="caja" styleClass="sel">
						<html:option value="0">NO</html:option>
						<html:option value="1">SI</html:option>
						</html:select>
					</td>
				</tr>
				</tr>

				<tr>
					<td colspan="3">
					<table align="center" width="80%">
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
							<td class="titulos" colspan="7" style="text-align: center;"><bean:message key="provprod.title" /></td>
						</tr>
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
							<td>&nbsp;</td>
							<td style="text-align: center;"><bean:message key="provprod.field.idprovprod" /></td>
							<td>&nbsp;</td>
							<td style="text-align: center;"><bean:message key="provprod.field.valor" /></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
							<td>&nbsp;</td>
							<td style="text-align: center;"><html:select property="idproveedor" styleClass="sel">
								<html:options collection="provLista" labelProperty="nombre" property="idproveedor" />
							</html:select></td>
							<td>&nbsp;</td>
							<td style="text-align: center;"><html:text property="valorprovprod" styleClass="selText" maxlength="11"></html:text></td>
							<td>&nbsp;</td>
							<td style="text-align: center;"><html:button property="agrega" styleClass="boton" onclick="agregarPP(this.form);">+</html:button></td>
							<td>&nbsp;</td>
						</tr>
						<logic:notEmpty name="provprodLista" scope="session">
							<logic:iterate indexId="ind" id="provprod" name="provprodLista" type="com.farmacia.domain.Provprod">
								<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
									<td>&nbsp;</td>
									<td style="text-align: center;"><bean:write name="provprod" property="provdesc" /></td>
									<td>&nbsp;</td>
									<td style="text-align: center;">$<bean:write name="provprod" property="valor" format="#,##0.00" /></td>
									<td>&nbsp;</td>
									<td style="text-align: center;"><input type="button" class="boton" property="agrega" styleClass="boton"
										onclick="borrarPP(this.form,'<bean:write name="provprod" property="idproveedor"/>');" value="-"></td>
									<td>&nbsp;</td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
					</table>
					</td>
				</tr>



				<tr>
					<td class="formulario" colspan="3" align="center"><span class="requerido"> <bean:message key="campos.requeridos" /> </span></td>
				</tr>				
			</table>
			<div class="row">
					<div class="contBtnFo">
						<html:button styleClass="boton" onclick="enviar(this.form)" property="Agregar">
						<bean:message key="label.global.agregar" />
					</html:button>
					</div>
				</div>
			</td>
		</tr>
	</table>
	</section>
</html:form>
