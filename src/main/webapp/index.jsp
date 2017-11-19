
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
<meta charset="UTF-8">
<title>--SISTEMA DE GESTION DE FARMACIAS--</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/responsive.css" rel="stylesheet" type="text/css">
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/scheme1.css" type="text/css">
<link href="<%=request.getContextPath()%>/styles/diseno.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700" rel="stylesheet"> 
</head>

<body>
	<section class="login">
		<div class="left">
		  <div class="brand">
				<div class="imgBrand"><img src="images/logo.png" alt=""/></div>
				<div class="contBrand">
					<h1>MediWeb</h1>
					<p>Encuentra los mejores productos y lleva su control para que tus pacientes disfruten de todos los beneficios.</p>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="formLog">			
				<html:form action="/Usuario.do">
					<html:hidden property="method" value="validar"/>
					<p>Ingresa tu nombre de usuario y contraseña para acceder a todos los servicios</p>
					<input type="text" name="descripcion" id="descripcion" placeholder="Usuario">
					<input type="password" name="password" id="password" placeholder="Contraseña">
					<div class="btnLog"><a href="#" onclick="document.forms[0].submit();">Ingresar</a></div>
					<p class="pRojo"><B><c:out value="${requestScope.userInvalid}"></c:out></B>&nbsp;</p>
				</html:form>
			</div>
		</div>
	</section>
</body>
</html>
