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

<meta http-equiv="Cache-Control" content="no-cache"/>
<!--<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>-->
	<link href="<%=request.getContextPath()%>/images/favicon.ico" rel="SHORTCUT ICON"/>
    <LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" type="text/css">
	<LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/scheme1.css" type="text/css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/menu.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/funciones.js"></script>
	<LINK rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/calendar-blue.css" title="winter">
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendar-stripped.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendar-en.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendarnew.js"></SCRIPT>
	<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">
<STYLE type="text/css">
#head {
   color:#ffffff;
}
</STYLE>
</head>

<body bgcolor="#ffffff" leftmargin="0" marginwidth="0" topmargin="0"
	marginheight="0">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/tooltip/wz_tooltip.js"></script>
<table border="0" cellpadding="0" cellspacing="0" width="100%"
	height="100%">


	<!-- Header -->
	<tr>
		<td height="90" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top" align="left" ><img
					src="<%=request.getContextPath()%>/images/medicamentos.jpg" width="180" 
					height="89" border="0"></td>
				<td valign="middle" align="center" >
				<img
					src="<%=request.getContextPath()%>/images/Titulo.JPG"  border="0"></td>
				<td valign="top" align="right" ><img
					src="<%=request.getContextPath()%>/images/farmacia.jpg" width="180" 
					height="89" border="0"></td>
				<td valign="middle" width="30"><img
					src="<%=request.getContextPath()%>/images/pixel.gif" width="30"
					height="90" border="0"></td>
				<td valign="top" width="150">
				<table border="0" cellpadding="0" cellspacing="0" width="150"
					height="89">
					<tr>
						<td bgcolor="3F7F7F" valign="top"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>


		</td>
	</tr>
	<!-- End Header -->

	<!-- Band -->
	<tr>
		<td height="12" bgcolor="#3F7F7F"></td>
	</tr>
	<!-- End Band -->
	<!-- Navigation area -->
	<tr>
		<td height="25" class="menuBar" style="width:100%;">

		<div class="menuBar" style="width:99%;">
			<table width="100%">
			<tr>
				<td align="left" width="80%">
					<c:choose>
						<c:when test="${menusIni != null}">
							<c:forEach var="menu" items="${menusIni}" varStatus="status">
								<a class="menuButton" href="" onclick="return buttonClick(event, 'param${status.count}');"
								onmouseover="buttonMouseover(event, 'param${status.count}');">${menu.titulo}</a>
							</c:forEach>
						</c:when>
						<c:otherwise><span class="requerido"><B><bean:message key="errors.sessionInvalid"/></B></span></c:otherwise>
					</c:choose>
					
				</td>
				<td align="right" width="20%">
					<a	class="menuButton" href="" ><img src="<%=request.getContextPath()%>/images/home.gif" alt="Cerrar Sesión" style="border: 0; cursor: hand"></a>
					<a	class="menuButton"  ><img src="<%=request.getContextPath()%>/images/print.gif" onClick="JavaScript:print()" alt="Imprimir" style="border: 0; cursor: hand" ></a>
				</td>
			</tr>
			</table>
		</div>

		<!-- Main menus. -->
		<c:forEach var="menu" items="${menusIni}" varStatus="status">
			<div id="param${status.count}" class="menu" onmouseover="menuMouseover(event)" >
				<c:forEach var="opcion" items="${menu.opciones}" varStatus="statusOP">
						<a class="menuItem" href="${opcion.linkopcion}">${opcion.titulo}</a>
				</c:forEach> 
			</div>
		</c:forEach>
		</td>
		
	</tr>
	<!-- End Navigation area -->






	<tr>
		<td height="1" class="shade7"><img
			src="<%=request.getContextPath()%>/images/pixel.gif" width="100%"
			height="1" border="0"></td>
	</tr>
	<tr>
		<td height="10" class="grey1"><img
			src="<%=request.getContextPath()%>/images/pixel.gif" width="100%"
			height="10" border="0"></td>
	</tr>

	<!-- Contents -->
	<tr>
		<td valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="100%"
			height="100%">
			<tr>
				<td width="10" class="grey1"><img
					src="<%=request.getContextPath()%>/images/pixel.gif" width="10"
					height="20" border="0"></td>
				<td class="grey1" valign="top">
					<comp:insert attribute='body' />
				</td>
				<td width="10" class="grey1">
				<img
					src="<%=request.getContextPath()%>/images/pixel.gif" width="10"
					height="100%" border="0"></td>
			</tr>
		</table>
		</td>
	</tr>
	
	<!-- End Contents -->

	<!-- Footer -->
	<tr height="20">
		<td height="20" bgcolor="#3F7F7F"><img
			src="<%=request.getContextPath()%>/images/pixel.gif" width="30"
			height="20" border="0"> 
			
			<logic:messagesPresent>
			    <div class="fondo_error">
			        <html:messages id="error">
			            ${error}<br/>
			        </html:messages>
			    </div>
			</logic:messagesPresent>
			
			<%-- Success Messages --%>
			<logic:messagesPresent message="true">
			    <div class="fondo_mensaje" >
			        <html:messages id="message" message="true">
			            <b>${message}<br/></b>
			        </html:messages>
			    </div>
			</logic:messagesPresent>
		

	</tr>
	<!-- End Footer -->

</table>
</body>

</html>
