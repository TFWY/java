<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=path%>/css/buttonstyle.css" type="text/css" rel="stylesheet">
<LINK href="<%=path%>/css/MainPage.css" type="text/css" rel="stylesheet">
<script type='text/javascript' src='<%=path%>/script/pub.js'></script>
<script type="text/javascript" src='<%=path%>/script/validate.js'></script>
<SCRIPT type="text/javascript">
function ini(){
   document.all.name.focus();
}
function check(){
    var theForm = document.forms[0];
    if(!checkNull(theForm.username))
		{
			alert("请输入用户名");
			theForm.username.focus(); 
			return false;
		} 
	if(Trim(theForm.username.value)==""){
			alert("请输入用户名");
			theForm.username.focus();
			return false;
	    }
}
</SCRIPT>
<STYLE type=text/css>
BODY { margin: 0px; }
FORM {
	MARGIN: 0px; BACKGROUND-COLOR: #ffffff
} 
</STYLE>
<title>体育场馆管理系统</title>
</head>
<body onload="ini()">
<form action="<%=path %>/loginAction" method="post" onsubmit="return check();">
<table border="0" width="100%" id="table1" height="532" cellspacing="0" cellpadding="0" >
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td height="467">
		<table border="0" width="1024" id="table2" height="415" cellspacing="0" cellpadding="0" >
		
			<tr>
				<td width=12%></td>
				<td align=center background="<%=path%>/images/index.jpg">
				<table border="0" width="98%" id="table3" height="412" cellspacing="0" cellpadding="0">
					<tr height=122>
						<td colspan=2></td>
					</tr>
					<tr>
						<td height="313" width="73%"></td>
						<td height="99" width="27%">
							<table border="0" width="70%" id="table4">
								<tr>
									<td width="100"><img border="0" src="<%=path%>/images/yonghu.gif" width="84" height="20"></td>
									<td><input type="text" name="username" style="width: 100 px" value=""  maxlength="25"></td>
								</tr>
								<tr>
									<td width="100"><img border="0" src="<%=path%>/images/mima.gif" width="84" height="20"></td>
									<td><input type="password" name="password" style="width: 100 px" value=""  maxlength="25"></td>
									
								</tr>
								<tr>
									<td width="100"></td>
									<td width="100"><input type="submit" class=btn_mouseout onmouseover="this.className='btn_mouseover'" onmouseout="this.className='btn_mouseout'" value="登   录" name="huifubtn"></td>

								</tr>
							</table>
						</td>
					</tr>
					
					</table>
				</td>
				<td width=13%></td>
			</tr>
			<tr>
		      <td align="center" colspan=3>&nbsp;</td>
	        </tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
