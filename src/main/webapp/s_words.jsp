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
	<title>学生留言</title>
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
		<table class="table" border="1" align="center">
			<thead>
				<tr>
					<th>#</th>
					<th>老师名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${teacherlist}" varStatus="status">
			<tbody>
				<tr>
					<td>${ status.index + 1}</td>
					<td>${item.nick_name}</td>
					<td>
						<a class="btn btn-success" onclick="leave_words(${item.utid});" value="">留言</a>
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		
	});
	
	function leave_words(tid){
		var message="";
		layer.prompt({title: '留言输入', formType: 2}, function(text, index){
		    message=text;
		    $.ajax({
	            url:"${pageContext.request.contextPath}/student/putComments",
	            type:"post",
	            data:{"tid":tid,"message":message},
	            success:function(res){
	            	layer.msg("留言成功");
            		layer.close(index);
	            },
	            error:function(res){
	            	layer.msg("系统错误");
	            }
	        });
	  	});
	}
</script>
</html>