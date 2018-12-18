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
	<title>上报题目</title>
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
					<th>课程</th>
					<th>周期</th>
					<th>时间</th>
					<th>地址</th>
					<th>选题操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${courselist}" varStatus="status">
			<tbody>
				<tr>
					<td>${status.index + 1}</td>
					<td>${item.cname}</td>
					<td>${item.cycle}</td>
					<td>${item.time}</td>
					<td>${item.address}</td>
					<td>
						<a class="btn btn-primary" onclick="chekcTitle(${item.cid});">查看</a>
						<a style="margin-left: 20px;" class="btn btn-success" onclick="addTitle(${item.cid});">添加</a>
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
	
	//查看
	function chekcTitle(){
		layer.open({
		  type: 2,
		  area: ['700px', '450px'],
		  fixed: false, //不固定
		  maxmin: true,
		  title:"选题页面",
		  content: "${pageContext.request.contextPath}/teacher/showCourseTopic"
		});
	}
	
	//添加选题
	function addTitle(){
		var message="";
		layer.prompt({title: '输入添加的课题', formType: 2}, function(text, index){
		    message=text;
		    $.ajax({
	            url:"${pageContext.request.contextPath}/teacher/addCourseTopic",
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