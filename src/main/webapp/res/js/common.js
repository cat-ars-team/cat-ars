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



//MQ
//modal alert
/*
* param:
* id
* width
* height
* background
* backgroundSize
* 
* param.confirm:
* fun
* 
* param.cancel
* fun
*/
function customerAlert(param) {
	// var modal = $('#' + param.id);

	var modal = $('<div class="customer-alert" id="isf-modal"><div class="c-container"><div class="btn-line"><div class="confirm"></div><div class="cancel"></div></div><img src="' + param.basePath + 'res/images/close.jpg" class="close-img" /></div></div>');
	var clone = null;

	if(window.parent != self){
		$(window.parent.document.body).append(modal);
	} else $(body).append(modal);
	
	var modalContainer = modal.children('.c-container');
	
	modal.show();
	modal.parents('body').css('overflow', 'hidden');
	modalContainer.css({
		width: param.width,
		height: param.height,
		background: param.background,
		backgroundSize: param.backgroundSize
	});
	// param.confirm.width = param.confirm.width ? param.confirm.width : 60;
	// param.confirm.height = param.confirm.height ? param.confirm.height : 20;
	
	if(param.closeBtn === false) modal.find('close-img').remove();
	else modal.find('.close-img').click(function(){
		removeModal(modal);
	});
	
	var confirmBtn = modalContainer.find('.confirm');
	var cancelBtn = modalContainer.find('.cancel');

	
	if(confirmBtn.length) {
		confirmBtn.css({
			background: param.confirm.background
		})
		confirmBtn.unbind();
		confirmBtn.click(param.confirm.fun)
	}
	if(cancelBtn.length) {
		cancelBtn.css({
			background: param.cancel.background
		})
		cancelBtn.unbind();
		cancelBtn.click(function(){
			removeModal(modal);
			param.cancel.fun();
		});
	}
}
function removeModal (modal) {
	modal.parents('body').css('overflow', 'auto');
	modal.remove();
}


/* 
    $('.xt-header').click(function(){
    	customerAlert({
    		ele: $('#isf-modal'),
    		width: 514,
    		height: 384,
    		background: "url(<%=basePath%>res/images/alert-bg6.png) no-repeat center center",
    		backgroundSize: '100%',
    		confirm: {
    			background: "url(<%=basePath%>res/images/qr.jpg) no-repeat center center",
    			fun: function () {
    				alert('您点击了确定');
    			}
    		},
    		cancel: {
    			background: "url(<%=basePath%>res/images/qx.jpg) no-repeat center center",
    			fun: function () {
					// do something
    			}
    		},
    		basePath: '<%=basePath%>'
    	})
    })
 */

// jquery validate 
var jqueryValidateObj = null;
function jqueryValidate() {
    if (jqueryValidateObj) jqueryValidateObj.resetForm();
    $(".form-group").removeClass("has-error");
    /*
    user-id
    user-password
    user-name
    user-jobNumber
    user-phone
    user-deptPhone
    // user-mobile
    user-szbm
    user-zwgw
    user-email
    user-qqMsn
    user-ssqxz
    user-sort
…………………………&*……%
    */

    var passwordIsRequire = true;
    if(!app.isAdd && app.isUpdate) passwordIsRequire = false;
    if(!passwordIsRequire) {}
    jqueryValidateObj = $('#user-form').validate({
        errorClass: 'help-block',
        rules: {
            'post-name': 'required',
            'sort-name': 'required',

            'user-id': {
                isBlank:true,
                required: ['登录ID'],
                maxlength: 25,
                isUserNameRepeat: true,
                isOnlyNumLetter: true
            },
            'user-password': {
                // required: false,
                required: ['登录密码'],
                minlength: 3,
                maxlength: 25,
                engNumSymbolCheck:true
            },
            'user-name': {
                required: ["姓名"],
                maxlength: 25,
                conSignCheck: true
            },
            'user-jobNumber': {
                isOnlyNumLetter: true,
                maxlength: 25
            },
            'user-phone': {
                required: ['联系电话'],
                maxlength: 25,
                phoneNum: true,
            },
            'user-deptPhone': {
                maxlength: 25,
                phoneNum: true
            },
            // 'user-mobile': { required: true },
            'user-szbm': { required: ['所在部门'] },
            // 'user-zwgw': { required: false },
            'user-email': {
                maxlength: 25,
                email: true
            },
            'user-qqMsn': {
                // required: true
                maxlength: 25,
                isQq:true
            },
            // 'user-ssqxz': { required: ["文字名称"] },
            'user-sort': {
                integer:true, //负整数，0，正整数
                upperLimit:[1000000000,"九位数"],
            },
        },
        messages: {
            'user-id': {
        //         required: '登录ID必须填写',
        //         maxlength: '上限20个字符',
                isUserNameRepeat: '该用户名已存在',
        //         isOnlyNumLetter: '仅支持英文、数字'
            },
            'user-password': {
                // required: '登录密码必须填写',
                minlength: '长度为3-20个字符',
                maxlength: '长度为3-20个字符'
            },
        //     'user-name': {
        //         required: '姓名必须填写',
        //         maxlength: '上限20个字'
        //     },
        //     'user-jobNumber': {
        //         // required: false,
        //         isOnlyNumLetter: '仅支持英文、数字',
        //         maxlength: '上限20个字'
        //     },
        //     'user-phone': {
        //         required: '联系电话必须填写',
        //         isAllPhoneNum: '请输入正确电话号码',
        //         maxlength: '上限20个字'
        //     },
        //     'user-deptPhone': {
        //         isAllPhoneNum: '请输入正确电话号码',
        //         maxlength: '上限20个字'
        //     },
        //     // 'user-mobile': { required: '移动电话必须填写' },
        //     'user-szbm': { required: '所在部门必须填写' },
        //     'user-zwgw': { required: false },
        //     'user-email': {
        //         maxlength: '上限40个字',
        //         email: '请输入正确的邮箱格式'
        //     },
        //     'user-qqMsn': {
        //         // required: 'QQMSN必须填写'
        //     },
        //     'user-ssqxz': { required: false },
        //     'user-sort': { required: false },
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        success: function(label) {
            label.closest('.form-group').removeClass('has-error');
            label.closest('.help-block').removeClass('help-block');
            label.remove();
        },
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler: function() {
            return false;
        }
    })
    // if(passwordIsRequire) {
    //     $('#user-password').rules('add', { required: true, messages: { required: '登录密码必须填写'}})
    // } else {
    //     $('#user-password').rules('remove', 'required')
    // }

    if (!passwordIsRequire) {
        $('input[name="user-password"]').rules('remove', 'required');
    } else {
        $('input[name="user-password"]').rules('add', { required: true, messages: { required: '登录密码必须填写'}})
    }
}
jQuery.validator.addMethod("isUserNameRepeat", function(value, element) {
    if (element == document.activeElement) return true;
    var result = false;
    App.ajaxRequest({
        url: baseUrl + 'sys/user/volidateUser',
        type: "post",
        async: false,
        isAlert: false,
        data: {
            id: app.userInfo.user.id ? app.userInfo.user.id : null,
            username: app.userInfo.user.username
        },
        callBack: function(data) {
            if (data.code == 2000) result = true;
        }
    })
    return result;
});

/*
 * currCust
 * potenCust
 * 
 * newSaleld
 * 
 * discMac
 * deteQua
 * formPlan
 * deveProg
 * 
 * winOrder
 * winOrders
 * lostSales
 * noTrans
 * 
 * dodCustnum
 * 
 */


