<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台左侧导航</title>
<link rel="stylesheet" type="text/css" href="images/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><head></head>
<body id="bg">
	<div class="container">
		<div class="leftsidebar_box"><div class="line"><img src="images/coin01.png" />&nbsp;&nbsp;首页</div>
			
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 系统用户管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="allusersList.do" target="hsgmain">管理员用户</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="mod.jsp" target="hsgmain">修改密码</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 注册用户管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="zhuceyonghuList.do" target="hsgmain">注册用户查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>

<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 新闻数据管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhi_add.jsp?lb=站内新闻" target="hsgmain">站内新闻添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhiList.do?lb=站内新闻" target="hsgmain">站内新闻查询</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhi_add.jsp?lb=公告通知" target="hsgmain">公告通知添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhiList.do?lb=公告通知" target="hsgmain">公告通知查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>

<!--<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 用户注册管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="yonghuzhuceList.do" target="hsgmain">用户注册管理</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>

<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 友情连接管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="youqinglianjie_add.jsp" target="hsgmain">友情连接添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="youqinglianjieList.do" target="hsgmain">友情连接查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 变幻图管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhi_add.jsp?lb=变幻图" target="hsgmain">变幻图添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xinwentongzhiList.do?lb=变幻图" target="hsgmain">变幻图查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>-->
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 相册信息管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xiangcexinxiList.do" target="hsgmain">相信息册查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 视频信息管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shipinxinxiList.do" target="hsgmain">视频信息查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>


<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 留言信息管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="liuyanbanList.do" target="hsgmain">留言信息管理</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 系统信息设置<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="dx.jsp?lb=系统简介" target="hsgmain">系统简介设置</a><img class="icon5" src="images/coin21.png" />
				</dd>
<!--<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="dx.jsp?lb=关于我们" target="hsgmain">关于我们设置</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="dx.jsp?lb=联系方式" target="hsgmain">联系方式设置</a><img class="icon5" src="images/coin21.png" />
				</dd>
-->
			</dl>
			
		</div>
	</div>
</body>
</html>