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
		
		//批准 设置：proid, approveType
		 function setApproveProid(proid,approveType){
			 
				$('#approveProid').val(proid);
				$('#approveType').val(approveType);					
				$("#approveModal").modal('show');			
			}
		
		//添加项目提交按钮
		$(function(){
			 $("#subadd").click(function() {
					/* document.forms["addForm"].action="Nusgo/addppp.do?x=0000"; */
					document.forms["addForm"].action="Nusgo/addppp.do";
					document.forms["addForm"].submit();
			 });
			 		 
			 // 注册 批准 
			 $("#submitApprove").click(function() {   
						document.forms["approveModal"].action="<%=basePath%>Nusgo/update.do";
						document.forms["approveModal"].submit();
			 });
		})
		 
		
		// 查看详情 1
		function detailone(proid, purpostofevent, benefit, predictcost, percent, predictbxcost, eventdesc, custcount,giftreason,needapprovalbyleago){
			$('#proid').val(proid);
			$('#purpostofevent').val(purpostofevent);
			$('#benefit').val(benefit);
			$('#predictcost').val(predictcost);
			$('#percent').val(percent);
			$('#predictbxcost').val(predictbxcost);
			$('#eventdesc').val(eventdesc);
			$('#custcount').val(custcount);
			$('#giftreason').val(giftreason);
			
			if(needapprovalbyleago==1){
				$('#needapprovalbyleago').val('YES');
			}else{
				$('#needapprovalbyleago').val('NO');
			}	
			
			$("#RemarkModel").modal('show');
	//省市联动	
			/* $('#remarkid').val(proid); */
		
				
		}
		
		
		// 查看详情 1
		function detailTwo(proid, purpostofevent, benefit, predictcost, percent, predictbxcost, eventdesc, custcount,giftreason,needapprovalbyleago){
			$('#proid').val(proid);
			$('#purpostofevent').val(purpostofevent);
			$('#benefit').val(benefit);
			$('#predictcost').val(predictcost);
			$('#percent').val(percent);
			$('#predictbxcost').val(predictbxcost);
			$('#eventdesc').val(eventdesc);
			$('#custcount').val(custcount);
			$('#giftreason').val(giftreason);
			
			if(needapprovalbyleago==1){
				$('#needapprovalbyleago').val('YES');
			}else{
				$('#needapprovalbyleago').val('NO');
			}	
			
			$("#detailTwo").modal('show');
	//省市联动	
			/* $('#remarkid').val(proid); */
		
				
		}
		

</script>
</head>
<body>

	
	
<!-- 查看备注模态框 -->
<div class="modal fade" id="RemarkModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			 
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="remarkid">No. of Intended non-NUSGO invitees</h4>
						<input type="text" readonly  id="detailproid"  >
					</div>
				
				
				<div class="modal-body">
					<center> <span style="font-weight:600;font-size:17px ;color:black">Event Proposal</span>  </center>
					<hr>
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">NUSGO ID:</label>
							<div class="col-sm-7">
							 	<input class="form-control" rows="3" id="proid" />
							</div>
						</div>
					</div>
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Purpose of Event:</label>
							<div class="col-sm-7">
							 	<input type="text"  class="form-control" rows="3" id="purpostofevent" /> 
							</div>
						</div>
					</div>
					
						  
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Expected impact/benefit to Caterpillar:</label>
							<div class="col-sm-7">
							 	<input type="text"  class="form-control" rows="3" id="benefit" />
							</div>
						</div>
					</div>
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Estimated event total cost:</label>
							<div class="col-sm-7">
							 	<input type="text"  class="form-control" rows="3" id="predictcost" />
							</div>
						</div>
					</div> 
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Co-share agreement with Caterpillar - e.g. % of total cost, or specific activities:</label>
							<div class="col-sm-7">
							 	 <input type="text"  class="form-control" rows="3" id="percent" />
							</div>
						</div>
					</div>
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Estimated reimbursement cost:</label>
							<div class="col-sm-7">
							 	 <input type="text"  class="form-control" rows="3" id="predictbxcost" />
							</div>
						</div>
					</div>
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Event Description:</label>
							<div class="col-sm-7">
							 	 <input type="text"  class="form-control" rows="3" id="eventdesc" />
							</div>
						</div>
					</div>
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Number Of Invitees:</label>
							<div class="col-sm-7">
							 	 <input type="text" class="form-control" rows="3" id="custcount" />
							</div>
						</div>
					</div>
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">No. of Intended non-NUSGO invitees:</label>
							<div class="col-sm-7">
							 	 <input type="text" class="form-control" rows="3" id="nusgocount" />
							</div>
						</div>
					</div>
					
					
					<hr>
					<center> <span style="font-weight:600;font-size:18px ;color:black">NUSGO Details</span>  </center> 
					<hr>
					
					
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Planned Business Courtesy amount ($): </label>
							<div class="col-sm-6">
							 	 <input type="text" class="form-control" rows="3" id="plannedgiftamount" />
							</div>
						</div>
					</div>
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">What do you intend to give?</label>
							<div class="col-sm-6">
							 	 <input type="text" class="form-control" rows="3" id="giftname" />
							</div>
						</div>
					</div>
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Reason:</label>
							<div class="col-sm-6">
							 	 <input type="text" class="form-control" rows="3" id="giftreason" />
							</div>
						</div>
					</div>
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Legal Pre-Approval needed? (Y/N)</label>
							<div class="col-sm-6">
							 	 <input type="text" class="form-control" rows="3" id="needapprovalbyleago" />
							</div>
						</div>
					</div>
					
					
				</div>
				
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
					
				</div>
			</div>
