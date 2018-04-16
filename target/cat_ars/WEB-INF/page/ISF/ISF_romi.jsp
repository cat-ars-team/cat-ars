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
<script type="text/javascript" src="<%=basePath%>res/js/MyGloable.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/common.js"></script>

<style>
	label{
		font-size:15px;
	}
</style>

<script type="text/javascript">

	
	
	//-----------------------------------------------------------
	//计算客户总人数
	// regisCust=currCust+potenCust 
	
	function countCusTom(obj){
		var currCust = $('#currCust').val();
		var potenCust = $('#potenCust').val();
		if(!checkOnlyNumAndZero(obj)){
			currCust = currCust != "" ? parseInt(currCust) : 0;
			potenCust = potenCust != "" ? parseInt(potenCust) : 0;
			$('#regisCust').val( currCust + potenCust );
		}
	}
	//-----------------------------------------------------------
	




	$(function(){
		$('#tijiao-bt').click(function(){
			$('#add-div-9').css('display','block');
		})
		//$('#tja').click(function(){
		//	$('#add-div-9').css('display','none')
		//})
		$('#close1').click(function(){
			$('#add-div-9').css('display','none')
		});
	});
	function romiSubmit(){

		var valCk = '';
		$('input[type=checkbox]').each(function(){
			valCk += $(this).val() + ',';
		});

		valCk = valCk.substring(0, valCk.length - 1);
		
		if(checkNumAndPro() && checkWinOrderAndMac()){
			//document.forms['romiForm'].action = "${webapp}/romi_save.action";
			//ajaxAnywhere.formName = "romiForm";
			//ajaxAnywhere.submitAJAX();

				/* $("#romiForm").ajaxSubmit({
				type : 'post',
				url : '${webapp}/romi_save.action',
				data : { 'valCk' : valCk },
				success : function(data){
					var str = eval(data);
					if(str[3] == 1){
						alert('无法匹配到机型，请重新输入！');
						return false;
					}else{
						if(str[4]==0)
						{
							$("#BgDiv").css({ display: "block", height: $(document).height() });
						    $('#add-div-9').css('z-index','100001');
							$('#add-div-9').css('display','block');
						    $('#MoneyForNum').html(str[0]);
						    $('#proMoney75').html(str[1]);
						    $('#bxMoney').html(str[2]);
						}else{
							$('#add-div-9ys').css('display','block');
						    $('#MoneyForNumys').html(str[0]);
						    $('#proMoney75ys').html(str[1]);
						    $('#bxMoneyys').html(str[2]);
						    $('#bxMoneyyss').html(str[2]+" 元");
						}
					}
				}
			}); */
			
			
			alert(1);
		}
	}

	function cancelRomi(proID){
		$.ajax({
			url : '${webapp}/romi_cancel.action',
			type : 'post',
			data : { 'romi.proId' : proID },
			success : function(){
				window.location.href = '${webapp}/pro_find.action';
			}
		});
	}
	
	
	function countOppor(obj){
		var discMac = $('#discMac').val();
        var deteQua = $('#deteQua').val();
        var formPlan = $('#formPlan').val();
        var deveProg = $('#deveProg').val();
        if(!checkOnlyNumAndZero(obj)){
        	discMac = discMac != "" ? parseInt(discMac) : 0;
        	deteQua = deteQua != "" ? parseInt(deteQua) : 0;
        	formPlan = formPlan != "" ? parseInt(formPlan) : 0;
        	deveProg = deveProg != "" ? parseInt(deveProg) : 0;
        	$('#openOppor').val( discMac + deteQua + formPlan + deveProg );
        }
	}
	function countSaleldConrate(obj){
		var newSaleld = $('#newSaleld').val();
		var regisCust = $('#regisCust').val();
		if(!checkOnlyNumAndZero(obj)){
			newSaleld = newSaleld != "" ? parseInt(newSaleld) : 0;
			regisCust = regisCust != "" ? parseInt(regisCust) : 0;
			$('#saleldConrate').val( ((newSaleld / regisCust) * 100).toFixed(2) );
		}
	}
	//"赢单"失去焦点事件
	function countTotalMac(obj){
		var openOppor = $('#openOppor').val();	//开启商机
		var winOrder = $('#winOrder').val();
		var lostSales = $('#lostSales').val();
		var noTrans = $('#noTrans').val();
		var winOrders = $('#winOrders').val();
		
		if(!checkOnlyNumAndZero(obj)){
			openOppor = openOppor != "" ? parseInt(openOppor) : 0;
			winOrder = winOrder != "" ? parseInt(winOrder) : 0;
			lostSales = lostSales != "" ? parseInt(lostSales) : 0;
			noTrans = noTrans != "" ? parseInt(noTrans) : 0;
			winOrders = winOrders != "" ? parseInt(winOrders) : 0;
			$('#totalMac').val( openOppor + winOrder + lostSales + noTrans + winOrders );
		}
		
		countMacgenRate();
	}
	//计算商机产生率
	function countMacgenRate(){
		var regisCust = $('#regisCust').val();
		var totalMac = $('#totalMac').val();
		totalMac = totalMac != "" ? parseInt(totalMac) : 0;
		regisCust = regisCust != "" ? parseInt(regisCust) : 0;
		
		if(regisCust == 0)
			$('#macGenRate').val(0);
		else
			$('#macGenRate').val( ((totalMac / regisCust) * 100).toFixed(2) );
	}
	
	function checkNumAndPro(){
		var currCust = $('#currCust').val();
		var potenCust = $('#potenCust').val();
		var custNum = $('#custNum').val();
		
		currCust = currCust != "" ? parseInt(currCust) : 0;
		potenCust = potenCust != "" ? parseInt(potenCust) : 0;
		if(parseInt(potenCust) + parseInt(currCust) != parseInt(custNum)){
			alert('您填写的客户人数与项目人数不符合,请重新填写!');
			return false;
		}
		return true;
	}

	function checkWinOrderAndMac(){
		var winOrder = $('#winOrder').val();	//赢单
		var flag = true;
		if(winOrder > 0){
			$('.macType').each(function(){
				if($(this).val() == ''){
					alert('赢单数为' + winOrder + ',请填写相应的机型资料');
					flag = false;
					return false;
				}
			});
		}
		return flag;
	}

	//获取指定控件的坐标
	function getCoordinate(id) {
		obj = document.getElementById(id)
		var l = obj.offsetLeft;
		var t = obj.offsetTop;
		while(obj.offsetParent){
			obj = obj.offsetParent;
			l += obj.offsetLeft;
			t += obj.offsetTop;
		}
		return l;
	}

	function getAbsoluteLeft(id){
		obj = document.getElementById(id);
        var mendingLeft = obj.offsetLeft;
        while( obj != null && obj.offsetParent != null && obj.offsetParent.tagName != "BODY" ){
            mendingLeft += obj.offsetParent.offsetLeft;
            obj = obj.offsetParent;
        }
        return mendingLeft ;
    }

  	//自动提示
  	jQuery(document).ready(function(){
  		//var leftNum = jQuery('.macType').offset().left;
  		//var leftNum = getAbsoluteLeft('macType4Left');
  		jQuery('.macType').hintbox({
	      	url: '${webapp}/romi_autoSelect.action',
  			json: true,
  			hintboxContainerClass:"hintbox_list_container",
  			onListLoaded:function(){
  				$('.hintbox_list_container').css('left', 714);
  			}
	    });
  	});
  
  	var i = 0;
  	function addMacType(){
  	  	i++;
  	  	var data = "<div class='form-group'>"
  	  				+" <label  class='col-sm-4 control-label'>机器型号：</label> "
  	  				+"<div class='col-sm-2'>"
  	  				+	" <input class='form-control'  onkeyup='checkOnlyNumAndZero(this)' type='text' name='' placeholder='请输入...' > "
  	  				+" </div>"
					+"<label  class='col-sm-1 control-label'>数量:</label> "
  	  				+"<div class='col-sm-1'>" 
					+"<input class='form-control' onkeyup='checkOnlyNumAndZero(this)' type='text' name='' id='dodCustnum'   placeholder='请输入...' >"
					+"</div>"
					+" <div class='col-sm-2 control-label' style='text-align:left'>"
					+" <input type='checkbox' value='0' id='isOldMac' name='isOldMac' style='color:#fff;' onclick='setOldMac(this)' />"
					+"<label for='isOldMac'>二手机</label>&nbsp&nbsp" 
					+"<input type='button' class='btn btn-danger btn-xs'   onclick='deleteMacType(this)'  value='删除'/>"
					+"</div> </div>";
		$('#addMacType').append(data);
		parent.changeFrameHeight();
		
  	}
  	function deleteMacType(obj){
  	  	obj.parentNode.parentNode.removeNode(true);
  	  	parent.changeFrameHeight();
  	}
  	function forward(){
  	  	window.location.href = '${webapp}/pro_find.action';
  	  	$('#add-div-9').css('display','none')
  	}
  	//设置是否为二手机
  	function setOldMac(obj){
		if($(obj).is(':checked'))
			$(obj).val('1');
		else
			$(obj).val('0');
  	}
  	
	</script>


