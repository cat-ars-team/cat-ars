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
	// 项目添加结果
   var flag = '${jbxxResult.flag }';
   var Message = '${jbxxResult.messageStr }';
   

  if(Message==''  ){
	   return;
   }else if(flag=== '0'){		   
	   alert(Message);   
   }else if(Message!=''){
	   alert(Message); 
   }
    
}); 


function checkData(){
	
	//给选中的checkbox重新赋值
	$('.produteSupport').each(function(){
		if($('input[type=checkbox][class=produteSupport]:checked')){
			$(this).val('1');
		}
	});
	$('.mcManage').each(function(){
		if($('input[type=checkbox][class=mcManage]:checked')){
			$(this).val('1');
		}
	});
	$('.showCat').each(function(){
		if($('input[type=checkbox][class=showCat]:checked')){
			$(this).val('1');
		}
	});
	$('.showRz').each(function(){
		if($('input[type=checkbox][class=showRz]:checked')){
			$(this).val('1');
		}
	});			


	//取得设计行业数量
	var indusNum = $('#indusNum').val();
	// 取得选中的checkbox的个数
	var length1 = $('input[type=checkbox][class=produteSupport]:checked').length;	//产品支持
	var length2 = $('input[type=checkbox][class=mcManage]:checked').length;			//设备管理
	var length3 = $('input[type=checkbox][class=showCat]:checked').length;			//租赁及二手机
	var length4 = $('input[type=checkbox][class=showRz]:checked').length;			//卡特融资租赁
	var num1 = $('#dynaDomo').val();	//动态Demo
	var num2 = $('#staticDemo').val();	//静态Demo
	var money = $('#proMoney').val();
	
	
	
	 var indusSeg = '${levelInfo.indusSeg }';
	 var peodSup='${levelInfo.peodSup }';
	 var techMang='${levelInfo.techMang }';
	 var demo='${levelInfo.demo }';
	 var demoStac='${levelInfo.demoStac }';
	 var rentUsed='${levelInfo.rentUsed }';
	 var catRat='${levelInfo.catRat }';
	
	
	
	if(indusNum < indusSeg){
		alert('至少' + indusSeg + '个涉及行业!');
		return false;
	}
	if(length1 < peodSup){
		alert('请选择至少' + peodSup + '项产品支持!');
		return false;
	}
	if(length2 < 2 && techMang != 'no'){
		alert('设备管理必须全部支持!');
		return false;
	}
	if(num1 < demo && demo != 0){
		alert('至少' + demo + '台动态演示');
		return false;
	}
	if(demoStac != 0){
		if(num2 == ''){
			alert('请填写静态展示的数量!');
			return false;
		}
		var demoStatic = demoStac.split(',');
		if(demoStatic.length > 1){
			if(num2 < demoStatic[0] || num2 > demoStatic[1]){
				alert('至少' + demoStatic[0] + '-' + demoStatic[1] + '台静态展示');
				return false;
			};
		}else{
			if(num2 < demoStatic[0]){
				alert('至少' + demoStatic[0] + '台静态展示');
				return false;
			};
		};
	}
	if(length3 < 1 && rentUsed != 'no'){
		alert('租赁及二手机必须选择!');
		return false;
	}
	if(length4 < 1 && catRat != 'no'){
		alert('卡特融资租赁必须选择!');
		return false;
	}
	var fileJPG1 = $('#fileJPG1').val();
	var fileJPG2 = $('#fileJPG2').val();
	var fileJPG3 = $('#fileJPG3').val();
	if(fileJPG1 == '' || fileJPG2 == '' || fileJPG3 == ''){
		alert('请上传至少3张活动照片');
		return false;
	}
	var fapiao = $('#fapiao').val();
	if(fapiao == ''){
		alert('请上传发票正面照');
		return false;
	}
	if(money == ''){
		alert('项目金额不能为空!');
		return false;
	}
	if(money == 0){
		alert('请输入合法的项目金额!');
		return false;
	}
	
	return true;
}



