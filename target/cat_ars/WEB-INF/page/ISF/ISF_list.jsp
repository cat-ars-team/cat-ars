<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";	//设置系统入口
	/* request.setAttribute("webapp", path); */
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ISF</title>
<link href="<%=basePath%>res/css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>res/jQuery/jquery-1.9.1.js"></script>

<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.css"> 
<link rel="stylesheet" href="<%=basePath%>res/css/MyGloable.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/MyGloable.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=basePath%>res/css/fileinput.min.css"> 
<script type="text/javascript" src="<%=basePath%>res/js/fileinput.min.js"></script>

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

<script type="text/javascript">
function deletePro(proidvalue){ 
	if(confirm("确定要删除吗？")){
    	document.location.href = '<%=basePath%>ISF/delete.do?proid='+proidvalue;
    }
    return;
}

function aa(proid){
	var  url = encodeURI('<%=basePath%>ISF/subreceipt.do?subReceiptProid='+proid);
	 var form = $("<form>");
	    form.attr('style', 'display:none');
	    form.attr('target', '');
	    form.attr('method', 'post');
	    form.attr('action', url);
	    form.attr('charset', 'utf-8');
	   
	    //设置form请求
	    $('body').append(form);
	    
	    //form提交
	    form.submit();
	    //动态删除
	    
	  
	    form.remove();    
	
	}


	$(function(){ 
		// 项目添加结果
	   var flag = '${proaddResult.flag }';
	   var Message = '${proaddResult.messageStr }';
	   //其他
	  var flagqt = '${resultModel.flag }';
	  var Messageqt = '${resultModel.messageStr }';
	  
	  
	//其他
	  var flagjbxx = '${romiResult.flag }';
	  var Messagejbxx = '${romiResult.messageStr }';
	  

	  var err = '${err }';
	  if(err!=''){
		  alert(err)
	  }
	  
	  if(Message=='' && Messageqt==''&& Messagejbxx==''){
		   return;
	   }else if(flag=== '0'){		   
		   alert(Message);  
		   $("#myAddModal").modal('show');
		   
	   }else if(Message!=''){
		   alert(Message); 
	   }
	   
	   else if(flagqt=== '0'){   
		   alert(Messageqt); 
	   }else if(Messageqt!=''){
		   alert(Messageqt);
	   }else if(flagjbxx=== '0'){   
		   alert(Messagejbxx); 
	   }else if(Messagejbxx!=''){
		   alert(Messagejbxx);
	   }
	}); 
	
	function setApproveProid(proid){
		$('#approveProid').val(proid);
		$("#approveModal").modal('show');
//省市联动	
		
	}
	
	function setRemark(proid,remark){
		
		
		$("#RemarkModel").modal('show');
//省市联动	
		/* $('#remarkid').val(proid); */
		$('#RemarkValue').text(remark);
		var qrcodefortemcontent=$("#RemarkModel").val();		
	}
	
		//省市联动
		$(function() {  
			
			$.post("ISF/getallroles.do",  
					    function(data) {  
					        var dataObj = eval("(" + data + ")");  
					        for (var i = 0; i < dataObj.length; i++) {  
					            var $option = $("<option></option>");  
					            $option.attr("value", dataObj[i].roleName);  
					            $option.text(dataObj[i].roleName);  
					            $("#roleid").append($option);  
					        }  
					    });  
			
		    $.post("ISF/search.do?flag=getOne",  
		    function(data) {  
		        var dataObj = eval("(" + data + ")");  
		        for (var i = 0; i < dataObj.length; i++) {  
		            var $option = $("<option></option>");  
		            $option.attr("value", dataObj[i].areaid);  
		            $option.text(dataObj[i].areaname);  
		            $("#proprovince").append($option);  
		        }  
		    });  
		      
		    $("#proprovince").change(function() {  
		        var jsonObj = {  
		            id: $(this).val()  
		        };  
		        $("#procity option[value!='']").remove();  
		       // $("#three option[value!='']").remove();  
		        $.post("ISF/search.do?flag=getTwo&parId=" + $("#proprovince").val(), jsonObj,  
		        function(data, textStatus) {  
		            var dataObj = eval("(" + data + ")");  
		            for (var i = 0; i < dataObj.length; i++) {  
		                var $option = $("<option></option>");  
		                $option.attr("value", dataObj[i].areaid);  
		                $option.text(dataObj[i].areaname);  
		                $("#procity").append($option);  
		            }  
		        });  
		    });  
		    
		    $(function() {  
			    $.post("ISF/search.do?flag=getOne",  
			    function(data) {  
			        var dataObj = eval("(" + data + ")");  
			        for (var i = 0; i < dataObj.length; i++) {  
			            var $option = $("<option></option>");  
			            $option.attr("value", dataObj[i].areaid);  
			            $option.text(dataObj[i].areaname);  
			            $("#proprovince_add").append($option);  
			        }  
			    });  
			      
			    $("#proprovince_add").change(function() {  
			        var jsonObj = {  
			            id: $(this).val()  
			        };  
			        $("#procity_add option[value!='']").remove();  
			       // $("#three option[value!='']").remove();  
			        $.post("ISF/search.do?flag=getTwo&parId=" + $("#proprovince_add").val(), jsonObj,  
			        function(data, textStatus) {  
			            var dataObj = eval("(" + data + ")");  
			            for (var i = 0; i < dataObj.length; i++) {  
			                var $option = $("<option></option>");  
			                $option.attr("value", dataObj[i].areaid);  
			                $option.text(dataObj[i].areaname);  
			                $("#procity_add").append($option);  
			            }  
			        });  
			    });  
			});
		      
		    
		    
		 
			// 注册 批准 
			 $("#submitApprove").click(function() {   
						document.forms["approveModal"].action="<%=basePath%>ISF/approve.do";
						document.forms["approveModal"].submit();
			 })
			 
			  
			
			
			function submitReceipt(proid){	
				var  url = encodeURI('<%=basePath%>ISF/subreceipt.do?subReceiptProid='+proid);
				  alert("xxoo")
	        	 var form = $("<form>");
	        	    form.attr('style', 'display:none');
	        	    form.attr('target', '');
	        	    form.attr('method', 'post');
	        	    form.attr('action', url);
	        	    form.attr('charset', 'utf-8');
	        	   
	        	    //设置form请求
	        	    $('body').append(form);
	        	    
	        	    //form提交
	        	    form.submit();
	        	    //动态删除
	        	    
	        	    form.remove();     	
		        }
			 
		 
		    /* $("#two").change(function() {  
		        var jsonObj = {  
		            id: $(this).val()  
		        };  
		        $("#three option[value!='']").remove();  
		        $.post("test/search.do?flag=getThree&parId=" + $("#two").val(), jsonObj,  
		        function(data, textStatus) {  
		            var dataObj = eval("(" + data + ")");  
		            for (var i = 0; i < dataObj.length; i++) {  
		                var $option = $("<option></option>");  
		                $option.attr("value", dataObj[i].id);  
		                $option.text(dataObj[i].name);  
		                $("#three").append($option);  
		            }  
		        });  
		    });   */
		});  
		
		

