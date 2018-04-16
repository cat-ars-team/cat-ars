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
			<li style="background-color:#4e4e4e; font-weight:600;font-size:17px ;color:#bababa">At the end of the Event
</li>

		</ul>		
	</div>
	
	<center style="margin-top:15px">
	<form action="<%=basePath%>FactoryNusgo/TheEndOfEvent.do" name="EventForm" id="EventForm" method="post" class="form-horizontal" enctype="multipart/form-data">
	
	<%-- 
		<hr><center> <span style="font-weight:600;font-size:17px ;color:black">Event Proposal</span>  </center><hr>
		 --%>				
	 <hr>
					<center> <span style="font-weight:600;font-size:18px ;color:black">Post-event Details</span>  </center> 
		<hr>
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
					<label class="col-sm-4 control-label"> Actual spent:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="proDate" value='${Project.roleid }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Actual date of Event:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="eventname" value='${Project.eventname }'  readonly >
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Amount payable by Caterpillar:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="eventdate" value='${Project.eventdate }'  readonly >
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Event detail:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="eventdesc"  >
					</div>
				</div>
			</div>
			
			
			


			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Prospect & Sales Generated:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="eventdesc"  >
					</div>
				</div>
			</div>
			
		 
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Attendance List:</label>
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
					<label class="col-sm-4 control-label">Event Photo(1)</label>
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
					<label class="col-sm-4 control-label">Event Photo(2)</label>
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
					<label class="col-sm-4 control-label">Event Photo(3)</label>
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
					<label class="col-sm-4 control-label">Event Invoice</label>
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
					<center> <span style="font-weight:600;font-size:18px ;color:black">NUSGO Checklist</span>  </center> 
		<hr>
			
			
				<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">NUSGO name list </label>
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
			
<%-- 					<hr>
					<center> <span style="font-weight:600;font-size:18px ;color:black">No. of Intended NUSGO</span>  </center> 
					<hr> --%>
		
				<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">NUSGO name list (name, title, company):</label>
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
					<label class="col-sm-4 control-label">Total NUSGO expenses from Caterpillar (Amount to book into 2705/2710):</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="custcount"  >
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Name of person providing Business Courtesy to NUSGO :</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="custcount" placeholder="Dealer or employee name" >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Date of expense :</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="custcount" placeholder="Dealer or employee name" >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Where did the expense occur (name of restaurant, hotel,.. and city):</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="giftreason" >
					</div>
				</div>
			</div>	
		 
			 
		<c:if test="${1 == 1}">  
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">Legal pre-approval obtained? (Y/N):</label>
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
			
			 </c:if>
			
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