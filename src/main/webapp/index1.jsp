

 <%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html> 
<HEAD>
<TITLE>PLANTILLA</TITLE>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">

</HEAD>
<SCRIPT>
	function oP(){
	ww = Math.round((screen.width)-10);
	hh = Math.round((screen.height)-60);
	top.resizeTo(ww,hh);
	top.moveTo(5,5); //src="a3.htm"
	}
</SCRIPT>

<FRAMESET border=0 frameSpacing=0 rows="40,1*" frameBorder="no" cols=* onload="oP()">
	<FRAME name=heading marginWidth=0 marginHeight=0 src="<html:rewrite page="/header.jsp"/>" noResize scrolling=no>
	<frameset rows="1*,20" frameborder="NO" border="0" framespacing="0">
		<FRAMESET border=0 frameSpacing=0 rows=* frameBorder=0 cols="210,1*">
			<FRAME name="menu" marginWidth=10 marginHeight=5 src="<html:rewrite page="/menu/menu.jsp"/>" frameBorder=0 noResize >
			<FRAME name="text" marginWidth=10 marginHeight=5 src="<html:rewrite page="/main.jsp"/>" >
		</FRAMESET>
	</frameset>
	<NOFRAMES>
	<p>The <code>NOFRAMES</code> element is to be used to give useful content to people with browsers that cannot display frames. One example is Lynx, a text-based browser.</p></NOFRAMES>
</FRAMESET>
<body>

</body>
</html:html>