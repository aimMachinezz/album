<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>��Ƶ��Ϣ</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'��������',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>��Ƶ��Ϣ</h3>
            </div>
          
		
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>��ţ�</td><td width='39%'>${shipinxinxi.bianhao}</td><td  rowspan=7 align=center><a href=${shipinxinxi.tupian} target=_blank><img src=${shipinxinxi.tupian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>��Ƶ���⣺</td><td width='39%'>${shipinxinxi.shipinbiaoti}</td></tr><tr>         <td width='11%' height=44>��Ƶ���ͣ�</td><td width='39%'>${shipinxinxi.shipinleixing}</td></tr><tr>                  <td width='11%' height=44>��Ƶ��</td><td width='39%'><a href="play.jsp?spwj=${shipinxinxi.shipin}">��˲���</a></td></tr><tr>                  <td width='11%' height=44>����ǩ����</td><td width='39%'>${shipinxinxi.gerenqianming}</td></tr><tr>         <td width='11%' height=44>�������ڣ�</td><td width='39%'>${shipinxinxi.faburiqi}</td></tr><tr>         <td width='11%' height=44>�����ˣ�</td><td width='39%'>${shipinxinxi.faburen}</td></tr><tr>         <td width='11%' height=100  >������</td><td width='39%' colspan=2 height=100 >${shipinxinxi.faburen}</td></tr><tr>							 
                                <td colspan="3"><table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
                                  <tr>
                                    <td width="30" align="center" bgcolor="CCFFFF">���</td>
                                    <td width="471" bgcolor='#CCFFFF'>��������</td>
                                    <td width="88" bgcolor='#CCFFFF'>����</td>
                                    <td width="88" bgcolor='#CCFFFF'>������</td>
                                    <td width="138" align="center" bgcolor="CCFFFF">����ʱ��</td>
                                  </tr>
								  <%@page import="com.util.db"%>
                                   <%
								   int pli=0;
    for(HashMap map:new db().getpinglun("shipinxinxi",id)){
	pli=pli+1;
     %>
                                   <tr>
                                    <td width="30" align="center" bgcolor='#CCFF99'><%=pli%></td>
                                    <td width="471" bgcolor='#CCFF99'><%=map.get("pinglunneirong") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pingfen") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pinglunren") %></td>
                                    <td width="138" align="center" bgcolor="CCFF99"><%=map.get("addtime") %></td>
                                  </tr>
                                  <%
								 
								  }
								   %>
                                </table></td>
                                </tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" /><input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()" /> <!--jixaaxnnxiu--><input type=button name=Submit53 value=���� onClick="javascript:hsgpinglun('shipinxinxi','<%=id%>')"/><input type=button name=Submit52 value=�ղ� onClick="javascript:location.href='jrsc.jsp?id=<%=id%>&biaoj=spxx&biao=shipinxinxi&ziduan=shipinbiaoti';" /></td></tr>
    
  </table>
						  
        </div>
    </section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
  
</body> 
</html>

