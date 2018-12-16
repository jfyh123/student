<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/layer.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>留言</title>
	<style type="text/css">
		body{
			background-color: #F5F5F5;
		}
		th{
			text-align: center;
		}
		td{
			text-align: center;
		}
		.btn_bottom{
			height:65px;
			width:100%;
		    border-bottom-left-radius: 5px;
		    border-bottom-right-radius: 5px;
			position: absolute;
		    bottom: 0;
		    left: 0;
		    right: 0;
		    text-align:center;
		}
	</style>
</head>
<body>
	<div>
		
	</div>
	<div class="btn_bottom">
		<a class="btn btn-primary" onclick="saveSelect();">确认选择</a>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		
	});
	
	function saveSelect(){
		obj = document.getElementsByName("select");
	    var check_val = "";
	    for(k in obj){
	        if(obj[k].checked){
	            check_val+=obj[k].value+",";
	        }
	    }
	    $.ajax({
            url:"${pageContext.request.contextPath}/student/selectCourse",
            type:"post",
            data:{"course":check_val},
            success:function(res){
            	if(res.code==200){
            		layer.msg(res.data);
            	}else{
            		layer.msg(res.data);
            	}
            },
            error:function(res){
            	layer.msg(res.data);
            }
        });
	}
</script>
</html>