<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhuceyonghuhsgb" scope="page" class="com.bean.ZhuceyonghuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhuceyonghu.xls");
%>
<html>
  <head>
    <title>ע���û�</title>
  </head>

  <body >
 <%
			String sql="select * from zhuceyonghu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>�û���</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>�ǳ�</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>�Ա�</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>ͷ��</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>���֤</td>    <td align='center' bgcolor='#ebf0f7'>�ֻ�</td>    <td align='center' bgcolor='#ebf0f7'>����ǩ��</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=zhuceyonghuhsgb.getAllZhuceyonghu(15);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.cheng}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.touxiang}' target='_blank'><img src='${u.touxiang}' width=88 height=99 border=0 /></a></td>    <td>${u.shengri}</td>    <td>${u.xingzuo}</td>    <td>${u.shenfenzheng}</td>    <td>${u.shouji}</td>    <td>${u.gexingqianming}</td>    <td>${u.aihao}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=zhuceyonghu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