<script type="text/javascript">
function bxyl(id){
	document.forms["romiForm"].action="<%=basePath%>ISF/bxyl.do?proid="+id;
	document.forms["romiForm"].submit();
	}
</script>
</head>
<body>

<span>${err} </span>
	<div style="padding: 0px; margin: 0;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li><a href="<%=basePath%>ISF/list.do" class="btn btn-warning">返回上一级</a></li>
			<li>项目管理</li>
			<li>ISF</li>
			<li>ROMI输入</li>
			
		</ul>
		
	</div>
	
	<center style="margin-top:15px">
	
	<b><label style="font-size:18px;">${Project.proid }</label></b>
	<hr>
	<form action="<%=basePath%>ISF/romiadd.do" method="post" class="form-horizontal">
		<input type="hidden" name="proId" value="${Project.proid }" />
		<input type="hidden" name="agntId" value="${Project.roleid }" />
		
		<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">现有客户:</label>
					<div class="col-sm-3">
					<input class="form-control" type="text" onkeyup="countCusTom(this)" name="currCust" id="currCust" value='${romi.currCust }' placeholder="请输入..."  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">新的潜在客户: </label>
					<div class="col-sm-3">
					<input class="form-control" type="text"  onkeyup="countCusTom(this)" name="potenCust" id="potenCust" value='${romi.potenCust }' placeholder="请输入..."    >
					</div>
				</div>
			</div>
			<!-- regisCust=currCust+potenCust -->
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">展会签到人数 :</label>
					<div class="col-sm-3">
						<input readonly class="form-control" type="text" name="regisCust" id="regisCust" value='${romi.regisCust }'  >
					</div>
					<div class="col-sm-3  control-label" style="text-align: left;">*(现有客户+新的潜在客户)</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">产生的销售线索:</label>
					<div class="col-sm-3">
					<input class="form-control" type="text" onkeyup="countSaleldConrate(this)" name="newSaleld" id="newSaleld" value='${romi.newSaleld }' placeholder="请输入..."   >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">销售线索转化率:</label>
					<div class="col-sm-3">
						<input readonly class="form-control" type="text" name="saleldConrate" id="saleldConrate" value='${romi.saleldConrate }'   >
					</div>
					<div class="col-sm-3 control-label" style="text-align: left;">*(产生的销售线索÷展会签到人数)</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">识别商机:</label>
					<div class="col-sm-3">
					<input class="form-control" onkeyup="countOppor(this)" type="text" name="discMac" id="discMac" value='${romi.discMac }'  placeholder="请输入..."  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">资质判定:</label>
					<div class="col-sm-3">
					<input class="form-control" onkeyup="countOppor(this)" onkeyup="countOppor(this)" type="text" name="deteQua" id="deteQua" value='${romi.deteQua }'  placeholder="请输入..."  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">制定计划:</label>
					<div class="col-sm-3">
					<input class="form-control" onkeyup="countOppor(this)" type="text" name="formPlan" id="formPlan" value='${romi.formPlan }'  placeholder="请输入..."  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-4 control-label">制定方案:</label>
					<div class="col-sm-3">
					<input class="form-control" onkeyup="countOppor(this)" type="text" name="deveProg" id="deveProg" value='${romi.deveProg }'  placeholder="请输入..."   >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">开启商机:</label>
					<div class="col-sm-3">
						<input readonly class="form-control" type="text" name="openOppor" id="openOppor" value='${romi.openOppor }' >
					</div>
					<div class="col-sm-3 control-label" style="text-align: left;">*(识别商机+资质判定+制定计划+制定方案)</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">赢单:</label>
					<div class="col-sm-3">
						<input   class="form-control" onkeyup="countTotalMac(this)" type="text" name="winOrder" id="winOrder" value='${romi.winOrder }' placeholder="请输入..."  >
					</div>
					<div class="col-sm-3 control-label" style="text-align: left;">*(GCI)</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">赢单:</label>
					<div class="col-sm-3">
						<input   class="form-control" onkeyup="countTotalMac(this)" type="text" name="winOrders" id="winOrders" value='${romi.winOrders }' placeholder="请输入..."  >
					</div>
					<div class="col-sm-3 control-label" style="text-align: left;">*(BCP)</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">失单:</label>
					<div class="col-sm-3">
						<input class="form-control" onkeyup="countTotalMac(this)" type="text" name="lostSales" id="lostSales" value='${romi.lostSales }' placeholder="请输入..."  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">无交易:</label>
					<div class="col-sm-3">
						<input class="form-control" onkeyup="countTotalMac(this)" type="text" name="noTrans" id="noTrans" value='${romi.noTrans }' placeholder="请输入..." >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">产生的商机总数:</label>
					<div class="col-sm-3">
						<input readonly class="form-control" type="text" name="totalMac" id="totalMac" onchange="countTotalMac(this)" value='${romi.totalMac }'  >
					</div>
					<div class="col-sm-3 control-label" style="text-align: left;">*(仍处于漏斗中的商机+赢单+失销+无交易)</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">商机生产率:</label>
					<div class="col-sm-3">
						<input readonly class="form-control" type="text" name="macGenRate" id="macGenRate" value='${romi.macGenRate }'  >
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">现场交付定金的客户数量:</label>
					<div class="col-sm-3">
						<input class="form-control"   onkeyup="checkOnlyNumAndZero(this)" type="text" name="dodCustnum" id="dodCustnum" value='${romi.dodCustnum }' placeholder="请输入..." >
					</div>
				</div>
			</div>
			
			
			<!-- 现有客户
 			 
		  
			
			签单机器情况： 签单机器情况：  数量：
			
			预览 提交 取消 -->
			
			
			
			
			<!-- 现有客户
			新的潜在客户  
			展会签到人数 （现有客户+新的潜在客户）
			产生的销售线索
			销售线索转化率 （产生的销售线索÷展会签到人数）
			识别商机
			资质判定
			制定计划
			制定方案
			开启商机 (识别商机+资质判定+制定计划+制定方案)
			赢单(GCI)
			赢单(BCP)
			失单
			无交易
			产生的商机总数 (仍处于漏斗中的商机+赢单+失销+无交易)
			商机生产率
			现场交付定金的客户数量
			
			签单机器情况： 签单机器情况：  数量：
			
			预览 提交 取消 -->
			
		</div>
		
		
		<hr>
			<div class="row" style="margin-top:5px">
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label" style="font-size:20px;font-weight:bold;">
						签单机器情况
					</label>
					 
					
					 
					<div class="col-sm-5 control-label">
						<input type="button" class="btn btn-warning" value="再添加一个机型"  onclick="addMacType()"  />
					</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="form-group">
					<label  class="col-sm-4 control-label">机器型号：</label>
					<div class="col-sm-2">
						<input class="form-control"   onkeyup="checkOnlyNumAndZero(this)" type="text" name="" id="dodCustnum" value='${romi.dodCustnum }' placeholder="请输入..." >
					</div>
					
					<label  class="col-sm-1 control-label">数量:</label>
					<div class="col-sm-1">
						<input class="form-control"   onkeyup="checkOnlyNumAndZero(this)" type="text" name="" id="dodCustnum" value='${romi.dodCustnum }' placeholder="请输入..." >
					</div>
					<div class="col-sm-1 control-label">
					<input type="checkbox" value="0" id="isOldMac" name="isOldMac" style="color:#fff;" onclick="setOldMac(this)" /><label for="isOldMac">二手机</label>
					</div>
					
				</div>
			</div>
			
			<div class="col-sm-12" id="addMacType">
			
			</div>
			
		</div>
			
			
			
			
			
			
			
			
			
		
		
		<div class="modal-footer">
				<center>
						<a href="<%=basePath%>ISF/list.do" class="btn btn-info" onclick="bxyl('${Project.proid }')">预&nbsp&nbsp&nbsp览</a>&nbsp&nbsp&nbsp
						<button type="submit" id="selected" class="btn btn-warning">提&nbsp&nbsp&nbsp交 </button>&nbsp&nbsp&nbsp
						<a href="<%=basePath%>ISF/list.do" class="btn btn-info">取&nbsp&nbsp&nbsp消</a>
				</center>
			</div>
		
	</form>
	
	</center>			
	

  </body>
</html>