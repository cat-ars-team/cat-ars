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
<link rel="stylesheet" href="<%=basePath%>res/css/fileinput.min.css"> 
<link rel="stylesheet" href="<%=basePath%>res/css/MyGloable.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=basePath%>res/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/zh.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/MyGloable.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/common.js"></script>

<style>
	label{
		font-size:15px;
	}
</style>

	<script type="text/javascript">

	$(function(){
	// 注册 批准 
	 $("#sub").click(function() {   
			//	document.forms["approveModal"].action="<%=basePath%>ISF/approve.do";
				document.forms["EventForm"].submit();
	 })
	})
	</script>


</head>
<body>
	
	<div style="padding: 0px; margin: 0px"> 
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;background-color:#4e4e4e">
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">Project Manage</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">Nusgo</li>
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">Purpose of Event
</li>

		</ul>		
	</div>
	
	<center style="margin-top:15px">
	<form action="<%=basePath%>FactoryNusgo/EventProposal.do" name="EventForm" id="EventForm" method="post" class="form-horizontal" enctype="multipart/form-data">
	
	
		<hr><center> <span style="font-weight:600;font-size:17px ;color:black">Event Proposal</span>  </center><hr>
					
	 
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Nusgo ID:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="proid" value='${Project.proid }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Purpose of Event:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="purpostofevent" value='${Project.purpostofevent }'   >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Expected impact/benefit to Caterpillar:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="benefit" value='${Project.benefit }'  >
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Estimated event total cost:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="predictcost" value='${Project.predictcost }'  readonly >
					</div>
				</div>
			</div>
		
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Co-share agreement with Caterpillar (%):</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="percent"  >
					</div>
				</div>
			</div>
			
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Estimated reimbursement cost:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="predictbxcost"  >
					</div>
				</div>
			</div>
			
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Event Description:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="eventdesc"  >
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Number of invitees:</label>
					<div class="col-sm-5">
						<input type="hidden" name="importproid" id="hideProID"> 
					<!-- 	<input type="file" name="file" />  -->
						<input id="fapiao" type="file" class="file"  name="files"
						 style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">No. of Intended non-NUSGO invitees (title, company):</label>
					<div class="col-sm-5">
						<input type="hidden" name="importproid" id="hideProID"> 
					<!-- 	<input type="file" name="file" />  -->
						<input id="fapiao" type="file" class="file"  name="files"
						 style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >
					</div>
				</div>
			</div>
			
			
					<hr>
					<center> <span style="font-weight:600;font-size:18px ;color:black">NUSGO Details</span>  </center> 
					<hr>
			
		
				<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">No. of Intended NUSGO:</label>
					<div class="col-sm-5">
						<input type="hidden" name="importproid" id="hideProID"> 
					<!-- 	<input type="file" name="file" />  -->
						<input id="fapiao" type="file" class="file"  name="files"
						 style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Planned Business Courtesy amount ($):</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="custcount"  >
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">What do you intend to give?</label>
					<div class="col-sm-5">
						<input type="hidden" name="importproid" id="hideProID"> 
					<!-- 	<input type="file" name="file" />  -->
						<input id="fapiao" type="file" class="file"  name="files"
						 style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["xls"]' >
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Reason:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="giftreason" >
					</div>
				</div>
			</div>	
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Legal Pre-Approval needed? (Y/N)</label>
					<div class="col-sm-5">
					<select name="needapprovalbyleago" class="form-control">
						<option value="">--Select--</option>
						<option value="1">Yes</option>
						<option value="0">NO</option>
					</div>
				</div>
			</div>	
			
			 	 
		</div>
		<hr>
			<div class="modal-footer">
				<center>
				<input type="button" id="sub" style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838"  value="Submit" class="btn btn-sm btn-default" /> 
				<a  style="background-color:#424040; color:white;font-weight:600;border:2px solid #393838" href="<%=basePath%>FactoryNusgo/list.do" class="btn btn-sm btn-info">Cancel</a>
				</center>
			</div>
		
			
	
	</form>
	</center>
	
	
	
	
	
	

</body>
</html>