</script>
</head>
<body>
	<div style="padding: 0px; margin: 0px"> 
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;background-color:#4e4e4e">
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">项目管理</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">ISF</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">ISF查询</li>

		</ul>		
	</div>
	
		<div class="alert alert-warning alert-dismissible" style="display: ${errorinfo==null?'none':'block' };" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div align="center" style="color: red;">${errorinfo }</div>
		</div>
	

<form action="<%=basePath%>ISF/list.do" method="post" class="form-horizontal"  data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		 
		
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
						<input type="text" class="form-control" name="proid" placeholder="项目ID" value="${Searcher.proId }" />
					</div>
				</div>
			</div>			 			
			
		</div>
		
		<div class="row" style="padding:5px" >	
		
		<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">级别:</label>
					<div class="col-sm-8">
						<select name="level" class="form-control">
						<option value="">--请选择--</option>
						<option value="1">Tier1</option>
						<option value="2">Tier2</option>
						<option value="3">Tier3</option>
						<option value="4">Tier4</option>
						<%-- <c:forEach items="${userlist }" var="user">
							<option value="${user.userId }">${user.userName }</option>
						</c:forEach>	 --%>
						
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">代理商:</label>
					<div class="col-sm-8">
						<select name="roleid" id="roleid" class="form-control">
							<option value="">--请选择--</option>	
						</select>
					</div>
				</div>
			</div>
		
 
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">省份:</label>
					<div class="col-sm-8">
						<select name="proprovince" id="proprovince" class="form-control">
							<option value="">--请选择--</option>
							<%-- <c:forEach items="${provincelist }" var="list">
								<option value="${list.areaid }">${list.areaname }</option>
							</c:forEach> --%>	
						</select>
					</div>
				</div>
			</div>
			
		</div>
			
		<div class="row" style="padding:5px" >	 
		
		<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">城市:</label>
					<div class="col-sm-8">
						<select name="procity" id="procity" class="form-control">
						<option value="">--请选择--</option>
						 
						
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">报销状态:</label>
					<div class="col-sm-8">
						<select name="bxstatus" class="form-control">
							<option value="">全部</option>
                			<option value="1">已批准</option>
                			<option value="0">待批准</option>
                			<option value="2">请修改</option>
						</select>
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label" >客户信息提交状态:</label>
					<div class="col-sm-8">
						<select name="issubcustinfo" class="form-control">
							<option value="">全部</option>
                			<option value="1">已提交</option>
                			<option value="0">未提交</option>
						
						
						</select>
					</div>
				</div>
			</div>
			
			
		</div>
			
		<div class="row" style="padding:5px" >
		
		<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-5 control-label" >报销资料提交状态：</label>
					<div class="col-sm-7">
						<select name="issubbxzl" class="form-control">
						 <option value="">全部</option>
		                 <option value="1">已提交</option>
		                 <option value="0">未提交</option>
          
						</select>
					</div>
				</div>
			</div>
			
			 
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-5 control-label" >实体发票提交状态：</label>
					<div class="col-sm-7">
						<select name="issubreceipt" class="form-control">
							<option value="">全部</option>
                			<option value="1">已提交</option>
                			<option value="0">未提交</option>
						
						</select>
					</div>
				</div>
			</div>
			
			
			
			
			
			<div class="col-sm-4" align="center" >
				<input type="submit"  style="background-color:#424040 ; color:#e1b513;font-weight:600;border:1px solid #424040" value="查  询" class="btn btn-sm btn-warning" /> 
				<input type="reset"  style="background-color:#424040; color:#e1b513;font-weight:600;border:1px solid #424040" value="清  空" class="btn btn-sm btn-warning" />
			</div>
			 
			
		</div>
	
		
		<div class="row breadcrumb" style="margin: 5px; padding: 5px;background-color:#4e4e4e">
			<div class="col-sm-4" align="left">
				 <span style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">查询结果</span>
			</div>
			
			<div class="col-sm-8" align="right">
			<input type="button" style="background-color:#424040; color:white;font-weight:600 ;border:2px solid #393838"
			value="添加项目" data-toggle="modal"  data-target="#myAddModal" class="btn btn-sm btn-info " />		
			
			<input type="button" style="background-color:#424040; color:white;font-weight:600 ;border:2px solid #393838"
			value="批量添加项目" data-toggle="modal" data-target="#myBatchAddModal" class="btn btn-sm btn-info" />

			<!-- 模板下载   ISF_项目批量导入模板.xls      ISF_客户名单导入模板.xls  -->
			<input type="button" style="background-color:#424040; color:white;font-weight:600 ;border:2px solid #393838"
			 id="uploadProExcel"  value="项目导入模板" class="btn btn-sm btn-info" /> 
			 
			<input type="button" style="background-color:#424040; color:white;font-weight:600 ;border:2px solid #393838"
			 id="uploadCustExcel" value="客户名单导入模板" class="btn btn-sm btn-info" /> 
			</div>
			
			
		</div>
	

		<div class="row" style="padding: 5px;overflow: auto; width: 100%; margin:5px">
		${approveResult.messageStr }
		<!-- 	<table class="table "> -->
		<div class="col-sm-12" style="overflow: auto;">
    		<table id="setValueTable" class="bgxt-tab"  >
				<tr class="tab-th">
                    <th class="tab-l"> </th>
				 		 
					<th>项目ID</th> 
					<th>代理商</th>  
					<th>&nbsp;级别&nbsp;</th> 
					<th>客户人数</th> 
					<th>项目日期</th> 
					<th>&nbsp;省份&nbsp;</th>  
					<th>&nbsp;城市&nbsp;</th>  
					<th>是否包含<br />NUSGO </th> 
					<th>项目批准<br />(小于30或大于500人)</th>
					<th>操作</th>
					 
					<th>客户信息<br />提交状态</th>
					<th>报销资料<br />提交</th>  
					
					<th>报销状态</th>
					<th>实体发票提交 </th> </tr>
			 
				 <!-- id,proid,protype,roleid,level,custcount,protime,proprovince,procity,ratiYn,createtime,createby,
  updatetime,updateby,custState,factId,totalcust,appreim -->
					<c:forEach items="${list }" var="pro">
					<tr class="tab-td01">
						 
						<td colspan="2">${pro.proid }</td>
						<td>${pro.roleid }</td>
						<td>${pro.level }</td> 			
						<td>${pro.custcount }</td>
						<td>${pro.protime }</td>
						<td>${pro.proprovince }</td> 			
						<td>${pro.procity }</td>
						<td>
							<c:if test="${pro.isnusgo == 0  }">
								否
							</c:if>
							
							<c:if test="${pro.isnusgo == 1  }">
								是
							</c:if>
						</td>
						
						<td> 
						<c:if test="${pro.specialstatus == 1 && pro.custcount<30}"><!-- 小于30人显示 -->
								<b>审批通过(小于30人)</b>  
							</c:if>
							<c:if test="${pro.specialstatus == 1 && pro.custcount>500}"> 
								<b>审批通过(大于500人)</b>
								
							</c:if>
							<c:if test="${pro.specialstatus == 1 && pro.custcount>30 && pro.custcount<501}"><!-- 小于30人显示 -->
								<b>无需审批</b>  
							</c:if>
							<c:if test="${pro.specialstatus == 0 }"><!-- 小于30人显示 -->
								<b>未审批</b>
								<a href="<%=basePath%>ISF/specialApprove.do?proid=${pro.proid }">审批</a>
							</c:if>
							
							 
						</td>
						
						<td> 
							<c:if test="${  pro.issubcustinfo == 0 }">
							<a onclick="deletePro('${pro.proid }')"   role="button">刪除</a> 
							</c:if>
						</td>
						 			
						<td style="align:left;"> 
					<%-- 	<span>${pro.specialstatus}&nbsp&nbsp&nbsp&nbsp ${pro.issubcustinfo }</span> --%>
							<!-- 提交客户信息 -->
							<c:if test="${ pro.issubcustinfo == 0 }"> 
								<b>未提交</b>
							</c:if>
							<c:if test="${ pro.issubcustinfo == 1 }"> 
								<b>已提交</b>
							</c:if>
							<c:if test="${pro.specialstatus == 1 && pro.issubcustinfo == 0 }">
									<a href="javascript:showImportCust('${pro.proid }')" >导入</a>&nbsp
							</c:if>
							
							<c:if test="${pro.issubcustinfo == 1 && pro.issubjbxx == 0 }"> 
									<a href="javascript:showImportCust('${pro.proid }')" >更新</a>&nbsp&nbsp
							</c:if>
							
							<c:if test="${pro.issubcustinfo == 1  }"> 
									<a href="<%=basePath%>ISF/custlist.do?proid=${pro.proid }" >查看</a>
							</c:if>
			<%-- <a href="javascript:showImportCust('${pro.proid}')"  data-toggle="modal" data-target="#ImportCust">导入</a> --%>		
		 <!-- bxstatus  issubbxzl  issubcustinfo   issubreceipt  specialstatus  issubjbxx -->
						</td>
						
						<td>
							<c:if test="${ pro.issubbxzl == 0 || pro.issubjbxx == 0 }">
								<b>未提交</b>
							</c:if>
							
						
							<!-- 提交基本信息 -->
							<c:if test="${pro.issubcustinfo == 1  && pro.isCanBxzlSub==1}"> 
									 
									<c:if test="${pro.issubbxzl != 1  && pro.issubjbxx != 1 }">
										 <a href="<%=basePath%>ISF/jbxxload.do?proid=${pro.proid }"  >提交</a> 
									</c:if>
										
									<c:if test="${ pro.issubbxzl != 1 && pro.issubjbxx == 1 }">
										<a href="<%=basePath%>ISF/romiload.do?proid=${pro.proid }" >提交</a>
									</c:if>	
									
									<c:if test="${ pro.issubbxzl == 1 && pro.issubjbxx == 1 }">
										<b>已提交</b>
										<a href="<%=basePath%>ISF/romi.do?proId=${pro.proid }" >查看</a>
									</c:if>	
									<!-- class=" btn btn-primary btn-xs" -->
							</c:if>
							
						</td>
						
						 
						 
						 <!-- 项目状态 -->
						<td>
							<c:if test="${ pro.bxstatus == 0 || pro.bxstatus ==null }">
								<b>待批准</b>&nbsp&nbsp
								<c:if test="${ pro.issubbxzl == 1 && pro.issubjbxx == 1 }">
									<a href="javascript:" id="approve" onclick="setApproveProid('${pro.proid }')"  >批准</a>
								</c:if>	
							</c:if>	
						 
							<c:if test="${ pro.bxstatus == 1}"> 
								<b>已批准</b>&nbsp&nbsp
								<a href="javascript:"   onclick="setRemark('${pro.proid }','${pro.remark }')"  >查看备注</a>
							</c:if>
							<c:if test="${ pro.bxstatus == 2}"> 
								 <b>请修改</b> &nbsp&nbsp
								 <a href="javascript:"   onclick="setRemark('${pro.proid }','${pro.remark }')"  >查看备注</a>
							</c:if>
						</td>
						 
						 
						 
						<!-- 发票提交状态 -->
						<td> 
						<c:if test="${ pro.issubreceipt == 0}"> 
							<b>未提交</b>
							<c:if test="${ pro.bxstatus == 1}"> 
								<a href="javascript:"  onclick="aa('${pro.proid }')"  >提交</a>
							</c:if>
						</c:if>
							
							<c:if test="${ pro.issubreceipt == 1}"> 
								<b>已提交</b>
							</c:if>
							
						</td>
						 
						<%-- <td><fmt:formatDate value="${pro.createtime }" pattern="yyyy-MM-dd HH:mm"/> </td> --%>
					 
						
						
					</tr>
				</c:forEach>
			</table>

		</div>
		</div>
		
		<div align="right" style="padding: 15x;">
			<pg:pager items="${total }" url=" ISF/list.do" maxIndexPages="3" export="currentPageNumber=pageNumber" scope="request">
				
				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		
		</div>
	</form>
	
	