</div>


	
<!-- 批准模态框 -->
<div class="modal fade" id="approveModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="<%=basePath%>Nusgo/update.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Approve </h4>
						<input type="hidden"  id="approveProid" name='subReceiptProid'>
						<input type="hidden"  id="approveType" name='updatetype'>
					</div>
				
				<div class="modal-body">
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label" >Approve Status:</label>
							<div class="col-sm-8">
								<select  id="approveSelect" class="form-control" name="approveValue">
								 
								<option value="0">--Select--</option>
									<option value="1">Approve</option>
	    							<option vaModify="2">Modify</option>
								</select>
							</div>
						</div>					
					</div>

					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Remark:</label>
							<div class="col-sm-8">
							 	<textarea class="form-control" rows="3" name="remark"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div class="modal-footer">
						<button id="submitApprove" class="btn btn-primary">OK</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				
				
				
			</div>
			</form>
			</div>
	</div>





	<div style="padding: 0px; margin: 0px"> 
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;background-color:#4e4e4e">
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">Project Manage</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">NUSGO</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">NUSGO Query</li>

		</ul>		
	</div>
	
	

<form action="<%=basePath%>Nusgo/list.do" method="post" class="form-horizontal"  data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		 
		
		<div class="row" style="padding:5px" >			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">Start Date:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" onclick="WdatePicker()" name="paymentTime" data-rule="发放时间:required;" placeholder="Start Date..." />
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">Ending Date:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" onclick="WdatePicker()" name="paymentTime" data-rule="Ending Date:required;" placeholder="Ending Date..." />
					</div>
				</div>
			</div>
						
			<div class="col-sm-4">
				<div class="form-group-sm">
				<label class="col-sm-4 control-label">NUSGO ID:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="proid"  placeholder="NUSGO ID" value="${Searcher.proId }" />
					</div>
				</div>
			</div>			 			
			
		</div>
		
		<div class="row" style="padding:5px" >	
		
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">Dealer Name:</label>
					<div class="col-sm-8">
						<select name="roleid" id="roleid" class="form-control">
							<option value="">--select--</option>	
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group-sm">
					<label class="col-sm-4 control-label">Reimbursement Status</label>
					<div class="col-sm-8">
						<select name="roleid" id="roleid" class="form-control">
							<option value="">--select--</option>	
						</select>
					</div>
				</div>
			</div>
		
 
				<div class="col-sm-4" align="center">
				<input type="submit"  style="background-color:#424040 ; color:#e1b513;font-weight:600;border:1px solid #424040" value="Query" class="btn btn-sm btn-warning" /> 
					<input type="reset"  style="background-color:#424040; color:#e1b513;font-weight:600;border:1px solid #424040" value="Reset" class="btn btn-sm btn-warning" />
			</div>
			
		</div>
			
			
		
	
		
		<div class="row breadcrumb" style="margin: 5px; padding: 5px;background-color:#4e4e4e">
			<div class="col-sm-4" align="left">
				 <span style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">Result</span>
			</div>
			
			<div class="col-sm-8" align="right">
					
					
					
			<input type="button"  style="background-color:#424040; color:white;font-weight:600 ;border:2px solid #393838" value="Add" data-toggle="modal"  data-target="#myAddModal" class="btn btn-sm btn-warning" />		
			<input type="button"  style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838" value="Batch Add" data-toggle="modal" data-target="#myBatchAddModal" class="btn btn-sm btn-warning" />

					<!-- 模板下载   ISF_项目批量导入模板.xls      ISF_客户名单导入模板.xls  -->
					<input type="button" id="uploadProExcel" style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"  value="Download Project Template" class="btn btn-sm btn-default" /> 
					
					<input type="button" id="uploadCustExcel" style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838" value="Download Customer Template" class="btn btn-sm btn-default" /> 
					
			</div>
			
				 
					
		</div>
	

		<div class="row" style="padding: 0px;overflow: auto; width: 99%; margin:5px">
	
		<div class="col-sm-12" style="overflow: auto;padding-left:5px;height:390px">
    		<table id="setValueTable" class="bgxt-tab"  >
				<tr class="tab-th">
                
				 	
					<th>&nbsp&nbsp NUSGO ID &nbsp</th> 
					<th>&nbsp Dealer &nbsp</br>&nbsp Name &nbsp</th>  
					<th>&nbsp Event date &nbsp</th> 
					<th>&nbsp Event Name &nbsp</th> 
					<th>Pre-event</br> &nbsp  Application &nbsp</th> 
					
					<th>Approved by</br>&nbsp Sales Manager  &nbsp</th> 
					<th>Reviewed by</br>&nbsp Admin &nbsp</th> 
					<th>Approved by</br>&nbsp MarCom Manager &nbsp</th>
					
					<th>Regional</br>&nbsp Manager Notice &nbsp</th>
					<th>Post-event</br>&nbsp Claim &nbsp</th>
				 	
					<th>Approved by</br>&nbsp Sales Manager  &nbsp</th>
					<th>Reviewed by</br>&nbsp Admin &nbsp</th>
					<th>Approved by</br>&nbsp MarCom Manager &nbsp</th>  
					<th>Approved by</br>&nbsp Regional Sales Leader &nbsp</th> 
					
			
				
					 
			 
				 <!-- id,proid,protype,roleid,level,custcount,protime,proprovince,procity,ratiYn,createtime,createby,
  updatetime,updateby,custState,factId,totalcust,appreim -->
					<c:forEach items="${list }" var="everypro">
						<tr class="tab-td01">
							 
							<td>&nbsp ${everypro.proid } &nbsp</td>
							<td>&nbsp ${everypro.roleid } &nbsp</td> 
							<td>&nbsp ${everypro.eventdate } &nbsp</td>			
							<td>&nbsp ${everypro.eventname } &nbsp</td>				
						
							<td>
								<c:if test="${everypro.eventproposal==0 }">
									&nbsp
									 Not Submit
								  	&nbsp
								  		<a href="<%=basePath%>Nusgo/EventProposalLoad.do?proid=${everypro.proid }"   >Submit</a>
									&nbsp 
								</c:if>
								<c:if test="${everypro.eventproposal==1 }">&nbsp Submitted &nbsp   
									<a href="javascript:" onclick="detailone('${everypro.proid}','${everypro.purpostofevent}','${everypro.benefit}','${everypro.predictcost}','${everypro.percent}','${everypro.eventdesc}','${everypro.custcount}','${everypro.giftreason}','${everypro.needapprovalbyleago}' ) "  >check</a>
						
								</c:if>
							&nbsp</td>
							
							<!-- 1.salesManager首次审批 -->
							<td>&nbsp 
								<c:if test="${everypro.eventproposal!=1 }">Unapproved &nbsp</c:if>
								<c:if test="${everypro.eventproposal==1 }">
									<c:if test="${everypro['salesmanagerFirst'] == 0}"> 
									       Unapproved
									  &nbsp
									  <a href="javascript:" onclick="setApproveProid('${everypro.proid }','salesmanagerFirst')"  >Approve</a>
									  &nbsp 
									</c:if>										 
									<c:if test="${everypro['salesmanagerFirst'] == 1}"> Approved  &nbsp </c:if>
									<c:if test="${everypro['salesmanagerFirst'] == 2}"> Modify </c:if>
								</c:if>
						    &nbsp</td> 
						    
						    <!-- 2.marcommanagerFirst首次审批 -->
							<td>&nbsp 
								<c:if test="${everypro.salesmanagerFirst!=1 }">Unapproved &nbsp</c:if>
								<c:if test="${everypro.salesmanagerFirst==1 }">
									<c:if test="${everypro['marcommanagerFirst'] == 0}">
									 Unapproved
								  	&nbsp
								  	<a href="javascript:" onclick="setApproveProid('${everypro.proid }','marcommanagerFirst')"  >Approve</a>
									&nbsp 
									</c:if>										 
									<c:if test="${everypro['marcommanagerFirst'] == 1}"> Approved  &nbsp </c:if>
									<c:if test="${everypro['marcommanagerFirst'] == 2}"> Modify </c:if>
								</c:if>
						    &nbsp</td> 
						    
						    <!-- 3.admin首次审批 -->
							<td>&nbsp 
								<c:if test="${everypro.marcommanagerFirst!=1 }">Unapproved &nbsp</c:if>
								<c:if test="${everypro.marcommanagerFirst==1 }">
									<c:if test="${everypro['adminFirst'] == 0}">
									 Unapproved
								  	&nbsp
								  	<a href="javascript:" onclick="setApproveProid('${everypro.proid }','adminFirst')"  >Approve</a>
									&nbsp  
									</c:if>										 
									<c:if test="${everypro['adminFirst'] == 1}">&nbsp Approved  &nbsp </c:if>
									<c:if test="${everypro['adminFirst'] == 2}">&nbsp Modify </c:if>
								</c:if>
						    &nbsp</td> 
						   
						       <td>   noticed</td>
						    
						    <!-- 5.事后填写 -->
						    <td>&nbsp 
								<c:if test="${everypro.adminFirst==0 }">&nbsp Not Submit  &nbsp</c:if>
								<c:if test="${everypro.adminFirst==1 }">
									<c:if test="${everypro['endoftheevent'] == 0}">&nbsp  Not Submit  &nbsp 
										<a href="<%=basePath%>FactoryNusgo/TheEndOfEventLoad.do?proid=${everypro.proid }"   >Submit</a>
									 &nbsp </c:if>										 
									<c:if test="${everypro['endoftheevent'] == 1}">&nbsp Submitted &nbsp
										<a href="javascript:" onclick="detail1()"  >check</a>
									 </c:if>
								</c:if>
						    &nbsp</td> 
						    
						 
						     <!-- 6.salesManager事后 审批 -->
							<td>&nbsp   
								<c:if test="${everypro['endoftheevent'] == 1}"> 
									 <c:if test="${everypro.salesmanagerSecond !=1  and everypro.salesmanagerSecond  !=2}">&nbsp Unapproved &nbsp
								<a href="javascript:" onclick="setApproveProid('${everypro.proid }','salesmanagerSecond')"  >Approve</a>
								
									&nbsp </c:if>										 
									<c:if test="${everypro['salesmanagerSecond'] == 1}">&nbsp Approved  &nbsp </c:if>
									<c:if test="${everypro['salesmanagerSecond'] == 2}">&nbsp Modify </c:if>
								 </c:if>
								<c:if test="${everypro.endoftheevent!=1 }">&nbsp Unapproved &nbsp</c:if>
									
						    &nbsp</td> 
						    <%--  --%>
						     <!-- 7.adminSecond事后 审批 -->
							<td>&nbsp  
								<c:if test="${everypro.salesmanagerSecond!=1}">&nbsp Unapproved &nbsp</c:if>
								<c:if test="${everypro.salesmanagerSecond==1 }"> 
									<c:if test="${everypro['adminSecond'] == 0}">&nbsp Unapproved &nbsp
									<a href="javascript:" onclick="setApproveProid('${everypro.proid }','adminSecond')"  >Approve</a>
									  &nbsp </c:if>										 
									<c:if test="${everypro['adminSecond'] == 1}">&nbsp Approved  &nbsp </c:if>
									<c:if test="${everypro['adminSecond'] == 2}">&nbsp Modify </c:if>
								</c:if>
						    &nbsp</td> 
						    
						     <!-- 8.marcommanagerSecond事后 审批 -->
							<td>&nbsp  
								<c:if test="${everypro.adminSecond!=1 }">&nbsp Unapproved &nbsp</c:if>
								<c:if test="${everypro.adminSecond==1 }">
									<c:if test="${everypro['marcommanagerSecond'] == 0}">&nbsp Unapproved &nbsp
									<a href="javascript:" onclick="setApproveProid('${everypro.proid }','marcommanagerSecond')"  >Approve</a>
									  &nbsp </c:if>										 
									<c:if test="${everypro['marcommanagerSecond'] == 1}">&nbsp Approved  &nbsp </c:if>
									<c:if test="${everypro['marcommanagerSecond'] == 2}">&nbsp Modify </c:if>
								</c:if>
						    &nbsp</td> 
						    
						     <!-- 9.gcileaderSecond事后 审批 -->
							<td>&nbsp 
								<c:if test="${everypro.marcommanagerSecond!=1 }">&nbsp Unapproved &nbsp</c:if>
								<c:if test="${everypro.marcommanagerSecond==1 }">
									<c:if test="${everypro['gcileaderSecond'] == 0}">&nbsp Unapproved &nbsp
									<a href="javascript:" onclick="setApproveProid('${everypro.proid }','gcileaderSecond')"  >Approve</a>
									&nbsp </c:if>										 
									<c:if test="${everypro['gcileaderSecond'] == 1}">&nbsp Approved  &nbsp </c:if>
									<c:if test="${everypro['gcileaderSecond'] == 2}">&nbsp Modify </c:if>
								</c:if>
						    &nbsp</td> 						
						</tr>
					</c:forEach>
			</table>

		</div>
		</div>
		
		<div align="right" style="margin: 15px;">
			<pg:pager items="${total }" url="Nusgo/list.do" maxIndexPages="3" export="currentPageNumber=pageNumber" scope="request">			
				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		
		</div>
	</form>
	
	
	<!-- Modal add-->
	<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form  name="addForm" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Add Project</h4>
						
					</div>
					
					<div class="modal-body">
					
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Event Name:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="eventname"  placeholder="Event Name" value=""   />
							</div>
						</div>
					</div>
					
					
					<div class="row" style="padding:5px" >	
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Event Date:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" onclick="WdatePicker({maxDate:'%y-%M-{%d-1}'})" name="eventdate" data-rule="eventdate:required;" placeholder="Event Date" />
							</div>
						</div>
					</div>
						
				
						
						<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Purpose of Event:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="purpostofevent" id="custcount" placeholder="Purpose of Event" value=""  />
							</div>
						</div>
						</div>
						
						<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Expected impact/benefit to Caterpillar:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="eventname"  placeholder="Event Name" value=""   />
							</div>
						</div>
					</div>
						
						<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">Estimated event total cost:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="predictcost" id="custcount" placeholder="predictcost" value=""  />
							</div>
						</div>
						</div>
						
					<div class="row" style="padding:5px" >		
						<div class="form-group-sm">
							<label class="col-sm-4 control-label">	Co-share agreement with Caterpillar (%):</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="eventname"  placeholder="Event Name" value=""   />
							</div>
						</div>
					</div>
						
						<div class="row" style="padding:5px" >		
							<div class="form-group-sm">
								<label class="col-sm-4 control-label">Estimated Reimbursement Amount:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="predictbxcost" id="custcount" placeholder="Estimated Reimbursement Amount" value=""   />
								</div>
							</div>
						</div>
					
				</div>
					
					<div class="modal-footer">
						<input type="button" id="subadd" class="btn btn-primary" value="OK">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	
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





