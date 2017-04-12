
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
	    alert("修改成功");
		 document.Form1.action="<%=path%>/guildAction?action_flag=editadd";
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
		 <font face="宋体" size="2"><strong>修改指南</strong></font>
		 <input type="hidden" name="id" value="${guild.id}">
		</td>
    </tr>
    <tr>
    	 <td align="center" bgColor="#f5fafe" class="ta_01">指南名称：<font color="#FF0000">*</font></td>
         <td class="ta_01" bgColor="#ffffff"><input name="guildname" type="text" maxlength="25" id="guildname" size="20" value="${guild.guildname}">
         </td>


	<td align="center" bgColor="#f5fafe" class="ta_01">是否发布：</td>
	
	<td class="ta_01" bgColor="#ffffff">
	<select name="guildis" style="width:155px">
	<option value="alljct"></option>
	<c:if test="${sys!=null}">
	<c:forEach items="${sys}" var="sys">
	<option value="${sys.ddlcode}">${sys.ddlname}</option>
	</c:forEach>
	</c:if>
	</select></td>
	</tr>
	    
<tr>
<td align="center" bgColor="#f5fafe" class="ta_01">发布时期：</td>
<td class="ta_01" bgColor="#ffffff"><input name="guildtime" type="text" maxlength="50"  size="20" value="${guild.guildtime}" onclick="JavaScript:calendar(document.Form1.guildtime)" >
</td>

<td align="center" bgColor="#f5fafe" class="ta_01">发布内容&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</td>
<td class="ta_01" bgColor="#ffffff"><input name="guildcommon" type="text" maxlength="25"  size=22 value="${guild.guildcommon}">
</td>
</tr>
<tr>
<td align="center" bgColor="#f5fafe" class="ta_01">备注：</td>
<td class="ta_01" bgColor="#ffffff" colSpan="3"><textarea name="guildremark"  style="WIDTH:92%;"  rows="4" cols="52">${guild.guildremark}</textarea>
</td>
</tr>
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