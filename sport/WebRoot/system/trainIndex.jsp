
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.sixth.sport.utils.PageBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path=request.getContextPath();
PageBean pageBean=(PageBean)request.getAttribute("pageBean");
 %>
 
<HTML>
	<HEAD>
		<title>培训信息</title>		
		<LINK href="<%=path%>/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="<%=path%>/script/function.js"></script>
		
		<script language="javascript"> 
		
function delByIds()
{
var th= document.Form1;
if(getSelectCount()<1)
{
alert("至少要选择一个选项");
return;
}
if( !confirm("你确定删除吗?")) return false;
th.action="<%=path%>/trainAction?action_flag=dels&ids="+getSelectValue();
th.submit();
}

function getSelectCount()
{
	   var count = 0;
	   var ids = document.getElementsByName("ids");
	   for(var i=0;i<ids.length;i++){
	      if(ids[i].checked){
	        count++;
	      }
	   }
	   return count;
}

function getSelectValue()
{
	   var str="";
	    var idss = document.getElementsByName("ids");
	     for(var i=0;i<idss.length;i++){
	       if(idss[i].checked==true){
	        str+=idss[i].value+",";
	       }
	    }
	    return str.substring(0,str.length-1);
}
		
  function checkchar(){
  //alert(11);
  	document.Form1.action="<%=path%>/trainAction?action_flag=show";
  	document.Form1.submit();
  }
  //首页
  function first()
  {
  
  document.Form2.action="<%=path%>/trainAction?action_flag=show&pageNum=1";
  document.Form2.submit();
  }
    //上一页
  function forwrad2()
  {
  
  document.Form2.action="<%=path%>/trainAction?action_flag=show&pageNum=<%=pageBean.getCurrentPage()-1%>";
  document.Form2.submit();
  }
   //下一页
  function next()
  {
  
  document.Form2.action="<%=path%>/trainAction?action_flag=show&pageNum=<%=pageBean.getCurrentPage()+1%>";
  document.Form2.submit();
  }
  
 
  
   //尾页
  function end()
  {
  
  document.Form2.action="<%=path%>/trainAction?action_flag=show&pageNum=<%=pageBean.getPageCount()%>";
  document.Form2.submit();
  }
  
  </script>
	</HEAD>
		
	<body >
		<form id="Form1" name="Form1" method="post" style="margin:0px;"> 
			<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
				<TR height=10><td></td></TR>
				<tr>
					<td class="ta_01" colspan=2 align="center" background="../images/b-info.gif">
						<font face="楷体" size="4"><strong>培训信息管理</strong></font>
					</td>
					
				</tr>
				<tr>
					<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">
					培训号：</td>
					<td class="ta_01" >
					<input name="trainnum" type="text" id="trainnum"  size="21"><font face="楷体" color="red">
					</font></td>
				</tr>
		    </table>	
		</form>




		<form id="Form2" name="Form2" method="post">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<TR height=10><td></td></TR>			
				<tr>
				  	<td>
		                <TABLE style="WIDTH: 105px; HEIGHT: 20px" border="0">
										<TR>
											<TD align="center" background="<%=path%>/images/cotNavGround.gif"><img src="<%=path%>/images/yin.gif" width="15"></TD>
											<TD class="DropShadow" background="<%=path%>/images/cotNavGround.gif">信息列表</TD>
										</TR>
			             </TABLE>
                   </td>
					<td class="ta_01" align="right">
						<input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="批量删除" name="BT_find" 
						onclick="javascript:delByIds()">&nbsp;&nbsp;
					    <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="查询" name="BT_find" 
						 onclick="javascript:checkchar()">&nbsp;&nbsp;
						<input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="添加信息" name="BT_Add" 
						 onclick="openWindow('<%=path%>/trainAction?action_flag=showadd','700','400')">
					</td>
				</tr>
					
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe" colspan=3>			
					
									
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#fefafe; WORD-WRAP:break-word">
							<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#f5fafe">
								<td align="center" width="5%" height=22 background="<%=path%>/images/tablehead.jpg">选择</td>
								<td align="center" width="15%" height=22 background="<%=path%>/images/tablehead.jpg">培训号</td>
								<td align="center" width="15%" height=22 background="<%=path%>/images/tablehead.jpg">培训名称</td>
								<td align="center" width="10%" height=22 background="<%=path%>/images/tablehead.jpg">培训教师</td>
								<td align="center" width="10%" height=22 background="<%=path%>/images/tablehead.jpg">培训校区</td>
								<td align="center" width="10%" height=22 background="<%=path%>/images/tablehead.jpg">培训地点</td>
								<td align="center" width="10%" height=22 background="<%=path%>/images/tablehead.jpg">培训时间</td>
								<td align="center" width="15%" height=22 background="<%=path%>/images/tablehead.jpg">备注</td>
								<td width="5%" align="center" height=22 background="<%=path%>/images/tablehead.jpg">编辑</td>
								<td width="5%" align="center" height=22 background="<%=path%>/images/tablehead.jpg">删除</td>
							</tr>
							
							
								<c:if test="${trains!=null}">
								<c:forEach items="${trains}" var="train">
									<tr onmouseover="this.style.backgroundColor = '#f5fafe'" onmouseout="this.style.backgroundColor = '#f5fafe';">
										<TD height="28" align="center" valign="top" noWrap><input name="ids" type="checkbox" class="text2"value="
										${train.id}">
										</TD>
										<td style="HEIGHT:22px" align="center" width="15%">
											${train.trainnum}
										</td>
										<td style="HEIGHT:22px" align="center" width="15%">
											${train.trainname}
										</td>
										<td style="HEIGHT:22px" align="center" width="10%">
											${train.trainteacher}
										</td>
										<td style="HEIGHT:22px" align="center" width="10%">
											${train.trainSchool}
										</td>									
										<td style="HEIGHT:22px" align="center" width="10%">
											${train.trainaddress}
										</td>
										<td style="HEIGHT:22px" align="center" width="10%">
											${train.traintime}
										</td>
										<td style="HEIGHT:22px" align="center" width="15%">
											${train.remark}
										</td>
										<td align="center" style="HEIGHT: 22px" align="center" width="5%">																	
										   <a href="#" onclick="openWindow('<%=path%>/trainAction?action_flag=edit&editId=${train.id}','700','400');">
										   <img src="<%=path%>/images/edit.gif" border="0" style="CURSOR:hand"></a>													
										</td>
										
										<td align="center" style="HEIGHT: 22px" align="center" width="5%">
											<a href="<%=path%>/trainAction?action_flag=del&delId=${train.id}" onclick="return confirm('你确定要删除吗？')">
											<img src="<%=path%>/images/delete.gif" width="16" height="16" border="0" style="CURSOR:hand"></a>												
										</td>
									</tr>
									</c:forEach>
									</c:if>
						</table>					
						<table width="100%" border=1 cellpadding=4 cellspacing=1
												bgcolor=#f5fafe>
												<!--DWLayoutTable-->
												<tbody>
													<tr bgcolor=#ffffff height=20>
														<td height="20" align="center" valign="middle" nowrap>
															<span class="STYLE7">共<%=pageBean.getPageCount() %>页</span>&nbsp;
															<a href="javascript:first();" class="dh2">首页</a>&nbsp;
															<a href="javascript:forwrad2();" class="dh2">上一页</a>&nbsp;
															<a href="javascript:next();" class="dh2">下一页</a>&nbsp;
															<a href="javascript:end();" class="dh2">尾页</a>&nbsp;
														</td>
													</tr>
												</tbody>
											</table>
					</td>
				</tr>        
			</TBODY>
		</table>
		</form>




	</body>
</HTML>
