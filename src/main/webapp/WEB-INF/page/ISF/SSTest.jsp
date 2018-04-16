<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<base href="<%=basePath%>">  

<script type="text/javascript" src="<%=basePath%>res/jQuery/jquery-1.9.1.js"></script>
<script type="text/javascript">  
$(function() {  
    $.post("test/search.do?flag=getOne",  
    function(data) {  
        var dataObj = eval("(" + data + ")");  
        for (var i = 0; i < dataObj.length; i++) {  
            var $option = $("<option></option>");  
            $option.attr("value", dataObj[i].id);  
            $option.text(dataObj[i].name);  
            $("#one").append($option);  
        }  
    });  
      
    $("#one").change(function() {  
        var jsonObj = {  
            id: $(this).val()  
        };  
        $("#two option[value!='']").remove();  
        $("#three option[value!='']").remove();  
        $.post("test/search.do?flag=getTwo&parId=" + $("#one").val(), jsonObj,  
        function(data, textStatus) {  
            var dataObj = eval("(" + data + ")");  
            for (var i = 0; i < dataObj.length; i++) {  
                var $option = $("<option></option>");  
                $option.attr("value", dataObj[i].id);  
                $option.text(dataObj[i].name);  
                $("#two").append($option);  
            }  
        });  
    });  
      
    $("#two").change(function() {  
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
    });  
});  
</script>  
</head>  
<body>  
    Hello World！  
    <select name='one' id='one'>  
        <option value="">-请选择-</option>  
    </select>  
    <select name='two' id='two'>  
        <option value="">-请选择-</option>  
    </select>  
    <select name='three' id='three'>  
        <option value="">-请选择-</option>  
    </select>  
</body>  
</html>  