function submitBx(){
	if(checkData()){
		var produteSupportLen = $('input[type=checkbox][class=produteSupport]:checked').length;
		var mcManageLen = $('input[type=checkbox][class=mcManage]:checked').length;
		var showCatLen = $('input[type=checkbox][class=showCat]:checked').length;
		var showRzLen = $('input[type=checkbox][class=showRz]:checked').length;
		
		$('#produteSupportLen').val(produteSupportLen);
		$('#mcManageLen').val(mcManageLen);
		$('#showCatLen').val(showCatLen);
		$('#showRzLen').val(showRzLen);
		
		
	}
}



		
		
		$(document).ready(function(){
			$("#sub").click(function(){
				
				 checkAndSubmit();
				});
			
		})
		
		function checkAndSubmit(){
			if(checkData()){
				document.forms["jbxxForm"].action="<%=basePath%>ISF/jbxx.do";
				document.forms["jbxxForm"].submit();
			}
		}
		
		

		function checkProMoney(obj){
			var agntId = $('#agnId').val();
			var proType = $('#proType').val();
			$.ajax({
				url : '${webapp}/cus_getMoney.action',
				type : 'post',
				data : { 'agntId' : agntId, 'proType' :  proType},
				success : function(data){
					var str = eval(data);
					if(parseInt(obj.value) > parseInt(str)){
						alert('您所能报销的最大金额为:' + str);
						obj.select();
						return false;
					}
				}
			});
		}
		
		
	</script>


