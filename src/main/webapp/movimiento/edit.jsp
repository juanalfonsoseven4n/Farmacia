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


<html:form target="_self" action="/Movimiento.do?method=saveEdit">
<script type="text/javascript">
	function enviar(forma)
	{
		document.getElementsByName('idproducto')[0].value=forma.campoproducto.value
	//	document.getElementsByName('idinventario')[0].value=forma.campoinventario
	//	document.getElementsByName('idfarmacia')[0].value=forma.campofarmacia
	//	document.getElementsByName('idusuario')[0].value=forma.campousuario
				//forma.action=valor;
			forma.submit();
	}
	function actualizaPrecioUnit(forma)
	{	
		try{
			forma.precio.value =Number(forma.preciocosto.value)/Number(forma.cantidad.value); 		
		}catch(err){
			alert('Dato invalido '+err)
		}

	}
	function actualizaPrecioCosto(forma)
	{	
		try{
			forma.preciocosto.value =Number(forma.precio.value)*Number(forma.cantidad.value); 		
		}catch(err){
			alert('Dato invalido '+err)
		}

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
				key="movimiento.title.edit" /></td>
		</tr>

		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" >
				
				
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.idmovimiento" /></td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="idmovimiento" readonly="true" maxlength="11"></html:text>
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
						
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.fecha" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:text styleClass="selText"    property="fecha" size="10" maxlength="10" onfocus="this.select()" 
					   onblur="this.value=this.value.toUpperCase()" readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fecha', 'y/mm/dd');">
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.fechaexp" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:text styleClass="selText"    property="fechaexp" size="10" maxlength="10" onfocus="this.select()" 
					   onblur="this.value=this.value.toUpperCase()" readonly="true"/>&nbsp;<IMG src="<%=request.getContextPath()%>/images/calendario.gif"
				   alt="Obtener Fecha" onclick="return showCalendar('fechaexp', 'y/mm/dd');">
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
						<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.hora" />
                    
                    </td>
					<td width="5"></td>
					<td >
						<html:select styleClass="selText"  property="horas">
						<html:option value="1">1 am</html:option>
						<html:option value="2">2 am</html:option>
						<html:option value="3">3 am</html:option>
						<html:option value="4">4 am</html:option>
						<html:option value="5">5 am</html:option>
						<html:option value="6">6 am</html:option>
						<html:option value="7">7 am</html:option>
						<html:option value="8">8 am</html:option>
						<html:option value="9">9 am</html:option>
						<html:option value="10">10 am</html:option>
						<html:option value="11">11 am</html:option>
						<html:option value="12">12 m</html:option>
						<html:option value="13">1 pm</html:option>
						<html:option value="14">2 pm</html:option>
						<html:option value="15">3 pm</html:option>
						<html:option value="16">4 pm</html:option>
						<html:option value="17">5 pm</html:option>
						<html:option value="18">6 pm</html:option>
						<html:option value="19">7 pm</html:option>
						<html:option value="20">8 pm</html:option>
						<html:option value="21">9 pm</html:option>
						<html:option value="22">10 pm</html:option>
						<html:option value="23">11 pm</html:option>
						<html:option value="24">0 am</html:option>																																				
					</html:select>
					<html:select styleClass="selText"  property="minutos">
						<html:option value="00">00</html:option>
						<html:option value="05">05</html:option>
						<html:option value="10">10</html:option>
						<html:option value="15">15</html:option>
						<html:option value="20">20</html:option>
						<html:option value="25">25</html:option>
						<html:option value="30">30</html:option>
						<html:option value="35">35</html:option>
						<html:option value="40">40</html:option>
						<html:option value="45">45</html:option>
						<html:option value="50">50</html:option>
						<html:option value="55">55</html:option>
					</html:select>
					
										</td>
				</tr>
							
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.idproducto" />
                    
                    </td>
					<td width="5"></td>
					<td >
							<html:hidden property="idproducto" ></html:hidden>
					<input alt="Seleccione un Producto" type="text" class="selText"  name="descproducto" id="descproducto" readonly="readonly" value="<bean:write property="proddesc" name="movimientoForm"/>"/>			
					<input type="hidden" name="campoproducto" id="campoproducto" readonly="readonly" value="<bean:write property="idproducto" name="movimientoForm"/>"/>
					<IMG alt="Seleccione un Producto" src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Producto.do?method=listPopup','popup','width=800,height=550,scrollbars=yes,resizable')" style="cursor: hand;">
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" id="presentaciones" style="display: none;">
                    <td class="formulario" colspan="3" style="text-align: center;">
                    El precio de venta del producto seleccionado es: &nbsp; &nbsp; &nbsp;
                    <input type="text" class="selinvn"  name="preccajas" id="preccajas" readonly="readonly" value="0" size="6" /> &nbsp; CAJAS &nbsp; &nbsp; &nbsp;
                    <input type="text" class="selinvn"  name="precsobres" id="precsobres" readonly="readonly" value="0" size="6"/> &nbsp; SOBRES
  					<br>
  					Viene en cajas de
  					<input type="text" class="selinvn"  name="sobres" id="sobres" readonly="readonly" value="0" size="2"/> &nbsp; &nbsp; Sobres
                    </td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.cantidad" />
                    
                    </td>
					<td width="5"></td>
					<td >
						<html:text styleClass="selNum"  property="cantidad" maxlength="11"></html:text>
						&nbsp;
						<html:select styleClass="selText"  property="valor">
						<html:option value="1">CAJAS</html:option>
						<html:option value="2">SOBRES</html:option>
						</html:select>
					</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.precio" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selNum"  property="precio" maxlength="13" onblur="actualizaPrecioCosto(this.form);"></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.preciocosto" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selNum"  property="preciocosto" maxlength="13" onblur="actualizaPrecioUnit(this.form);"></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
                    <td class="formulario"><bean:message key="movimiento.field.valor" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="valor" maxlength="13" value="0"  ></html:text>
										</td>
				</tr>
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.tipo" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:select styleClass="selText"  property="tipo">
					<html:option value="1">ENTRADA</html:option>
					<html:option value="2">SALIDA</html:option>
					</html:select>
					
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
				
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.codigo" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="codigo" maxlength="300" size="100"></html:text>
					</td>
				</tr>			
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.lote" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="lote" maxlength="50" size="20"></html:text>
					</td>
				</tr>	
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.codigofac" />
                    
                    </td>
					<td width="5"></td>
					<td ><html:text styleClass="selText"  property="codigofac" maxlength="50" size="20"></html:text>
					</td>
				</tr>			
				
		
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
		 <td class="formulario"><bean:message key="movimiento.field.idfarmacia" /></td>
					<td width="5"></td>
					<td ><html:hidden property="idfarmacia" value="0"></html:hidden>
					<input type="text" class="selText"  name="campofarmacia" id="campofarmacia" readonly="readonly" >
					<IMG src="<%=request.getContextPath()%>/images/lupa.gif" onclick=" window.open('<%=request.getContextPath()%>/Farmacia.do?method=listPopup','popup','width=550,height=450,scrollbars=yes,resizable')" style="cursor: hand;">
					<input type="text" class="selText"  name="descfarmacia" id="descfarmacia" readonly="readonly">
					</td>
									</tr>
			<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'" style="display: none;">
		 <td class="formulario"><bean:message key="movimiento.field.idusuario" /></td>
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
				<tr class="navoff" onmouseover="className='navon'" onmouseout="className='navoff'">
                    <td class="formulario"><bean:message key="movimiento.field.vendido" />
                    
                    </td>
					<td width="5"></td>
					<td >
					<html:select styleClass="selText"  property="vendido">
					<html:option value="0">EN INVENTARIO</html:option>
					<html:option value="1">VENDIDO</html:option>
					</html:select>
					
					<span class="requerido">&nbsp;*  &nbsp;</span>					</td>
				</tr>
				<tr  align="center" class="titulos">
					<td colspan="3" ><html:button styleClass="boton" onclick="enviar(this.form);"
						property="Editar" >
						<bean:message key="label.global.editar" />
					</html:button>
						<input type="button" class="boton"
						id="Regresar" onclick="cambioAction(this.form,'<%=request.getContextPath()%>/Movimiento.do?method=list');" 
						value="<bean:message key="label.global.regresar" />"	>
					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
</html:form>
