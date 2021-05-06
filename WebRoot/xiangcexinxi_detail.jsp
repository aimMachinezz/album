<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>相册信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  相册信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${xiangcexinxi.bianhao}</td><td  rowspan=8 align=center><a href=${xiangcexinxi.xiangcefengmian} target=_blank><img src=${xiangcexinxi.xiangcefengmian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>相册标题：</td><td width='39%'>${xiangcexinxi.xiangcebiaoti}</td></tr><tr><td width='11%' height=44>相册类型：</td><td width='39%'>${xiangcexinxi.xiangceleixing}</td></tr><tr><td width='11%' height=44>文件：</td><td width='39%'><a href="${xiangcexinxi.wenjian}">点此下载</a></td></tr><tr><td width='11%' height=44>图片数量：</td><td width='39%'>${xiangcexinxi.tupianshuliang}</td></tr><tr><td width='11%' height=44>个性签名：</td><td width='39%'>${xiangcexinxi.gexingqianming}</td></tr><tr><td width='11%' height=44>发布日期：</td><td width='39%'>${xiangcexinxi.faburiqi}</td></tr><tr><td width='11%' height=44>发布人：</td><td width='39%'>${xiangcexinxi.faburen}</td></tr><tr><td width='11%' height=100  >简述：</td><td width='39%' colspan=2 height=100 >${xiangcexinxi.jianshu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

