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


<html:form target="_self" action="/Venta.do">
	<script type="text/javascript">
	function registraVenta(forma)
	{
		if(confirm('Esta seguro de registrar la venta')){
			if(forma.campocliente.value!=''){
				document.getElementsByName('idcliente')[0].value=forma.campocliente.value
			}
			if(forma.campousuario.value!=''){
				document.getElementsByName('idmedico')[0].value=forma.campousuario.value
			}
			document.getElementsByName('idproducto')[0].value=forma.campoproducto.value
			forma.method.value='registrarVenta';
			forma.submit();
		}
		window.open('<%=request.getContextPath()%>/venta/recibo.jsp','popup','width=400,height=650,scrollbars=yes,resizable=yes,menubar=yes')
	}
	function agregarDet(forma){
		if(forma.campocliente.value!=''){
			document.getElementsByName('idcliente')[0].value=forma.campocliente.value
		}
		if(forma.campousuario.value!=''){
			document.getElementsByName('idmedico')[0].value=forma.campousuario.value
		}
		document.getElementsByName('idproducto')[0].value=forma.campoproducto.value
		forma.method.value='agregarDet';
		forma.submit();
	}
	function borrarDet(forma,index){
		document.getElementsByName('regdel')[0].value=index
		forma.method.value='borrarDet';
		forma.submit();
	}
	
	function sumarCant(){
		var cant = document.getElementsByName('cantidad')[0].value
		var valorunit = document.getElementsByName('valorunit')[0].value
		var valorunitsobre = document.getElementsByName('valorunitsobre')[0].value
		var presentacion = document.getElementsByName('presentacion')[0].value
		var valor = 0
		if(presentacion=='1'){
			valor = cant * valorunit
			if(valorunit == 0){
				alert("El producto no se vende por cajas");
				}
		}
		if(presentacion=='2'){
			valor = cant * valorunitsobre
			if(valorunitsobre == 0){
				alert("El producto no se vende por sobres");
				}
		}

		document.getElementsByName('valor')[0].value = valor
	}
	
	function enviarBarcode(){
		var barcode = document.getElementsByName('barcode')[0].value
	 	eval("window.open('<%=request.getContextPath()%>/Producto.do?method=listPopupBarcode&venta=venta&barcode="+ barcode + "','popup','width=700,height=550,scrollbars=yes,resizable')");
	}
