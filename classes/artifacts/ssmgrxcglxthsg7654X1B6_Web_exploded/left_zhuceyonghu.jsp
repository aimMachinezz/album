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
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 个人资料管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="zhuceyonghuList2.do" target="hsgmain">修改个人资料</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<!--<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 个人资料管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="doUpdateYonghuzhuce2.do" target="hsgmain">修改个人资料</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 相册管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xiangcexinxi_add.jsp" target="hsgmain">相册添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xiangcexinxiList2.do" target="hsgmain">相册查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>-->
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 相册信息管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xiangcexinxi_add.jsp" target="hsgmain">相册信息添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="xiangcexinxiList2.do" target="hsgmain">相册信息查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<!--<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 视频管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shipinxinxi_add.jsp" target="hsgmain">视频添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shipinxinxiList2.do" target="hsgmain">视频查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>-->
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 视频信息管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shipinxinxi_add.jsp" target="hsgmain">视信息频添加</a><img class="icon5" src="images/coin21.png" />
				</dd>
<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shipinxinxiList2.do" target="hsgmain">视频信息查询</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 我的收藏<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shoucangjilu_list2.jsp" target="hsgmain">我的收藏</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
<!--<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 我的收藏<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="shoucangjilu_list2.jsp" target="hsgmain">我的收藏</a><img class="icon5" src="images/coin21.png" />
				</dd>

			</dl>
-->



			
		</div>
	</div>
</body>
</html>