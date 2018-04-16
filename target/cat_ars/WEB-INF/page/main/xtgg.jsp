<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common-inc.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ISF</title>
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.css"> 
<link rel="stylesheet" href="<%=basePath%>res/css/MyGloable.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/MyGloable.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" src="<%=basePath%>res/js/rollDatePrompt.js"></script>
<style>
	label{
		font-size:15px;
	}
</style>

</head>
  
  <body>
  <center>
     <div id="cont-xtgg">
    	<div class="xt-header">
        	<ul class="gdxw">
            	<marquee scrollAmount=5 width=700px  direction=left >
                    <li class="one"><a href="javascript:;" id="showSYDay">dsfafasdf</a></li>
            	</marquee>
            </ul>
        </div>
        <div class="xt-center">
        	<p style="text-align: center;vertical-align: middle;margin-top: 130px;margin-left:0px;padding-left: 0px;">
				 <label style="font-size:32px;color: yellow;font-weight: bold;">欢迎使用卡特代理商报销平台</label><br/><br/>
				<!--<label style="font-size:24px;color: yellow;font-weight: bold;">GCI ISF与Paving活动需分别进入相应版块进行报销</label> -->
            </p>
        </div>
    </div>
    
     <p  style="font-size:15px">如您在使用平台中遇到任何问题，可发邮件至		
    	<a href="Mailto:eddy.jin@bintang.com.cn">eddy.jin@bintang.com.cn</a>
    	也可致电010-57077020<br/>
    	（服务时间：周一至周五，10:30—13:00，14:00—18:30；周末及法定节假日休息）
	</p>
    </center>
    
    <script type="text/javascript">
    	<%-- var ss="<%=app_lan%>"; --%>
    	var ss="";
    	if(ss==null || ss==""){
	    	window.onload=getSYDate;
    	}else{
    		window.onload=getSYDate_en;
    	}

    	function openWinForDownloadTemplate(){
			$('#downLoadTemplateDIV').css('display', 'block');
        }
        function closeDIV(divId){
        	$('#downLoadTemplateDIV').css('display', 'none');
        }
        function downloadTemplate(obj){
        	var url = encodeURI('${webapp}/sys_checkFile.action?fileName=' + obj);
			$.ajax({
				url : url,
				type : 'post',
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				success : function(data){
					if(data == 0){
						alert('您下载的文件不存,请联系管理员!');
					}else{
						window.location.href = '${webapp}/downloadTemplate.action?fileName=' + obj;
					}
				}
			});
        }
    </script>
    
  </body>
</html>
