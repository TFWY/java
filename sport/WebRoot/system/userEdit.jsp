

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path=request.getContextPath();
 %>


<html>
  <head>
   <title>编辑用户</title>
   <LINK href="<%=path%>/css/Style.css" type="text/css" rel="stylesheet">
   <script language="javascript" src="<%=path%>/script/function.js"></script>
    <script type="text/javascript" src="<%=path%>/script/validate.js"></script>
   <script type="text/javascript" language="JavaScript" src="<%=path%>/script/calendar.js" charset="gb2312"></script>
   <Script language="javascript">

	function check_null(){
	
		var theForm=document.Form1;
		alert("修改成功");
	   document.Form1.action="<%=path%>/userAction?action_flag=saveupdate";
	   document.Form1.submit();
	   refreshOpener();
	  	
	}
	
</script>
</head>

  
 <body>
    <form name="Form1" method="post">	
    <br>
    
    <table cellSpacing="1" cellPadding="5" width="90%" align="center" bgColor="#eeeeee" style="border:1px solid #8ba7e3" border="0">

	 <tr>
		<td class="ta_01" align="center" colSpan="4" background="<%=path%>/images/b-info.gif">
		 <font face="宋体" size="2"><strong>编辑用户</strong></font>
		</td>
    </tr>
       <input name="upId"  type="hidden" value="${edituser.id}">
     <tr>
         <td align="center" bgColor="#f5fafe" class="ta_01">用&nbsp;&nbsp;户&nbsp;&nbsp;名：
         <td class="ta_01" bgColor="#ffffff">
         <input name="username" type="text" maxlength="25" id="username"  value="${edituser.username}"  size=20 readonly>
          <font color="#FF0000">*</font></td>
         <td align="center" bgColor="#f5fafe" class="ta_01">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
         <td class="ta_01" bgColor="#ffffff"><input name="password" type="password" value="${edituser.password}" maxlength="25"  size=22>
        </td>
    </tr>
<tr>


<td align="center" bgColor="#f5fafe" class="ta_01">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
<td class="ta_01" bgColor="#ffffff">
<select name="sexId" style="width:155px">
<option value=""></option>
<c:if test="${editsys!=null}">
<c:forEach items="${editsys}" var="edsys">
<option value="${edsys.ddlcode}" selected>${edsys.ddlname}</option>
</c:forEach>
</c:if>
</select></td>
<td align="center" bgColor="#f5fafe" class="ta_01">生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
<td class="ta_01" bgColor="#ffffff"><input name="brithday" type="text" value="${edituser.brithday}" maxlength="25"  size=22 onclick="JavaScript:calendar(document.Form1.brithday)">
</td>
</tr>
<tr>
<td align="center" bgColor="#f5fafe" class="ta_01">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
<td class="ta_01" bgColor="#ffffff"><input name="phone" type="text" value="${edituser.phone}" maxlength="25"  size=22>
</td>
<td align="center" bgColor="#f5fafe" class="ta_01">邮箱：</td>
<td class="ta_01" bgColor="#ffffff"><input name="email" type="text" value="${edituser.email}" maxlength="25" size=22>
</td>
</tr>

<TR>
<TD class="ta_01" align="center" bgColor="#f5fafe">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</TD>
<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea name="remark"  style="WIDTH:92%;"  rows="4" cols="52">${edituser.remark}</textarea></TD>
</TR>
<TR>
<td  align="center"  colSpan="4"  class="sep1"></td>
</TR>
<tr>
	<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
	<input type="button" name="BT_Submit" value="保存"  style="font-size:12px; color:black; height=22;width=55"  onClick="check_null()">
	 <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
	  
	   <input style="font-size:12px; color:black; height=22;width=55" type="button" value="关闭"  name="Reset1"  onClick="window.close()">
      
	</td>
</tr>
</table>　
</form>

</body>
</html>
