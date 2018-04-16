<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//设置系统入口
	request.setAttribute("webapp", path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title>卡特代理商报销平台 - 登录</title>
    <link rel="shortcut icon" href="${webapp}/res/images/ico/favicon.ico" /> 
    
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
		window.webapp = "${webapp}";
	</script><!-- 设置页面编码 -->
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
		window.webapp = "${webapp}";
	</script>
    
    
    
	<script type="text/javascript">
		function login(){
			var userName=document.getElementById("userName").value;
			if(userName==null||userName==""){
				alert("用户名不能为空！");
			}else{
				document.forms["loginForm"].submit();
			}
		}
		function lossPwd(){
			window.location.href = '${webapp}/systemMain/pages/user/loss.jsp';
		}
		function getMessage(){
			$('#userName').focus();
			var message=document.getElementById("message").value;
			if(message!="null"&&message!=""){
				alert(message);
			}
			
		}
		function onKeyLogin(){
			if (event.keyCode == 13){
				login();
			}
		}
		window.onload=getMessage;
	</script>
</head>
<%
Cookie cookies[] = request.getCookies();
String app_lan = "";
if (cookies != null)
{
 for (int i = 0; i < cookies.length; i++)
 {
  if (cookies[i].getName().equals("lang")){
    app_lan = cookies[i].getValue();
  	System.out.println("---:"+app_lan);
  }	
 }
} 
%>
<body onkeydown="onKeyLogin()">
<div id="box-wrap">
	<div>
		<span align="right">
			<a href="<%=request.getContextPath()%>/servlet/CookiesServlet?lang=&m=systemMain/pages/user/login.jsp" <%if(app_lan==null||"".equals(app_lan)){out.print("style='color:#FFFFFF'");}%>>中文</a> / <a href="<%=request.getContextPath()%>/servlet/CookiesServlet?lang=_en&m=systemMain/pages/user/login.jsp" <%if("_en".equals(app_lan)){out.print("style='color:#FFFFFF'");}%>>En</a>
		</span>
	</div>
  	<div id="top1">
        <div class="logo<%=app_lan%>"></div>
  	</div>
    <div id="cont-login<%=app_lan%>">
       <form name="loginForm" method="post" action="login.do">
    	 <p><input type="text" name="userAccount" id="userName" class="dlsid" /></p>
         <p><input type="password" name="userPassword" id="password" class="dlsid" /> <input type="button" class="wjmm-btn<%=app_lan%>" onclick="lossPwd()" /></p>
         <p class="login-but<%=app_lan%>"><input type="button" class="login-btn<%=app_lan%>" onclick="login();" /></p>
         <input type="hidden" value="<%=request.getAttribute("message") %>" id="message" />
       </form>
    </div>
    <p class="text-pass" style="font-size:19px">
    	*<%if(app_lan==null||"".equals(app_lan)){out.print("如您在使用平台中遇到任何问题，可发邮件至");}else{out.print("If you have any questions, please send email to");}%>
    	<a href="Mailto:eddy.jin@bintang.com.cn">eddy.jin@bintang.com.cn</a>
    	，<%if(app_lan==null||"".equals(app_lan)){out.print("也可致电010-57077020<br/>");}else{out.print("you also cloud call 010-57077020");}%>
    	<%if(app_lan==null||"".equals(app_lan)){out.print("（服务时间：周一至周五，10:30—13:00，14:00—18:30；周末及法定节假日休息）");}else{out.print("(Service time:10:30—13:00, Mon-Fri; Not including weekend and legal holiday)");}%>
    </p>
    <div id="footer"></div>
    
</div>
</body>
</html>
