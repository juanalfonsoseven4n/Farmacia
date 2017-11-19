<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> Barra de Menu </title>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/menu.js"></script>
<!-- Please see http://www.brainjar.com for terms of use. -->
</head>
<body>


<!-- Menu bar. -->
<div class="menuBar" style="width:80%;">
<a class="menuButton" href="" onclick="return buttonClick(event, 'paramMenu');" onmouseover="buttonMouseover(event, 'fileMenu');">Par&aacute;metros</a>
<a class="menuButton" href="" onclick="return buttonClick(event, 'adminMenu');" onmouseover="buttonMouseover(event, 'editMenu');">Administración</a>
<a class="menuButton" href="" onclick="return buttonClick(event, 'pendMenu');" onmouseover="buttonMouseover(event, 'viewMenu');">Pendientes</a>
<a class="menuButton" href="" onclick="return buttonClick(event, 'consMenu');" onmouseover="buttonMouseover(event, 'toolsMenu');">Consultas</a>
</div>

<!-- Main menus. -->

<div id="paramMenu" class="menu" onmouseover="menuMouseover(event)">
	<a class="menuItem" href="area.do">Áreas</a>
	<a class="menuItem" href="pais.do">País</a>
	<a class="menuItem" href="tareaGeneral.do">Tareas Generales</a>
	<a class="menuItem" href="usuario.do">Usuarios</a>
	<a class="menuItem" href="tarea.do">Tareas</a>
</div>

<div id="adminMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="lanzamiento.do">Lanzamientos</a>
<a class="menuItem" href="proceso.do">Procesos</a>
</div>

<div id="pendMenu" class="menu">
<a class="menuItem" href="index.do">Tareas Pendientes</a>
</div>

<div id="consMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="index.do">Consultas Lanzamientos</a>
</div>


</body>
</html>