<!-- 查看备注模态框 -->
<div class="modal fade" id="RemarkModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			 
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="remarkid">查看备注 </h4>
						<input type="text" readonly  id="remarkidhid"  >
					</div>
				
				<div class="modal-body">
					

					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-6 control-label">备注:</label>
							<div class="col-sm-10">
							 	<textarea class="form-control" rows="3" id="RemarkValue"></textarea>
							</div>
						</div>
					</div>
				</div>
				
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					
				</div>
			</div>
</div>
		

<!-- 批准模态框 -->
<div class="modal fade" id="approveModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="<%=basePath%>ISF/approve.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">批准 </h4>
						<input type="hidden"  id="approveProid" name="proid" >
					</div>
				
				<div class="modal-body">
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label" >批准状态:</label>
							<div class="col-sm-8">
								<select  id="approveSelect" class="form-control" name="bxstatus">
								 
								<option value="0">--请选择--</option>
									<option value="1">批准</option>
	    							<option value="2">请修改</option>
								</select>
							</div>
						</div>					
					</div>

					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">备注:</label>
							<div class="col-sm-8">
							 	<textarea class="form-control" rows="3" name="remark"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div class="modal-footer">
						<button id="submitApprove" class="btn btn-primary">确认</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				
				
				
			</div>
			</form>
			</div>
