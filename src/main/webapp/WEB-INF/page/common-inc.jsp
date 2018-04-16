<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";	//设置系统入口
	/* request.setAttribute("webapp", path); */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<!-- 设置页面编码 -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- 访问者将无法脱机浏览 -->
	<meta http-equiv="pragma" content="no-cache" />
	<!-- 网页的缓存方式, 每次刷新都重新载入 -->
	<meta http-equiv="cache-control" content="no-cache" />
	<!-- 用于设定网页的到期时间。一旦网页过期，必须到服务器上重新传输 -->
	<meta http-equiv="expires" content="0" />
	<!-- 引入全局样式 -->
	<link href="<%=basePath%>res/css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>res/jQuery/jquery-1.9.1.js"></script>
	<style type="text/css">
		/* 公共CSS 实现table隔行换色*/
		table .tab-td01 td.tr_odd{ background-color:#C4C4C4;}
		table .tab-td01 td.tr_even{ background-color:#A9A9A9;}
	</style>
	<!-- 覆盖默认设置 -->
	<script type="text/javascript">
		$(function(){
			tableColor();
	    });
	    function tableColor(){
	    	$('table tr:odd td').addClass('tr_odd'); //奇数行
	        $('table tr:even td').addClass('tr_even'); //偶数行
		}
		
	</script>
  </head>
</html>
