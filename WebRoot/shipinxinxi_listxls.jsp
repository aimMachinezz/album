<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shipinxinxihsgb" scope="page" class="com.bean.ShipinxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shipinxinxi.xls");
%>
<html>
  <head>
    <title>��Ƶ��Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from shipinxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>���</td>    <td align='center' bgcolor='#ebf0f7'>��Ƶ����</td>    <td align='center' bgcolor='#ebf0f7'>��Ƶ����</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>ͼƬ</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>��Ƶ</td>        <td align='center' bgcolor='#ebf0f7'>����ǩ��</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>��������</td>    <td align='center' bgcolor='#ebf0f7'>������</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=shipinxinxihsgb.getAllShipinxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shipinbiaoti}</td>    <td>${u.shipinleixing}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='play.jsp?spwj=${u.shipin}' target='_blank'>��˲���</a></td>        <td>${u.gerenqianming}</td>    <td>${u.faburiqi}</td>    <td>${u.faburen}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shipinxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