</script>
	<html:hidden property="strutsAction" />
	<html:hidden property="strutsOrderby" />
	<input type="hidden" id="method" name="method" />
	<input type="hidden" id="regdel" name="regdel" />
	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos"><bean:message key="venta.title.add" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%">

				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.fecha" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selText" property="fecha" maxlength="9" readonly="true"></html:text>&nbsp; 
						<html:text styleClass="selText"	property="hora" maxlength="7" readonly="readonly"></html:text>
						<html:hidden property="codigo"></html:hidden> <html:hidden property="idfarmacia"></html:hidden> <html:hidden property="idusuario"></html:hidden>
						</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.valortotal" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="valortotal" maxlength="13" readonly="true"></html:text>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.iva" /></td>
					<td width="5"></td>
					<td><html:text styleClass="selNum" property="iva" maxlength="13" readonly="true"></html:text></td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.idcliente" /></td>
					<td width="5"></td>
					<td>
						<html:hidden property="idcliente"></html:hidden> 
						<input type="hidden" name="campocliente" id="campocliente"> 
						<html:text property="desccliente" readonly="true" styleClass="selText"></html:text>
						<IMG src="<%=request.getContextPath()%>/images/lupa.gif"
						onclick=" window.open('<%=request.getContextPath()%>/Cliente.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')"
						style="cursor: hand;"> 
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.idmedico" /></td>
					<td width="5"></td>
					<td>
						<html:hidden property="idmedico"></html:hidden> 
						<input type="hidden" name="campousuario" id="campousuario">
						<html:text property="descusuario" readonly="true" styleClass="selText"></html:text>
						<IMG src="<%=request.getContextPath()%>/images/lupa.gif" 
						onclick=" window.open('<%=request.getContextPath()%>/Usuario.do?method=listPopup&perfil=medico','popup','width=550,height=450,scrollbars=yes,resizable')"	style="cursor: hand;"> 
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario"><bean:message key="venta.field.marca1" /></td>
					<td width="5"></td>
					<td>
					   <html:checkbox property="marca1" value="1" />
					</td>
				</tr>

			</table>
			</td>
		</tr>
	</table>

	<table border="0" cellpadding="0" cellspacing="0" width=90% align="center">
		<tr width="90%">
			<td align="center" class="titulos"><bean:message key="detventa.title.add" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%">


				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" >
					<td class="formulario" style="text-align: center;">&nbsp;</td>
					<td class="formulario" style="text-align: center;"><bean:message key="detventa.field.idproducto" /></td>
					<td class="formulario" style="text-align: center;"><bean:message key="detventa.field.cantidad" /></td>
					<td class="formulario" style="text-align: center;"><bean:message key="producto.field.precioventa" /></td>
					<td class="formulario" style="text-align: center;"><bean:message key="producto.field.valor" /></td>
					<td class="formulario" style="text-align: center;"><bean:message key="detventa.field.valor" /></td>
					<td class="formulario" style="text-align: center;"><bean:message key="detventa.field.dias" /></td>
					<td>&nbsp;</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					<td class="formulario" style="text-align: center;">&nbsp;</td>
					<td align="center"><html:hidden property="idproducto" value="0"></html:hidden> 
						<input type="text" class="selText" name="descproducto" id="descproducto" readonly="readonly">
						<input type="hidden" class="selText" name="campoproducto" id="campoproducto"> 
						<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Producto.do?method=listPopup&venta=venta','popup','width=700,height=550,scrollbars=yes,resizable')" style="cursor: hand;"><br> 
						<input type="text" class="selText" name="barcode" id="barcode" maxlength="20">
						<IMG src="<%=request.getContextPath()%>/images/barcode.png" height="24" width="24" onclick="enviarBarcode();" style="cursor: hand;"> 
						</td>
					<td align="center">
						<html:text styleClass="selNum" property="cantidad" maxlength="11" onblur="sumarCant();" onchange="sumarCant();"  size="5"></html:text>
						&nbsp;
						<html:select styleClass="selText"  property="presentacion" onchange="sumarCant();">
						<html:option value="1">CAJAS</html:option>
						<html:option value="2">SOBRES</html:option>
						</html:select>
					</td>
					<td align="center">
						<html:text styleClass="selNum" property="valorunit" maxlength="13" readonly="true"></html:text>
					</td>
					<td align="center">
						<html:text styleClass="selNum" property="valorunitsobre" maxlength="13" readonly="true"></html:text>
					</td>
					
					<td align="center"><html:text styleClass="selNum" property="valor" maxlength="13"></html:text></td>
					<td align="center"><html:text styleClass="selNum" property="dias" maxlength="13" size="5"></html:text></td>
					<td align="center">
					<html:hidden property="iddetventa"></html:hidden>
					<html:text property="ivadet"></html:text>
					<html:button styleClass="boton"	property="addDetail" onclick="agregarDet(this.form);">
						<bean:message key="label.global.agregardet" />
					</html:button>
					</td>

				</tr>

				<logic:notEmpty name="DETVENTAS" scope="session">
				<logic:iterate indexId="ind" id="detventa" name="DETVENTAS"	type="com.farmacia.domain.Detventa">
					<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
					    <td align="center"><html:checkbox name="detventa" property="marca" value="1" indexed="true" /></td>
						<td align="center"><bean:write name="detventa" property="nombreProducto" scope="page" /></td>
						<td align="right"><bean:write name="detventa" property="cantidad" scope="page"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td colspan="2" align="right">$<bean:write name="detventa" property="valorunit" scope="page" format="#,##0.00"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td align="right">$<bean:write name="detventa" property="valor"	scope="page" format="#,##0.00"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td align="right"><bean:write name="detventa" property="dias"	scope="page"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td align="center"><html:button styleClass="boton"	property="delDetail" onclick="borrarDet(this.form,'${ind}');">
						<bean:message key="label.global.deldet" />
					</html:button></td>
					</tr>
				</logic:iterate>
				</logic:notEmpty>
		
				<tr align="center" class="titulos">
					<td colspan="8"><html:button styleClass="boton" property="regSale" onclick="registraVenta(this.form);">
						<bean:message key="label.global.registrarventa" />
					</html:button></td>
				</tr>
				
			</table>
			</td>
		</tr>
	</table>

</html:form>
