<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>注册用户详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  注册用户详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${zhuceyonghu.yonghuming}</td><td  rowspan=11 align=center><a href=${zhuceyonghu.touxiang} target=_blank><img src=${zhuceyonghu.touxiang} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${zhuceyonghu.mima}</td></tr><tr><td width='11%' height=44>昵称：</td><td width='39%'>${zhuceyonghu.cheng}</td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${zhuceyonghu.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${zhuceyonghu.xingbie}</td></tr><tr><td width='11%' height=44>生日：</td><td width='39%'>${zhuceyonghu.shengri}</td></tr><tr><td width='11%' height=44>星座：</td><td width='39%'>${zhuceyonghu.xingzuo}</td></tr><tr><td width='11%' height=44>身份证：</td><td width='39%'>${zhuceyonghu.shenfenzheng}</td></tr><tr><td width='11%' height=44>手机：</td><td width='39%'>${zhuceyonghu.shouji}</td></tr><tr><td width='11%' height=44>个性签名：</td><td width='39%'>${zhuceyonghu.gexingqianming}</td></tr><tr><td width='11%' height=44>爱好：</td><td width='39%'>${zhuceyonghu.aihao}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

