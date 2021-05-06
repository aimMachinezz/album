<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shipinxinxihsgb" scope="page" class="com.bean.ShipinxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shipinxinxi.xls");
%>
<html>
  <head>
    <title>视频信息</title>
  </head>

  <body >
 <%
			String sql="select * from shipinxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>    <td align='center' bgcolor='#ebf0f7'>视频标题</td>    <td align='center' bgcolor='#ebf0f7'>视频类型</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>图片</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>视频</td>        <td align='center' bgcolor='#ebf0f7'>个人签名</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>发布日期</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shipinxinxihsgb.getAllShipinxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shipinbiaoti}</td>    <td>${u.shipinleixing}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='play.jsp?spwj=${u.shipin}' target='_blank'>点此播放</a></td>        <td>${u.gerenqianming}</td>    <td>${u.faburiqi}</td>    <td>${u.faburen}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shipinxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

