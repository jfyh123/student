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
					<th>科目</th>
					<th>时间</th>
					<th>题目名称</th>
					<th>作品</th>
					<th>评分</th>
					<th>评语</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${courselist}" varStatus="status">
			<tbody>
				<tr>
					<td>
						<input id="select" name="select" type="checkbox" value="${item.ecid}"/>
					</td>
					<td>${item.cname}</td>
					<td>${item.time}</td>
					<td>${item.tname}</td>
					<td>${item.works}</td>
					<td>${item.grade}</td>
					<td>${item.message}</td>
					<td>
						<a class="btn btn-success" onclick="selectTitle(${item.cid},${item.ecid});" value="">选题</a>
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="btn_bottom">
		<a class="btn btn-warning" onclick="outSubject();">退课</a>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		
	});
	
	//批量 退课
	function outSubject(){
		obj = document.getElementsByName("select");
	    var check_val = "";
	    for(k in obj){
	        if(obj[k].checked){
	            check_val+=obj[k].value+",";
	        }
	    }
	    $.ajax({
            url:"${pageContext.request.contextPath}/student/deleteCourse",
            type:"post",
            data:{"course":check_val},
            success:function(res){
            	if(res.code==200){
            		layer.msg(res.data);
            		window.location.reload();
            	}else{
            		layer.msg(res.data);
            	}
            },
            error:function(res){
            	layer.msg(res.data);
            }
        });
	}
	
	//选题
	function selectTitle(cid,ecid){
		layer.open({
		  type: 2,
		  area: ['700px', '450px'],
		  fixed: false, //不固定
		  maxmin: true,
		  title:"选题页面",
		  content: "${pageContext.request.contextPath}/student/showCourseTopic?cid="+cid+"&ecid="+ecid
		});
	}
	
</script>
</html>