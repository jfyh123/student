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
	<title>学社选题</title>
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
					<th>题目名称</th>
					<th>要求</th>
					<th>数量</th>
					<th>作品</th>
					<th>选择</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${topicdata}" varStatus="status">
			<tbody>
				<tr>
					<td>${ status.index + 1}</td>
					<td>${item.tname}</td>
					<td>${item.claim}</td>
					<td>${item.sum}</td>
					<td><input type="text" id="works${item.tid}" name="works${item.tid}"/></td>
					<td>
						<a class="btn btn-success" onclick="selectTitle(${item.tid});" value="">选择</a>
						<input type="hidden" id="ecid" name="ecid" value="${ecid}"/>
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(function(res) {
		
	});
	//选题
	function selectTitle(tid){
		var BasePath = "<%=basePath%>";
		var ecid = $("#ecid").val();
		 var works = $("#works"+tid).val();
		layer.confirm('是否确定选题？', {
			  btn: ['确定','取消'] //按钮
			}, function(){
				$.ajax({
		            url:"${pageContext.request.contextPath}/student/selectCourseTopic",
		            type:"post",
		            data:{"tid":tid,"ecid":ecid,"works":works},
		            success:function(res){
		            	if(res.code==200){
		            		layer.msg("选题成功");
		            		parent.location.reload(); // 父页面刷新
		            		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		            		parent.layer.close(index);
		            	}else{
		            		layer.msg("选题失败！");
		            	}
		            },
		            error:function(res){
		            	layer.msg("系统错误");
		            }
		        });
			}, function(){
			});
	}
	
</script>
</html>