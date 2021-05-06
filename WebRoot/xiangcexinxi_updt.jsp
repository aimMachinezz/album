<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改相册信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="xiangcexinxi_add.jsp?id=<%=id%>";
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
			<form action="updateXiangcexinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改相册信息<input type="hidden" name="id" value="${xiangcexinxi.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">相册标题：</td><td><input name='xiangcebiaoti' type='text' id='xiangcebiaoti' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxiangcebiaoti' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">相册类型：</td><td><input name='xiangceleixing' type='text' id='xiangceleixing' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">相册封面：</td><td><input name='xiangcefengmian' type='text' id='xiangcefengmian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('xiangcefengmian')"/></div></td></tr>		<tr ><td width="200">文件：</td><td><input name='wenjian' type='text' id='wenjian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('wenjian')"/></div></td></tr>		<tr ><td width="200">图片数量：</td><td><input name='tupianshuliang' type='text' id='tupianshuliang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeltupianshuliang' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">简述：</td><td><textarea name='jianshu' cols='50' rows='5' id='jianshu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">个性签名：</td><td><input name='gexingqianming' type='text' id='gexingqianming' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		<tr ><td width="200">发布日期：</td><td><input name='faburiqi' type='text' id='faburiqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>		<tr 0><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${xiangcexinxi.bianhao}';</script>	<script language="javascript">document.form1.xiangcebiaoti.value='${xiangcexinxi.xiangcebiaoti}';</script>	<script language="javascript">document.form1.xiangceleixing.value='${xiangcexinxi.xiangceleixing}';</script>	<script language="javascript">document.form1.xiangcefengmian.value='${xiangcexinxi.xiangcefengmian}';</script>	<script language="javascript">document.form1.wenjian.value='${xiangcexinxi.wenjian}';</script>	<script language="javascript">document.form1.tupianshuliang.value='${xiangcexinxi.tupianshuliang}';</script>	<script language="javascript">document.form1.jianshu.value='${xiangcexinxi.jianshu}';</script>	<script language="javascript">document.form1.gexingqianming.value='${xiangcexinxi.gexingqianming}';</script>	<script language="javascript">document.form1.faburiqi.value='${xiangcexinxi.faburiqi}';</script>	<script language="javascript">document.form1.faburen.value='${xiangcexinxi.faburen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xiangcebiaotiobj = document.getElementById("xiangcebiaoti"); if(xiangcebiaotiobj.value==""){document.getElementById("clabelxiangcebiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入相册标题</font>";return false;}else{document.getElementById("clabelxiangcebiaoti").innerHTML="  "; } 	    


return true;   
}   
popheight=450;
</script>  
