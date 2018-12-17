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
	<title>个人信息</title>
	<style type="text/css">
		body{
			margin-top: 3%;
			margin-left:12%;
			background-color: #F5F5F5;
		}
		.form-group{
			margin-top: 30px;
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
			.left{
				float: left;
				width: 50%;
				height: 100%;
			}
			.right{
				float: right;
				width: 50%;
				height: 100%;
			}
		</style>
</head>
	<body>
		<div class="form-horizontal">
		<div class="left">
			<div class="form-group">
				<label class="col-sm-2 control-label">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
				<div class="col-sm-4">
				  <input class="form-control" id="uname" name="uname" type="text" value="${userdate.uname}" disabled>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
				<div class="col-sm-4">
				  <input class="form-control" id="nick_name" name="nick_name" type="text" value="${userdate.nick_name}" >
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">手机号码：</label>
				<div class="col-sm-4">
				  <input class="form-control" id="phone" name="phone" onchange="checkPhone();" type="text" value="${userdate.phone}" >
				</div>
			</div>
		</div>
		<div class="right">
			<div class="form-group">
				<label class="col-sm-2 control-label">身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：</label>
				<div class="col-sm-4">
					<c:if test="${userdate.type == 1}">
					  <input class="form-control" id="uname" name="uname" type="text" value="老师" disabled>
					 </c:if>
					 <c:if test="${userdate.type == 0}">
					  <input class="form-control" id="uname" name="uname" type="text" value="学生" disabled>
					 </c:if>
				</div>
			</div>
			<div class="form-group">
		      <label class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
		      <div class="col-sm-4">
		      	<c:if test="${userdate.gender == 1}">
			        <select id="gender" class="form-control">
			          <option value="1">男</option>
			          <option value="0">女</option>
			        </select>
		        </c:if>
		        <c:if test="${userdate.gender == 0}">
			        <select id="gender" class="form-control">
			         <option value="0">女</option>
			         <option value="1">男</option>
			        </select>
		        </c:if>
		      </div>
		    </div>
		    <div class="form-group">
				<label class="col-sm-2 control-label">email：&nbsp;&nbsp;</label>
				<div class="col-sm-4">
				  <input class="form-control" id="email" name="email" type="text" value="${userdate.email}" >
				</div>
			</div>
		</div>
		<div class="btn_bottom">
			<a class="btn btn-primary" onclick="saveInfo();">保存</a>
		</div>
		</div>
	</body>
	<script type="text/javascript">
	$(function(){
	});
	
	function saveInfo(){
		var nick_name = $("#nick_name").val();
		var phone = $("#phone").val();
		var gender = $("#gender").val();
		var email = $("#email").val();
		$.ajax({
            url:"${pageContext.request.contextPath}/user/UpdateInformation",
            type:"post",
            data:{"nick_name":nick_name,"phone":phone,"gender":gender,"email":email},
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
	
	function checkPhone(){ 
	    var phone = document.getElementById('phone').value;
	    if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){ 
	        layer.tips('输入手机号码有误', '#phone', {
		    	  tips: [1, '#3595CC'],
		    	  time: 4000
	    	});
	    }
	    
	}
	</script>
</html>