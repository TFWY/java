
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path=request.getContextPath();
 %>

<html>
  <head>
   <title>添加用户</title>
   <LINK href="<%=path%>/css/Style.css" type="text/css" rel="stylesheet">
   <script language="javascript" src="<%=path%>/script/function.js"></script>
   <script type="text/javascript" language="JavaScript" src="<%=path%>/script/calendar.js" charset="gb2312"></script>
   <script type="text/javascript" src="<%=path%>/script/validate.js"></script>
<Script language="javascript">

	function check_null(){
	    //alert(11);
	    var theForm=document.Form1;
	    
	    if(theForm.username.value=="")
		{
			alert("用户名不能为空");
			theForm.username.focus();
			return false;
		}
	    if(Trim(theForm.password.value)=="")
		{
			alert("密码不能为空");
			theForm.password.focus();
			return false;
		}
		alert("保存成功");
		 document.Form1.action="<%=path%>/userAction?action_flag=add";
		 document.Form1.submit();	
		 refreshOpener();
	}
	
   </script>
  </head>
  
 <body>
 
  <form name="Form1" method="post">
 <br>
    <table cellSpacing="1" cellPadding="5" width="580" align="center" bgColor="#eeeeee" style="border:1px solid #8ba7e3" border="0">

    <tr>
		<td class="ta_01" align="center" colSpan="4" background="<%=path%>/images/b-info.gif">
		 <font face="宋体" size="2"><strong>添加用户</strong></font>
		</td>
    </tr>
     <tr>
         <td align="center" bgColor="#f5fafe" class="ta_01">用户名：<font color="#FF0000">*</font></td>
         <td class="ta_01" bgColor="#ffffff"><input name="username" type="text" maxlength="25" id="username" size="20">
          </td>
         <td width="18%" align="center" bgColor="#f5fafe" class="ta_01">密&nbsp;&nbsp;码：<font color="#FF0000">*</font></td>
         <td class="ta_01" bgColor="#ffffff"><input name="password" type="password" maxlength="25" id="password" size="20"> 
          </td>
    </tr>
<tr>

<td align="center" bgColor="#f5fafe" class="ta_01">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>

<td class="ta_01" bgColor="#ffffff">
<select name="sexId" style="width:155px">
<option value="alljct"></option>
<c:if test="${sexlist!=null}">
<c:forEach items="${sexlist}" var="sys">
<option value="${sys.ddlcode}">${sys.ddlname}</option>
</c:forEach>
</c:if>
</select></td>

<td align="center" bgColor="#f5fafe" class="ta_01">生日：</td>
<td class="ta_01" bgColor="#ffffff"><input name="birthday" type="text" maxlength="50"  size="20" onclick="JavaScript:calendar(document.Form1.birthday)" >
</td>

</tr>
<tr>
<td align="center" bgColor="#f5fafe" class="ta_01">电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</td>
<td class="ta_01" bgColor="#ffffff"><input name="phone" type="text" maxlength="25"  size=22>
</td>
<td align="center" bgColor="#f5fafe" class="ta_01">邮箱：</td>
<td class="ta_01" bgColor="#ffffff"><input name="email" type="text" maxlength="25"  size=22>
</td>
</tr>

<TR>
<TD class="ta_01" align="center" bgColor="#f5fafe">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</TD>
<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea name="remark"  style="WIDTH:95%"  rows="4" cols="52"></textarea></TD>
</TR>
<TR>
<td  align="center"  colSpan="4"  class="sep1"></td>
</TR>
<tr>
	<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
	<input type="button" name="BT_Submit" value="保存"  style="font-size:12px; color:black; height=22;width=55"   onClick="javascript:check_null();">
	 <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
	<input style="font-size:12px; color:black; height=22;width=55"  type="button" value="关闭"  name="Reset1"  onClick="window.close()">
		
	</td>
</tr>
</table>　
</form>

</body>
</html>
