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
<html>

<head>
<title>--SISTEMA DE GESTION DE FARMACIAS--</title>
<STYLE type="text/css">
head {
   color:#ffffff;
   display: none;
}
.head {
   color:#ffffff;
   display: none;
}
</STYLE>
<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">
</head>

		<table border="0" cellpadding="0" cellspacing="3" width=100% align="center" class="recibo">
		<tr >
			<td align="center" colspan="4"><b>POLICLINICO 20 DE JULIO LIMITADA</b></td>
		</tr>
		<tr >
			<td align="center" colspan="4"><b>FARMACIA</b></td>
		</tr>
		<tr >
			<td align="center" colspan="4">NIT: 900160179-1 <br>
		</tr>
		<logic:present name="ventaForm" property="codigo">
		<logic:notEqual value="0" name="ventaForm" property="codigo">
		<tr >
			<td align="right" colspan="4" style="padding-right: 30px">
				<bean:message key="titulo.factura" /> <bean:write name="ventaForm" property="codigo" format="#########0"/>
				</td>
		</tr>
			
		</logic:notEqual>
		</logic:present>

		<tr >
			<td align="center" colspan="4">

				Cl 27 Sur #5-55 <br>
				Barrio 20 de Julio<br>
				Tel: 2395839 - 4074144
			</td>
		</tr>
		<tr >
            <td align="center" colspan="4">---------------------------</td>
		</tr>
		<logic:notEmpty name="DETVENTAS" scope="session">

			<logic:iterate indexId="ind" id="detventa" name="DETVENTAS"
								type="com.farmacia.domain.Detventa">
			
				<tr colspan="4">
					<td align="left">
						<bean:write name="detventa" property="nombreProducto"	scope="page" /> Cant: <bean:write name="detventa" property="cantidad"	scope="page" />
					</td>
				</tr>
				<tr colspan="4">

					<td align="right"><bean:write name="detventa" property="valorunit"	format="#,##0" scope="page" /> - <bean:write name="detventa" property="valor" format="#,##0" scope="page" /></td>
				</tr>
			
			</logic:iterate>

		</logic:notEmpty>
		<tr >
            <td align="right" colspan="4"><bean:message key="venta.field.valortotal" /> : 
            $<bean:write name="ventaForm" property="valortotalNum" format="#,##0"/></td>
		</tr>
		<tr >
            <td align="center" colspan="4">---------------------------</td>
		</tr>
		<logic:present name="ventaForm" property="codigo">
		<logic:notEqual value="0" name="ventaForm" property="codigo">
		<tr >
			<td align="center" colspan="4" >Resolución DIAN N. 320000785962</td>
		</tr>
			
		</logic:notEqual>
		</logic:present>
		
		<tr>
	        <td  align="center" colspan="4">Fecha:
	        <bean:write name="ventaForm" property="fechaFormated"/> 
				<br><br> 
				GRACIAS POR SU COMPRA !!! <br> 
				 </td>
		</tr>
		<tr >
			<td align="center" colspan="4">---------------------------</td>
		</tr>
		
	</table>
<script type="text/javascript">
	
	if(confirm('Desea imprimir el recibo?')){
	print();
	}
	
</script>
</html>