</head>
<body>
	<div style="padding: 0px; margin: 0;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li><a href="<%=basePath%>ISF/list.do" class="btn btn-warning">返回上一级</a></li>
			<li>项目管理</li>
			<li>ISF</li>
			<li>报销-基本信息</li>
			
		</ul>
		
	</div>
	
	<center style="margin-top:15px">
	<form action="" id="jbxxForm" name="jbxxForm" method="post" class="form-horizontal" enctype="multipart/form-data">
	 
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">项目编号:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="proId" value='${Project.proid }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">项目类型:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="protype" value='${Project.protype }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">级别:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="proLevel"  value='${Project.level }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">客户人数:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="custNum" value='${Project.custcount }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">项目时间:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text"  name="proDate" value='${Project.protime }'  readonly >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">		
					<label class="col-sm-4 control-label">省份:</label>
					<div class="col-sm-2">
					<input class="form-control" type="text"  name="proPlace" value='${Project.proprovince }'  readonly >
					</div>
					
					<label class="col-sm-1 control-label">城市:</label>
					<div class="col-sm-2">
					<input class="form-control" type="text"  name="proPlaced" value='${Project.procity }'  readonly >
					</div>
				</div>
			</div>
				
		</div>
		<hr>
		
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">涉及行业数量:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" id="indusNum" name="indusNum">
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
				<table class="jbxx-con2">
            	<tr class="cord8">
                	<td class="one" rowspan="7">产品支持</td>
                    <td class="two">零件产品展</td>
                    <td class="three"><input type="checkbox" name="partsShow" class="produteSupport" value="0" /></td>
                </tr>
                <tr class="cord8">
                	<td>零件促销项目&零件柜台</td>
                    <td><input type="checkbox" name="partsPromo" class="produteSupport" value="0" /></td>
                </tr>
                 <tr class="cord8">
                	<td>零件库房展示/参观</td>
                    <td><input type="checkbox" name="partsWh" class="produteSupport" value="0" /></td>
                </tr>
                 <tr class="cord8">
                	<td >服务车间展示/参观</td>
                    <td><input type="checkbox" name="serviceWs" class="produteSupport" value="0" /></td>
                </tr>
                <tr class="cord8">
                	<td >工具和防污染控制展示</td>
                    <td><input type="checkbox" name="toolsPollu" class="produteSupport" value="0" /></td>
                </tr>
                 <tr class="cord8">
                	<td >特种服务车展示</td>
                    <td><input type="checkbox" name="speServices" class="produteSupport" value="0" /></td>
                </tr>
                 <tr class="cord8">
                	<td>服务促销项目</td>
                    <td><input type="checkbox" name="promotion" class="produteSupport" value="0" /></td>
                </tr>
                 <tr class="cor8d8d">
                	<td rowspan="2" class="cor36 one">设备管理</td>
                    <td>Cat 智能展示</td>
                    <td><input type="checkbox" name="gpsShow" class="mcManage" value="0" /></td>
                </tr>
                 <tr class="cor8d8d">
                	<td>介绍/展示</td>
                    <td><input type="checkbox" name="introDemo" class="mcManage" value="0" /></td>
                </tr>
                 <tr class="c0">
                	<td rowspan="2" class="one">样机</td>
                    <td>Demo演示（动态）&nbsp;<label style="font-size:12px;font-weight:normal;color:red;">请输入数量，数量为整数</label></td>
                    <td><input type=text class="text demoShow" name="dynaDemo" onkeyup="checkNum(this)" id="dynaDomo" /></td>
                </tr>
                 <tr class="c0">
                    <td>静态展示&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="font-size:12px;font-weight:normal;color:red;">请输入数量，数量为整数</label></td>
                    <td><input type=text class="text demoShow" name="staticDemo" onkeyup="checkNum(this)" id="staticDemo" /></td>
                </tr>
                 <tr class="cor8d8d">
                	<td rowspan="2" class="one">租赁及二手机</td>
                    <td  rowspan="2">咨询台或展示台</td>
                    <td rowspan="2"><input type="checkbox" name="showcaseCat" class="showCat" value="0" /></td>
                </tr>
                 <tr class="cor8d8d">
                </tr>
                 <tr class="corc4">
                	<td rowspan="2" class="one">卡特融资租赁</td>
                    <td rowspan="2">咨询台或展示台</td>
                    <td rowspan="2"><input type="checkbox" name="showcaseRu" class="showRz" value="0" /></td>
                </tr>
                 <tr class="corc4">
                </tr>
            </table>
				</div>
			</div>
		
		
		</div>
		
		<hr>
		
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
				<label class="col-sm-4 control-label">活动照片一：</label>
					<div class="col-sm-5"> 
							<input id="fileJPG1" type="file" class="file"  name="files"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
						data-allowed-file-extensions='["jpg","jpeg"]' >		
					 
					</div>
				
				</div>
			</div>
		</div>
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
				<label class="col-sm-4 control-label">活动照片二：</label>
					<div class="col-sm-5">
							<input id="fileJPG2" type="file" class="file"  name="files"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
						data-allowed-file-extensions='["jpg","jpeg"]' >		
					</div>
				
				</div>
			</div>
		</div>
		
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
				<label class="col-sm-4 control-label">活动照片三：</label>
					<div class="col-sm-5">
						<input id="fileJPG3" type="file" class="file"  name="files"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
						data-allowed-file-extensions='["jpg"]' >					

					</div>
				
				</div>
			</div>
		</div>
		
		
		
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
				<label class="col-sm-4 control-label">发票正面照：</label>
					<div class="col-sm-5">
						<input id="fapiao" type="file" class="file"  name="files"
							data-show-preview="false" 
								data-show-upload="false" 
									data-show-caption="true"  
										data-allowed-file-extensions='["pdf"]' >
						
					</div>
				
				</div>
			</div>
		</div>
		
		<div class="row" style="margin-top:5px">
		<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">项目总金额:</label>
					<div class="col-sm-4">
					<input class="form-control" type="text" name=totalCust id="proMoney" >
					</div>
				</div>
			</div>
		</div>
		
		
		
			<div class="modal-footer">
				<center>
				          
						<button type="button" id="sub" class="btn btn-warning">下一步</button>&nbsp&nbsp&nbsp
						<a href="<%=basePath%>ISF/list.do" class="btn btn-info">取&nbsp&nbsp&nbsp消</a>
				</center>
			</div>
		
			<input type="hidden" id="produteSupportLen" name="prdcSupp" /><!-- 产品支持 -->
            <input type="hidden" id="mcManageLen" name="macMang" /><!-- 设备管理 -->
            <input type="hidden" id="showCatLen" name="ratUsed" /><!-- 租赁二手机 -->
            <input type="hidden" id="showRzLen" name="catFl" /><!-- 卡特融资租赁 -->
	
	
	</form>
	</center>
	
	
	
	
	
	

</body>
</html>