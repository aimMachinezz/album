<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>视频信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  视频信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${shipinxinxi.bianhao}</td><td  rowspan=7 align=center><a href=${shipinxinxi.tupian} target=_blank><img src=${shipinxinxi.tupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>视频标题：</td><td width='39%'>${shipinxinxi.shipinbiaoti}</td></tr><tr><td width='11%' height=44>视频类型：</td><td width='39%'>${shipinxinxi.shipinleixing}</td></tr><tr><td width='11%' height=44>视频：</td><td width='39%'><a href="play.jsp?spwj=${shipinxinxi.shipin}">点此播放</a></td></tr><tr><td width='11%' height=44>个人签名：</td><td width='39%'>${shipinxinxi.gerenqianming}</td></tr><tr><td width='11%' height=44>发布日期：</td><td width='39%'>${shipinxinxi.faburiqi}</td></tr><tr><td width='11%' height=44>发布人：</td><td width='39%'>${shipinxinxi.faburen}</td></tr><tr><td width='11%' height=100  >简述：</td><td width='39%' colspan=2 height=100 >${shipinxinxi.jianshu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

