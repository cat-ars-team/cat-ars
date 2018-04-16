
/**
 * @作者: 朱长智
 * @时间: 2018-02-25 上午 2:10
 * @描述: 公用JS(1.验证表单2.格式化数字)
 */

/**
 * 验证: 只能输正整数和0
 * 用法: onkeyup="checkreg(this)", 可以是其他事件
 */
function checkOnlyNumAndZero(obj) {
	var bhReg = /^[0-9]*[0-9]*$/;
	if (!obj.value.match(bhReg)) {
		obj.value = "";
		obj.focus();
		return false;
	}
}


/** 验证: 只能输正整数
* 用法: onkeyup="checkreg(this)", 可以是其他事件
*/
function checkNum(obj) {
	var bhReg = /^[0-9]*[1-9][0-9]*$/;
	if (!obj.value.match(bhReg)) {
		obj.value = "";
		obj.focus();
		return false;
	}
}


/*
*//**
 * 文件上传后缀名判定
 * @param obj 文件域对象
 * @param falg 标识 1[图片] 2[ZIP] 3[Excel]
 *//*
function fileCheck(obj, flag){
　　var file = obj.value;
　　//获取文件后缀名并转成小写 
　　var ext = file.substring(file.lastIndexOf(".")).toLowerCase();
　　if( file == ""){
	　　alert("请选择文件!");
	　　return false;
　　}else{
		if(flag == 1){
			if(ext != ".jpg") {
		　　		alert("请选择jpg格式图片文件!");
		　　		obj.outerHTML = obj.outerHTML;
		　　	    obj.value = "";
		　　		return false;
	　　		}
		}else if(flag == 2){
			if(ext != ".zip"&&ext != ".rar") {
				alert("请选择zip,rar格式文件!");
		　　		obj.outerHTML = obj.outerHTML;
		　　	    obj.value = "";
		　　		return false;
			}
		}else if(flag == 5){
			if(ext != ".zip" && ext != ".rar" && ext != "pdf" && ext != "jpg") {
				alert("请选择zip,rar,pdf,jpg格式文件!");
		　　		obj.outerHTML = obj.outerHTML;
		　　	    obj.value = "";
		　　		return false;
			}
		}else{
			if(ext != ".xls" && ext != ".xlsx") {
		　　		alert("请选择Excel文件!");
		　　		obj.outerHTML = obj.outerHTML;
		　　	    obj.value = "";
		　　		return false;
	　　		}
		}
　　}
　　return true; 
}

*//**
 * 验证: 只能数字, 小数点, 且四舍五入,小数保留两位小数
 * 用法: onchange="if(this.value!=''){return replaceNaN(this.id)}", 可以是其他事件
 *//*
function replaceNaN(obj) {
	var text1 = document.getElementById(obj);
	NaNvalue = text1.value.replace(/[^0-9.]/gi, "");
	var f_x = Math.round(NaNvalue * 100) / 100;
	document.getElementById(obj).value = f_x;
	if (f_x == 0) {
		return false;
	}
}

*//**
 * 验证: 只能输入字母, 数字, 下划线
 * 用法: onkeyup="checkreg(this)", 可以是其他事件
 *//*
function checkreg(obj) {
	var bhReg = /^[a-zA-Z0-9_]{1,}$/;
	if (!obj.value.match(bhReg)) {
		obj.value = "";
		obj.focus();
		return false;
	}
}




*//**
 * 格式化: JS格式化金额, 且四舍五入, 保留两位小数
 * 用法: fmoney('123.567', 2); 返回: 123.57
 *//*
function fmoney(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}

*//**
 * 验证: 只能输入数字
 * 用法: 
 *//*
function noNumbers(e)   {   
	var keynum;   
	var keychar;   
	var numcheck;   
	if(window.event) {   
		keynum = e.keyCode;   
	}else if(e.which) {   
		keynum = e.which ;  
	}   
	keychar = String.fromCharCode(keynum);   
	numcheck = /[^\d]/g;   
	return !numcheck.test(keychar);   
}

*//**
 * 全局: 屏蔽JS脚本错误
 *//*
window.onerror = function(){
 	return true;
 }

*//**
 * 清除字符串中的空格, 实现类似Java的replaceAll()方法
 * @param s1 未处理的字符串
 * @param s2 处理过的字符串
 *//*
String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}

*//**
 * JS判断一个数组中是否包含某个元素
 * @param arr 数组
 * @param val 要判断的元素
 * 用法:
 * array = [a,b,c,d]
 * alert(array,'a'); // true
 * alert(array,'h'); // false
 *//*
function IsInArray(arr,val){    
	var testStr = ','+arr.join(",")+",";    
	return testStr.indexOf(","+val+",") != -1;
}

*//**
 * JS判断一个数组中是否包含某个元素
 *//*
Array.prototype.in_array = function(e){  
for(i=0;i<this.length;i++){  
	if(this[i] == e)  
		return true;  
	}  
	return false;  
}

*//**
 * 移除数组内相同的元素
 * @param data 数组
 * @return data 处理过的数组
 *//*
function unique(data){
    data = data || [];
    var a = {};
    for (var i=0; i<data.length; i++) {
        var v = data[i];
        if (typeof(a[v]) == 'undefined'){
            a[v] = 1;
        }
    };
    data.length=0;
    for (var i in a){
        data[data.length] = i;
    }
    return data;
}


*//**
 * 图片预览: 设定显示的尺寸
 *//*
function autoSizePreview( objPre, originalWidth, originalHeight ){     
    var zoomParam = clacImgZoomParam( 220, 200, originalWidth, originalHeight );        
    objPre.style.width = zoomParam.width + 'px';        
    objPre.style.height = zoomParam.height + 'px';        
    objPre.style.marginTop = zoomParam.top + 'px';        
    objPre.style.marginLeft = zoomParam.left + 'px';        
}        
    		
*//**
 * 图片预览: 缩放处理, 根据原图比例自动计算
 *//*
function clacImgZoomParam( maxWidth, maxHeight, width, height ){        
    var param = { width:width, height:height, top:0, left:0 };        
            
    if( width>maxWidth || height>maxHeight ){        
        rateWidth = width / maxWidth;        
        rateHeight = height / maxHeight;        
                
        if( rateWidth > rateHeight ){        
            param.width =  maxWidth;        
            param.height = height / rateWidth;        
        }else{        
            param.width = width / rateHeight;        
            param.height = maxHeight;        
        }        
    }        
            
    param.left = (maxWidth - param.width) / 2;        
    param.top = (maxHeight - param.height) / 2;        
            
    return param;        
}*/
