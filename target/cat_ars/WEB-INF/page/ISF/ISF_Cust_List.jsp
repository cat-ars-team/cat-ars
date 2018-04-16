<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ISF_Cust_List.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>res/css/global.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="res/css/bootstrap.css">
<link rel="stylesheet" href="res/css/MyGloable.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/MyGloable.js"></script>
<style type="text/css">
		/* 公共CSS 实现table隔行换色*/
		table .tab-td01 td.tr_odd{ background-color:#C4C4C4;}
		table .tab-td01 td.tr_even{ background-color:#A9A9A9;}
		 a {
	    	 COLOR:blue;
	    	}
	    	A:active {
	    	 COLOR:blue;
	    	}
	    	a:hover:text-decoration: underline;
	    	
	    	
		
	</style>

  </head>
  
  <body>
  
 <%--  <h4>项目ID: ${pro.proid }</h4>
  <h4>级别: ${pro.prolevel }</h4>
  <h4>客户名单提交时间: <fmt:formatDate value="${file.updtime }" pattern="yyyy-MM-dd HH:mm"/> </h4> --%>
	
		<div style="padding: 0px; margin: 0px"> 
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;background-color:#4e4e4e">
			<li><a href="<%=basePath%>ISF/list.do" style="color:#bababa;"   class="btn btn-sm btn-default">返回上一级</a></li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">项目管理</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">ISF</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">客户名单</li>

		</ul>		
	</div>
	
	<center style="margin-top:15px">
  
  			<div class="text">
	  			<h4>	项目ID:${pro.proid}&nbsp;&nbsp;&nbsp;
	  			级别:Tier${pro.level}&nbsp;&nbsp;&nbsp;
	  			客户名单提交时间:<fmt:formatDate value="${custUploadDate}" pattern="yyyy-MM-dd"/>
	  			</h4> 
  			</div>
	    	<div class="col-sm-12" style="overflow: auto;padding-left:5px;height:600px">
	    	<center>
    		<table id="setValueTable" class="bgxt-tab"  >
	                	<tr class="tab-th">
	                        <th class="no-border" colspan="2">客户名称</th> 
	                        <th>感兴趣设备（挖机/非挖机）</th>
	                        <th>购买意向是否在6个月之内?(是/否)</th>
	                        <th colspan="2">手机号码</th>
	                        <!-- <th>客户是否参与</th> -->
	                        <!--<th class="bz-width">代理商是否有跟进</th>-->
	                        <!--<th class="cz-width" colspan="2">其他</th>-->
	               </tr> 
	             <c:forEach items="${custlist }" var="cust">
					<tr class="tab-td01">
	                    	<td colspan="2">${cust.custname}</td>
	                    	<td>${cust.macConn}</td>
	                    	<td>${cust.buyYn}</td>
	                    	<td >${cust.custmobile}</td>
	                    	<!--<td>${upi005.custsat}</td>-->
	                    	<!--<td>${upi005.agntfolup}</td>-->
	                    	<!--<td colspan="2">${upi005.remark}</td>-->
	                    </tr>
	                    </c:forEach>
       		</table>
       		</center>
       		</div>
       		
       		<div align="right" style="padding: 10px;">
			<pg:pager items="${total }" url="ISF/custlist.do" maxIndexPages="4" export="currentPageNumber=pageNumber" scope="request">
			<pg:param name="proid" value="${pro.proid} " />		
				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		
		</div>
       		
      </center>
  </body>
</html>
