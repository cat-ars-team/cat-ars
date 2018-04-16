<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>页面头部</title>
   	<link rel="shortcut icon" href="${webapp}/res/images/ico/favicon.ico" /> 
    <script type="text/javascript">
    	function getCompeNo(path,model){
    		$.ajax({
    			type : "post",
    			url : "${webapp}/getCompeNoAction.action",
    			data : { "model" : model },
    			success : function(data){
    				if(data == 1){
    					window.location.href = path;
    				}else{
    					alert("抱歉，您没有权限！ ");
    				}
    			}
    		});
    	}
    	$(function(){
        	//显示二级菜单
    		$('.nav-center>ul>li').mouseover(function(){
    			$(this).children('ul').stop().show();
    			$(this).css('height', '200px');
    		});
    		$('.nav-center>ul>li').mouseout(function(){
    			$(this).children('ul').stop().hide();
    			$(this).css('height', '');
    		});
    	});
    	//退出系统
    	function logOut(){
        	if(confirm("确定要退出吗？")){
	        	document.location.href = 'exit.do';
            }
            return;
        }
    	
    	function menuClick(url,name){
    		alert("url:"+url+"name:"+name)
    		
    		if(name=='ISF'){
    			$('#add-div-comfirm1').css('display','block');
    			
    		}else{
    			
				
    		}
    		
    		
    	}
    	
    	
    </script>
  </head>
<%
	Cookie cookies[] = request.getCookies();
	String app_lan = "";
	if (cookies != null)
	{
 		for (int i = 0; i < cookies.length; i++)
	 	{
		  	if ("lang".equals(cookies[i].getName())){
				app_lan = cookies[i].getValue();
				System.out.println("---:"+app_lan);
			}
	 	}
	} 
%>
  <body>
  
  

	
	<!--添加项目-->
	<div id="add-div-comfirm1" class="add-div-NUSGO" style="margin-left: 60px;margin-top: -440px;display:none " >						
		<input type="button" class="qr" id="btn-comfirm-yes1" style="background: url('${webapp}/systemMain/images/yes.jpg') no-repeat; height:46px;width:157px;"/><!--  id="qr-1" -->
	 	<input type="button" class="qx" id="btn-comfirm-no1"  style="background: url('${webapp}/systemMain/images/no.jpg') no-repeat; height:46px;width:157px;"  >	 
 	</div>
  
  
    <div id="top">
        <div class="logo<%=app_lan%>">
        	<p>
        		<a <%if(app_lan==null||"".equals(app_lan))
        				{out.print("style=\"color:#FFFFFF\" ");}
        			 else{out.print("style=\"color:#0000AA\" ");}%>  
        		href="servlet/CookiesServlet?lang=&m=loginAction.action" >中文</a> / 
        	
        		<a <%if(app_lan==null||"".equals(app_lan))
        				{out.print("style=\"color:#0000AA\" ");}
        			 else{out.print("style=\"color:#FFFFFF\" ");}%> 
        			href="servlet/CookiesServlet?lang=_en&m=loginAction.action" >En</a>
        	</p>
        	
        	
        	<p>
        		<a href="javascript:logOut()">
        			<span>
	        			<img src="${webapp}/res/images/tcxt-icon.png" width="13" height="13" />
	        		</span>
	        		<%if(app_lan==null||"".equals(app_lan))
	        			{out.print("退出系统");}
	        		  else{out.print("Log off");}%>
        		</a>
        	</p>
        	   	
        	<p>
        	<%if(app_lan==null||"".equals(app_lan))
        		{out.print("欢迎,");}else{out.print("Welcome ");}%> 
        		<b style="color:#333">${user.userName }</b>！
        	</p>
        	     	
        </div>
        <div class="nav">          
            <div class="nav-center">
                <ul>
                    <li class="first" style="margin-left: 87px;"><a href="xtgg.do" target="mainframe" class="nav-link"><%if(app_lan==null||"".equals(app_lan)){out.print("首页");}else{out.print("Home page");}%></a></li>
                    <%--  <li class="first" style="margin-left: 87px;"><a href="test/sstest.do" target="mainframe" class="nav-link"><%if(app_lan==null||"".equals(app_lan)){out.print("首页");}else{out.print("Home page");}%></a></li> --%>
                    <c:forEach items="${menulist }" var="menu">
						<c:if test="${menu.prent_menu_id==0 }">
						  <li class="first listMenu">
						  	<a href="javascript:void(0)" class="nav-link">
						  		${menu.menu_name }
						  	</a>
							
								<ul>
									<c:forEach items="${menulist }" var="submenu">
										<c:if test="${menu.menu_id==submenu.prent_menu_id }">
											<li>
											<%--  onclick="menuClick('${submenu.menu_url }','${submenu.menu_name }')" --%>
												<a href="${submenu.menu_url }" id="${submenu.menu_name }" target="mainframe"> ${submenu.menu_name } </a></li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:if>
					</c:forEach>
                    
                </ul>
            </div>
           
         </div>
    </div>
    
  </body>
</html>
