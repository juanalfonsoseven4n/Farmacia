<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-nested" prefix="nested"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<%=request.getContextPath()%>/styles/diseno.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath() %>/styles/includes/menu.js"></script>

<div id="cssmenu">
<ul>
   <li><a href="#">Item 1</a></li>
   <li class="active"><a href="#">item 2</a>
      <ul>
         <li><a href="#">Item 1 dentro</a>
            <ul>
               <li><a href="#">Sub item</a></li>
               <li><a href="#">Sub item 2</a></li>
            </ul>
         </li>
         <li><a href="#">Item 2 dentro</a>
            <ul>
               <li><a href="#">Sub item</a></li>
               <li><a href="#">Sub item 2</a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href="#">Item 3</a></li>
   <li><a href="#">Item 4</a></li>
</ul>
</div>


<table width="100%" border="0">
	<tr>
		<td align="left" valign="top" bgcolor="#0000CC" width="200"><!--menu--> <!-- Contenido del Menu -->
		<div id="pageContent"><!-- START OF PANE CODE -->
		<div id="dhtmlgoodies_xpPane">
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Inventario.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Usper.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Detventa.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Farmacia.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Movimiento.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Proveedor.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Gasto.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Cliente.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Usuario.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Venta.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Opcper.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Perfil.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Producto.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Opcion.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				<div class="dhtmlgoodies_panel">
		<div><!-- Start content of pane -->
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><a href="/Farmacia/Familia.do?method=list" target="text"><bean:message key="label.global.listar" /></a></td>
			</tr>
		</table>
		<!-- End content --></div>
		</div>
				
		
		<script type="text/javascript">
initDhtmlgoodies_xpPane(Array(
'<bean:message key="inventario.title" />', '<bean:message key="usper.title" />', '<bean:message key="detventa.title" />', '<bean:message key="farmacia.title" />', '<bean:message key="movimiento.title" />', '<bean:message key="proveedor.title" />', '<bean:message key="gasto.title" />', '<bean:message key="cliente.title" />', '<bean:message key="usuario.title" />', '<bean:message key="venta.title" />', '<bean:message key="opcper.title" />', '<bean:message key="perfil.title" />', '<bean:message key="producto.title" />', '<bean:message key="opcion.title" />', '<bean:message key="familia.title" />'),Array(true,true,false),Array(
'pane1', 'pane2', 'pane3', 'pane4', 'pane5', 'pane6', 'pane7', 'pane8', 'pane9', 'pane10', 'pane11', 'pane12', 'pane13', 'pane14', 'pane15'));
</script>
		</div>
		</div>
		</td>
	</tr>
</table>
<!-- END OF PANE CONTENT -->
<!--fin del menu -->
