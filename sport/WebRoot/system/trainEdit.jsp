

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path=request.getContextPath();
 %>

<html>
  <head>
   <title>培训管理</title>
   <LINK href="<%=path%>/css/Style.css" type="text/css" rel="stylesheet">
   <script language="javascript" src="<%=path%>/script/function.js"></script>
    <script type="text/javascript" src="<%=path%>/script/validate.js"></script>
   <script type="text/javascript" language="JavaScript" src="<%=path%>/script/calendar.js" charset="gb2312"></script>
   <Script language="javascript">

	function check_null(){
	
		var theForm=document.Form1;
		alert("修改成功");
	   document.Form1.action="<%=path%>/trainAction?action_flag=saveupdate";
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
		 <font face="宋体" size="2"><strong>编辑培训信息</strong></font>
		</td>
    </tr>
       <input name="trainid"  type="hidden" value="${edittrain.id}">
       
     <tr>
         <td align="center" bgColor="#f5fafe" class="ta_01">培&nbsp;&nbsp;训&nbsp;&nbsp;号：
         <td class="ta_01" bgColor="#ffffff">
         <input name="trainnum" type="text" maxlength="25" id="trainnum"  value="${edittrain.trainnum}"  size=20 readonly>
          <font color="#FF0000">*</font></td>
         <td align="center" bgColor="#f5fafe" class="ta_01">培训名称：</td>
         <td class="ta_01" bgColor="#ffffff"><input name="trainname" type="text" value="${edittrain.trainname}" maxlength="25"  size=22>
        </td>
    </tr>
	<tr>
	
	
	<td align="center" bgColor="#f5fafe" class="ta_01">培训校区：</td>
	<td class="ta_01" bgColor="#ffffff">
	<select name="trainId" style="width:155px">
	
	<c:if test="${editsys!=null}">
	<c:forEach items="${editsys}" var="edsys">
	<option value="${edsys.ddlcode}" selected>${edsys.ddlname}</option>
	</c:forEach>
	</c:if>
	</select></td>
	<td align="center" bgColor="#f5fafe" class="ta_01">培训地点：</td>
	<td class="ta_01" bgColor="#ffffff"><input name="trainaddress" type="text" value="${edittrain.trainaddress}" maxlength="25"  size=22 >
	</td>
	</tr>
	<tr>
	<td align="center" bgColor="#f5fafe" class="ta_01">培训教师：</td>
	<td class="ta_01" bgColor="#ffffff"><input name="trainteacher" type="text" value="${edittrain.trainteacher}" maxlength="25"  size=22>
	</td>
	<td align="center" bgColor="#f5fafe" class="ta_01">培训时间：</td>
	<td class="ta_01" bgColor="#ffffff"><input name="traintime" type="text" value="${edittrain.traintime}" maxlength="25" size=22 onclick="JavaScript:calendar(document.Form1.traintime)">
	</td>
	</tr>
	
	<TR>
	<TD class="ta_01" align="center" bgColor="#f5fafe">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</TD>
	<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea name="remark"  style="WIDTH:92%;"  rows="4" cols="52">${edittrain.remark}</textarea></TD>
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
