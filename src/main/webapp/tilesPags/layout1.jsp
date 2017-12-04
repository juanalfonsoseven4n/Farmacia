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
    <LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/scheme1.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700" rel="stylesheet"> 
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/responsive.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/internas.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/funciones.js"></script>
	<LINK rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/calendar-blue.css" title="winter">
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendar-stripped.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendar-en.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/calendarnew.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/script.js"></SCRIPT>
	<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">
<STYLE type="text/css">
#head {
   color:#ffffff;
}
</STYLE>
</head>

<body>
<header>
<div class="brandCont">
	<div class="logo"><a href="#">
		<div class="imgLogo"><img src="images/logo.png" alt=""/></div>
		<div class="txt">MediWeb - Policlínico 20 de Julio Ltda.</div>
	</a></div>
	<div class="rightCont">
		<div class="name">
			<div class="texto"><c:out value="${sessionScope.USRLGN}" escapeXml="false" /></div>
			<div class="ima"><img src="images/img_log.png" alt=""/></div>
		</div>
		<div class="btnCont"><a href="#" onClick="JavaScript:print()" alt="Imprimir" >Imprimir</a></div>
		<div class="btnCont"><a href="Usuario.do?method=cerrar"">Cerrar sesión</a></div>
	</div>
</div>	
<div id="cssmenu">
	<ul>
		<c:choose>
			<c:when test="${menusIni != null}">
				<c:forEach var="menu" items="${menusIni}" varStatus="status">
				<li><a href="#">${menu.titulo}</a>
					<ul>
						<c:forEach var="opcion" items="${menu.opciones}" varStatus="statusOP">
							 <li><a href="${opcion.linkopcion}">${opcion.titulo}</a></li>
						</c:forEach> 
					</ul>
	         	</li>
				</c:forEach>
			</c:when>
			<c:otherwise><li><span class="requerido"><B><bean:message key="errors.sessionInvalid"/></B></span></li></c:otherwise>
		</c:choose>   
	</ul>
</div>

</header>

<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>

	<!-- Contents -->
	
		
					<comp:insert attribute='body' />
			
		
	<!-- End Contents -->

	<!-- Footer -->
	<table border="0" cellpadding="0" cellspacing="0" width="100%" >
	<tr>
		<td height="10" bgcolor="#3F7F7F">
			
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
	</table>
	<!-- End Footer -->


</body>

</html>
