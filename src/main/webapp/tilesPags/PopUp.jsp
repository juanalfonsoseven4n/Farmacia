<%@ page contentType="text/html; charset=iso-8859-1" %>
<%@ page language="java" errorPage="/error.jsp" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean-el" prefix="bean-el" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html-el" prefix="html-el" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic-el" prefix="logic-el" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tiles.tld" prefix="comp"%>

<html>
	<head>
	<title>--SISTEMA DE GESTION DE FARMACIAS--</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
   <!-- <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>-->
    <link href="<%=request.getContextPath()%>/styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/images/favicon.ico" rel="SHORTCUT ICON"/>
   	<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/funciones.js"></script>
    <!-- HTML & Design contributed by Boer Attila (http://www.calcium.ro) -->
    <!-- Found at http://www.csszengarden.com/?cssfile=/083/083.css&page=2 -->
	<LINK rel="stylesheet" href="<%=request.getContextPath()%>/css/scheme1.css" type="text/css">
	</head>
	<body>
		<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center">
			<tr>
				<td valign="top">
					<comp:insert attribute='body' />
					<!-- End Right -->
				</td>
			</tr>
		</table>
	</body>
</html>