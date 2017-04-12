<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<HTML>
<HEAD>
<TITLE>体育场馆管理首页</TITLE>
<LINK href="/css/Font.css" type="text/css" rel="stylesheet">

<STYLE>BODY {
	SCROLLBAR-ARROW-COLOR: #ffffff; SCROLLBAR-BASE-COLOR: #dee3f7
}
</STYLE>

<SCRIPT type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}

function exitsys(){
    window.close();   
 }
</SCRIPT>
</HEAD>

<FRAMESET border=0 frameSpacing=0 rows=82,* frameBorder=0 id="mainparent">
<FRAME name=topFrame src="<%=path %>/menu/title.jsp" noResize scrolling=no>
<FRAMESET name="main" border=0 frameSpacing=0 frameBorder=0 cols=143,1%,*>
<FRAME name="leftFrame" src="<%=path %>/menu/left.jsp" noResize>
<frame name="changeButton" src="<%=path %>/menu/change1.jsp" frameBorder=0 marginHeight=0 marginWidth=0 scrolling=no noresize>
<FRAME name="mainFrame" src="<%=path %>/menu/loading.jsp" >
</FRAMESET>
</FRAMESET>


</HTML>
