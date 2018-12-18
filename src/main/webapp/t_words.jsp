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
	<title>老师留言</title>
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
		.open_page{
			color: #fff;
			font-size: 15px;
			float: left;
		}
		.layui-layer-content{
			background-color: #5FB878;
		}
	</style>
</head>
<body>
	<div>
		<table class="table" border="1" align="center">
			<thead>
				<tr>
					<th>#</th>
					<th>学生姓名</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${commentslist}" varStatus="status">
			<tbody>
				<tr>
					<td>${status.index + 1}</td>
					<td>${item.nick_name}</td>
					<td>
						<a class="btn btn-success" onclick="check_words('${item.message}',${item.lcid});">查看留言</a>
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
	
	function check_words(message,lcid){
		layer.open({
   		  type: 1,
   		  shade: false,
   		  title: false, //不显示标题
   		  area: ['360px','100px'],
   		  content: "<ul><li><span class='open_page'>"+message+"<span></li></ul>",
   		  cancel: function(){
   			$.ajax({
	            url:"${pageContext.request.contextPath}/teacher/updateComment",
	            type:"post",
	            data:{"lcid":lcid},
	            success:function(res){
	            },
	            error:function(res){
	            	layer.msg("系统错误");
	            }
	        });
   		  }
   		});
	}
</script>
</html>