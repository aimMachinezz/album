<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiangcexinxihsgb" scope="page" class="com.bean.XiangcexinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiangcexinxi.xls");
%>
<html>
  <head>
    <title>相册信息</title>
  </head>

  <body >
 <%
			String sql="select * from xiangcexinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>    <td align='center' bgcolor='#ebf0f7'>相册标题</td>    <td align='center' bgcolor='#ebf0f7'>相册类型</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>相册封面</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>文件</td>    <td align='center' bgcolor='#ebf0f7'>图片数量</td>        <td align='center' bgcolor='#ebf0f7'>个性签名</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>发布日期</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiangcexinxihsgb.getAllXiangcexinxi(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.xiangcebiaoti}</td>    <td>${u.xiangceleixing}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.xiangcefengmian}' target='_blank'><img src='${u.xiangcefengmian}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='${u.wenjian}' target='_blank'>下载</a></td>    <td>${u.tupianshuliang}</td>        <td>${u.gexingqianming}</td>    <td>${u.faburiqi}</td>    <td>${u.faburen}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=xiangcexinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

