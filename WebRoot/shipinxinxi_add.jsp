﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加视频信息</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="shipinxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addShipinxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加视频信息</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">视频标题：</td><td><input name='shipinbiaoti' type='text' id='shipinbiaoti' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshipinbiaoti' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">视频类型：</td><td><input name='shipinleixing' type='text' id='shipinleixing' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div></td></tr>		<tr ><td width="200">视频：</td><td><input name='shipin' type='text' id='shipin' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('shipin')"/></div></td></tr>		<tr ><td width="200">简述：</td><td><textarea name='jianshu' cols='50' rows='5' id='jianshu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">个人签名：</td><td><input name='gerenqianming' type='text' id='gerenqianming' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		<tr ><td width="200">发布日期：</td><td><input name='faburiqi' type='text' id='faburiqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shipinbiaotiobj = document.getElementById("shipinbiaoti"); if(shipinbiaotiobj.value==""){document.getElementById("clabelshipinbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入视频标题</font>";return false;}else{document.getElementById("clabelshipinbiaoti").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>