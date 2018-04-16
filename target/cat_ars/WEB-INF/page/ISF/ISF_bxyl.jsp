<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ISF_bxyl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<div class="bxyl-one">
            	<input type="image" class="bxly-xm" src="${webapp}/systemMain/images/bxly-xm.png" onclick="" />
        		<span>项目:${mol005.proId}&nbsp;时间:${mol005.protime}&nbsp;地点:${mol005.proPlace}&nbsp;${mol005.proPlaced}&nbsp;人数:${mol005.custNum}</span>
                <table class="bxyl-tab"  style="cellspacing=0, cellpadding=0">
                	<tr class="tab-th">
                    	<th class="tab-l"></th>
                        <th class="no-border"></th>
                        <th colspan="7">产品支持</th>
                        <th colspan="2">技术</th>
                        <th colspan="2">样机</th>
                        <th>租赁及<br />二手机</th>
                        <th>卡特融资租赁 或卡特保险</th>
                        <th class="tab-r"></th>
                    </tr>
                    <tr class="tab-td01">
                    	<td class="no-border"></td>
                    	<td>涉及行业数量</td>
                    	<td>零件产品展示</td>
                    	<td>零件促销及柜台</td>
                    	<td>零件库房展示/参观</td>
                    	<td>服务车间展示/参观</td>
                    	<td>工具和防污染控制展示</td>
                    	<td>特种服务车展示</td>
                    	<td>服务促销项目</td>
                    	<td>GPS展示</td>
                    	<td>介绍/演示</td>
                    	<td>动态演示</td>
                    	<td>静态演示</td>
                    	<td>咨询/展示台</td>
                    	<td class="no-border">咨询/展示台</td>
                        <td></td>
                    </tr>
                    <tr class="tab-td02">
                    	<td class="no-border" colspan="2">${mol2013006.indusnum}</td><!-- 涉及行业数量 -->
                    	<td><c:if test="${mol2013006.partsshow == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 零件产品展示 -->
                    	<td><c:if test="${mol2013006.partspromo == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 零件促销及柜台 -->
                    	<td><c:if test="${mol2013006.partswh == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 零件库房展示/参观 -->
                    	<td><c:if test="${mol2013006.servicews == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 服务车间展示/参观 -->
                        <td><c:if test="${mol2013006.toolspollu == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 工具和防污染控制展示 -->
                    	<td><c:if test="${mol2013006.speservice == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 特种服务车展示 -->
                        <td><c:if test="${mol2013006.promotion == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 服务促销项目 -->
                    	<td><c:if test="${mol2013006.gpsshow == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- GPS展示 -->
                    	<td><c:if test="${mol2013006.introdomo == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 介绍/演示 -->
                    	<td>${mol2013006.dynadomo}</td><!-- 动态演示 -->
                    	<td>${mol2013006.staticdemo}</td><!-- 静态演示 -->
                    	<td><c:if test="${mol2013006.showcasecat == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 咨询/展示台 -->
                        <td class="no-border" colspan="2"><c:if test="${mol2013006.showcaseru == 1}"><img src="${webapp}/systemMain/images/icon.png" width="33" height="32" /></c:if></td><!-- 咨询/展示台 -->
                   </tr>
                </table>
            </div>
       	  	<div class="bxyl-two" style="margin-bottom: 12px;">      	        
               	<input type="image" class="bxly-zl" src="${webapp}/systemMain/images/bxly-zl.png" onclick="" />
   		  		<span>项目总金额：${mol005.totalCust}，报销金额：${mol005.appReim}
				<br/>活动照片预览、发票下载。</span>      
           		<ul id="hdzpUl">
              	  <li>
              	  <c:if test="${requestScope.implist[0]!=null}">
              	  	<a href="${webapp}${requestScope.implist[0].fieldarc}">
                 		<img src="${webapp}${requestScope.implist[0].fieldarc}" width="266px" height="183px"/>
                     </a>
                       <input type="image" style="cursor: default;" class="bxly-tu01" src="${webapp}/systemMain/images/bxyl-zp01.jpg" />
                      </c:if> 
                 </li>
                 <li>
                 <c:if test="${requestScope.implist[1]!=null}">
                 	<a href="${webapp}${requestScope.implist[1].fieldarc}">
                 		<img src="${webapp}${requestScope.implist[1].fieldarc}" width="266px" height="183px" />
                 	</a>	
                       <input type="image" style="cursor: default;" class="bxly-tu01" src="${webapp}/systemMain/images/bxyl-zp02.jpg"  />
                       </c:if>
                 </li>
                 <li><c:if test="${requestScope.implist[2]!=null}">
                 	<a href="${webapp}${requestScope.implist[2].fieldarc}">
                 		<img src="${webapp}${requestScope.implist[2].fieldarc}" width="266px" height="183px "/>
                 	</a>	
                       <input type="image" style="cursor: default;" class="bxly-tu01" src="${webapp}/systemMain/images/bxyl-zp03.jpg" />
                       </c:if>
                 </li>
          		</ul> 
       	  	</div>
       	  	<div style="margin-left:60px;color:white;font-family:'微软雅黑';font-size:17px;">发票：
       	  		<input type="button" style="background:url(${webapp}/systemMain/images/gccg-xz-btn.png);
       	  		width:78px;height:27px;vertical-align:middle;cursor:pointer" onclick="downLoadFp('${mol005.proId}')" />
       	  	</div>
       	  	
        	<div class="bxyl-three">
                 <input type="image" class="bxly-qd" src="${webapp}/systemMain/images/bxly-qd.png" onclick="" />
                 <ul class="bxyl-three-c">
                 <li ><input type="text" value="${rmi2013001.newSaleld}"/><label>产生的销售线索：</label></li>
                 <li><input type="text" value="${rmi2013001.discMac}"/><label>识别商机：</label></li>
                    <li><input type="text" value="${rmi2013001.deteQua}"/><label>资质判定：</label></li>
                    <li><input type="text" value="${rmi2013001.formPlan}"/><label>制定计划：</label></li>
                    <li><input type="text" value="${rmi2013001.deveProg}"/><label>制定方案：</label></li>
                    <li class="p1"><input type="text" value="${rmi2013001.openOppor}"/><label>仍处于漏斗中的商机：</label></li>
                    <p>(识别商机+资质判定+制定计划+制定方案)</p>
                    <li><input type="text" value="${rmi2013001.winOrder}" id="winOrder"/><label>赢单(GCI)：</label></li>
                    <li><input type="text" value="${rmi2013001.winOrders}" id="winOrders"/><label>赢单(BCP)：</label></li>
                    <li><input type="text" value="${rmi2013001.lostSales}"/><label>失销：</label></li>
                    <li><input type="text" value="${rmi2013001.noTrans}"/><label>无交易：</label></li>
                    <li class="p1"><input type="text" value="${rmi2013001.totalMac}" id="haveProNum"/><label>产生的商机总数：</label></li>
                    <p>(仍处于漏斗中的商机+赢单+失销+无交易)</p>
                    <li class="p1"><input type="text" value="${rmi2013001.macgenRate}"/><label> 商机生产率：</label></li>
                    <p>(产生的商机总数/展会签到人数)</p>
                    <li><input type="text" value="${rmi2013001.currCust}"/><label>当前客户：</label></li>
                    <li><input type="text" value="${rmi2013001.potenCust}"/><label>新的潜在客户：</label></li>
                    <li class="p1"><input type="text" value="${rmi2013001.regisCust}"/><label>展会签到人数：</label></li>
                    <p>当前客户+新的潜在客户</p>
                    <li class="p1"><input type="text" id="ldbl"/><label>漏斗比率：</label></li>
                    <p>(赢单/产生的商机总数)</p>
                    <li class="p1"><input type="text" value="${rmi2013001.dodCustnum}"/><label>现场交付定金的客户数量：</label></li>
                 </ul>
                   <div class="bxyl-three-b" style="margin-top:8px" >
                   <strong>签单机器情况：</strong>
                   <div style="overflow:auto;height:120px;width:560px;">
	                 	<c:forEach items="${requestScope.listMol004}" var="mol004">
		                 	<label>机器型号：</label><input type="text"  class="input1" value="${mol004.macModel}" />
		                   <label class="label2">数量：</label><input type="text" class="input2" value="${mol004.macNum}"/><br />
	                   </c:forEach>
                   </div>
                 </div>
              </div>
            </div>
  </body>
</html>