</div>





	<!-- Modal add-->
	<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="<%=basePath%>ISF/add.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加项目</h4>
						
					</div>
				<div class="modal-body">
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">客户人数:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="custcount" id="custcount" placeholder="项目人数" value="" onblur="selectNumber()" />
							</div>
						</div>
						</div>
					
					<div class="row" style="padding:5px" >	
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">项目时间:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" onclick="WdatePicker({maxDate:'%y-%M-{%d-1}'})" name="protime" data-rule="项目时间:required;" placeholder="项目时间" />
							</div>
						</div>
					</div>
					
					
					
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">级别:</label>
							<div class="col-sm-8">
								<select name="level" id="levelSelect" class="form-control" value="3">
								<optgroup disabled hidden></optgroup>
								<option value="">--请选择--</option>
								<option value="1">Tier1</option>
								<option value="2">Tier2</option>
								<option value="3">Tier3</option>
								<option value="4">Tier4</option>
								</select>
							</div>
						</div>					
					</div>
					
					
					<script type="text/javascript">
					function selectNumber(){
						var num = $("#custcount").val();   //获取input中输入的数字
						
						var level=0
						if (num<50){
							level=4
						}else if(num<150){
							level=3
						}else if(num<300){
							level=2
						}else if(num>299){
							level=1
						}
						
						var numbers = $("#levelSelect").find("option"); //获取select下拉框的所有值
						for (var j = 1; j < numbers.length; j++) {
							if ($(numbers[j]).val() == level) {
							$(numbers[j]).attr("selected", "selected");
							}
						}
						}
					</script>
					
					<h3>项目举办省份及城市</h3>
					
					<div class="row" style="padding:5px" >	
						<div class="col-sm-6">	
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">省份:</label>
							<div class="col-sm-8">
								<select name="proprovince" id="proprovince_add" class="form-control">
								<optgroup disabled hidden></optgroup>
								<option value="">--请选择--</option>
								 
								</select>
							</div>
						</div>	
						</div>	
						
						<div class="col-sm-6">	
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">城市:</label>
							<div class="col-sm-8">
								<select name="procity" id="procity_add" class="form-control">
								 
								</select>
							</div>
						</div>	
						</div>	
										
					</div>
					
										
				</div>
					
					<div class="modal-footer">
						<button type="submit" id="selected" class="btn btn-primary">确认</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	<!-- 批量创建项目 -->
	<div class="modal fade" id="myBatchAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="<%=basePath%>ISF/batchAdd.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">批量创建项目</h4>
					</div>
					<div class="modal-body">
						<!-- <input type="file" name="file" /> -->
						<input id="fapiao" type="file" class="file"  name="file"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >
					</div>
					<div class="modal-footer">
						<button type="submit" id="selected" class="btn btn-primary">导入</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	<!-- 导入客户信息 -->
	<div class="modal fade" id="ImportCust" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="<%=basePath%>ISF/importCust.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="importCust_proid" > 客户信息导入</h4>
						
					</div>
					<div class="modal-body">
						<input type="hidden" name="importproid" id="hideProID"> 
					<!-- 	<input type="file" name="file" />  -->
						<input id="fapiao" type="file" class="file"  name="file"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >

					</div>
					<div class="modal-footer">
						<button type="submit" id="selected" class="btn btn-primary">导入</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

					</div>
				</div>
			</form>
		</div>
	</div>
	
		<script type="text/javascript">
		
		 function showImportCust(proID){
			$("#hideProID").val(proID);
		 	$("#importCust_proid").text(proID+"-客户信息导入");
		 	$("#ImportCust").modal('show');
	    }
		 
		
		
		function downloadTemplate(obj){	
			var url ='';
			if (obj=='1')
			{
				url = encodeURI('<%=basePath%>ISF/downtemplatePro.do');
				
			}else{
				
				url = encodeURI('<%=basePath%>ISF/downtemplateCust.do');
			}
        	 var form = $("<form>");
        	    form.attr('style', 'display:none');
        	    form.attr('target', '');
        	    form.attr('method', 'post');
        	    form.attr('action', url);
        	    form.attr('charset', 'utf-8');
        	    //设置参数
        	    var parm = $("#parm").val();
        	    var input1 = $('<input>');
        	    input1.attr('type', 'hidden');
        	    input1.attr('name', 'parm');
        	    input1.attr('value', parm);
        	    //设置form请求
        	    $('body').append(form);
        	    form.append(input1);  
        	    //form提交
        	    form.submit();
        	    //动态删除
        	    form.remove();     	
	        }
		
		$('#uploadProExcel').click(function(){
			downloadTemplate('1');
		});
		
		$('#uploadCustExcel').click(function(){
			downloadTemplate('2');
		});
	
	</script>
	
	
</body>
</html>





