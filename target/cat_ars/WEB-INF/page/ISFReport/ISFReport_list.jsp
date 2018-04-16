<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报告系统</li>
			<li>ISF</li> 

		</ul>
	</div>
		<div class="alert alert-warning alert-dismissible"
			style="display: ${errorinfo==null?'none':'block' };" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div align="center" style="color: red;">${errorinfo }</div>
		</div>
	

<form action="list.do" method="post" class="form-horizontal"  data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		
		
		<div class="row" style="padding:5px" >			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">开始时间:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" onclick="WdatePicker()" name="paymentTime" data-rule="发放时间:required;" placeholder="请输入发放时间" />
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">结束时间:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" onclick="WdatePicker()" name="paymentTime" data-rule="发放时间:required;" placeholder="请输入发放时间" />
					</div>
				</div>
			</div>
			
 
			
			<div class="col-sm-4">
				<div class="form-group-sm">
				<label class="col-sm-4 control-label">项目ID:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="proId" placeholder="项目ID" value="${iSFReportInfoVM.proId }" />
					</div>
				</div>
				
				
			</div>
			 			
			
		</div>
		
		<div class="row" style="padding:5px" >	
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">代理商:</label>
					<div class="col-sm-8">
						<select name="userId" class="form-control">
						<option value=" dd">--请选择--</option>
						<option value=" dd">Tir1</option>
						<option value="cc">Tir2</option>
						<%-- <c:forEach items="${userlist }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>	 --%>
						
						</select>
					</div>
				</div>
			</div>
		
 
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">省份:</label>
					<div class="col-sm-8">
						<select name="userId" class="form-control">
						<option value=" dd">--请选择--</option>
						<option value=" dd">Tir1</option>
						<option value="cc">Tir2</option>
						<%-- <c:forEach items="${userlist }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>	 --%>
						
						</select>
					</div>
				</div>
			</div>
			
			 
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">城市:</label>
					<div class="col-sm-8">
						<select name="userId" class="form-control">
						<option value=" dd">--请选择--</option>
						<option value=" dd">Tir1</option>
						<option value="cc">Tir2</option>
						<%-- <c:forEach items="${userlist }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>	 --%>
						
						</select>
					</div>
				</div>
			</div>
			
		</div>
			
			
		<div class="row" style="padding:5px" >
			 
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">级别:</label>
					<div class="col-sm-8">
						<select name="userId" class="form-control">
						<option value=" dd">Tir1</option>
						<option value="cc">Tir2</option>
						<%-- <c:forEach items="${userlist }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>	 --%>
						
						</select>
					</div>
				</div>
			</div>
			
			
			
		</div>
	
		
		<div class="row breadcrumb" style="margin-bottom: 10px; padding: 5px;">
			<div class="col-sm-4" align="left">
				<h5><span>查询结果</span></h5>
			</div>
			
			<div class="col-sm-8" align="center">
					<input type="submit" value="查  询" class="btn btn-default" /> 
					<input type="reset" value="清  空" class="btn btn-default" />
					
					<!-- <a href="ISF/add.do" class="btn btn-default">查看对比/趋势报告</a> -->
				
			</div>
							
		</div>
	

		<div class="row" style="padding: 5px;overflow: auto; width: 100%; margin:5px">
		<div class="col-sm-12" style="overflow: auto;">
    		<table id="setValueTable" class="bgxt-tab"  >
                	<tr class="tab-th">
                    	<th class="tab-l"></th>
                        <th class="no-border">项目ID</th>
                        <th class="wid6">级别</th>
                        <th class="wid6" style="width:80px;">项目日期</th>
                        <th class="wid6">省份</th>
                        <th class="wid6">城市</th>
                        <th>项目总金额</th>
                        <th>报销金额</th>
                        <th>客户人数</th>
                        <th>产生的销售线索</th>
                        <th>现场交付定金的<br />客户数量</th>
                        <th>活动后(60天)的关单数<br />(赢单)</th>
                        <!--<th>销售线索转化率(%)</th>-->
                        <!--<th>商机生产率(%)</th>-->
                         <th class="no-border">关单率(%)</th>
                        <th class="tab-r"></th>
                    </tr> 
                    <c:forEach var="list" items="${list}"> 
                    	<tr class="tab-td01">
                    		<td colspan="2">${list.proId}</td>
                    		<td>${list.level}</td>
	                        <td>${list.proArea}</td>
	                    	<td>${list.proAread}</td>
	                    	<td>${list.totalCust}</td>
	                        <td>${list.appReim}</td>
	                    	<td>${list.custNum}</td>
	                    	<td>${list.custNum}</td>
	                    	<td>${list.custNum}</td>
	                    	<td>${list.custNum}</td>
	                    	<td>${list.custNum}</td>
	                    	
                          
                    	<td class="no-border" colspan="2">dfdas</td>
                    </tr> 
                    </c:forEach>              
                </table>
	 	</div>
	 		
	 	<div align="right" style="padding: 10px;">
			<pg:pager items="${total }" url="list.do" maxIndexPages="3"
				export="currentPageNumber=pageNumber" scope="request">
				<pg:param name="roleName" value="${roleName }" />

				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		</div>
 
			<div class="col-sm-6" style="height:400px " align="center">		
     		<table class="bgxt-tab2"  style="cellspacing=0,cellpadding=0">
                	<tr class="tab-th">
                    	<th class="tab-l"></th>
                        <th class="no-border wid" >机器型号</th>
                        <th>数量</th>
                        <th class="tab-r"></th>
                     
                    </tr>
                    <c:forEach var = "list" items="${listNewMachine}" >
                    	<tr class="tab-td01">
                    		<td colspan="2">${list.macName} (${list.macModel}) </td>
                    		<td colspan="2">${list.macNum}</td>
						</tr>
                    </c:forEach>
                  </table>
			</div>
			
			
			<div class="col-sm-6" style=" height:400px" align="center">
				<table class="bgxt-tab2"  style="cellspacing=0,cellpadding=0">
                	<tr class="tab-th">
                    	<th class="tab-l"></th>
                        <th class="no-border wid" >机器型号</th>
                        <th>数量</th>
                        <th class="tab-r"></th>
                     
                    </tr>
                    <c:forEach var = "list" items="${listOldMachine}" >
                    	<tr class="tab-td01">
                    		<td colspan="2">${list.macName} (${list.macModel}) </td>
                    		<td colspan="2">${list.macNum}</td>
                    	</tr>
                    </c:forEach>
                  </table>
			</div>
			 
		
		</div>
		
		
		
		<%-- <div align="right" style="padding: 10px;">
			<pg:pager items="${total }" url="salary/list.do" maxIndexPages="3"
				export="currentPageNumber=pageNumber" scope="request">
			<pg:param name="userName" value="${salaryPayment.userName }" />
				
				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		
		</div> --%>
	</form>

	
	
	
</body>
</html>