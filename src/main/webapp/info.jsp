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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>课程设计选题系统</title>
</head>
	<body>
		<form class="form-horizontal" role="form">
		<div class="left">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
				<div class="col-sm-4">
				  <input class="form-control" id="uname" name="uname" type="text" value="" disabled>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">手机号码：</label>
				<div class="col-sm-4">
				  <input class="form-control" id="phone" name="phone" type="text" value="" >
				</div>
			</div>
		</div>
		<div class="right">
			<div class="form-group">
		      <label class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
		      <div class="col-sm-4">
		        <select id="disabledSelect" class="form-control">
		          <option value="1">男</option>
		          <option value="0">女</option>
		        </select>
		      </div>
		    </div>
		    <div class="form-group">
				<label class="col-sm-2 control-label">email：&nbsp;&nbsp;</label>
				<div class="col-sm-4">
				  <input class="form-control" id="email" name="email" type="text" value="" >
				</div>
			</div>
		</div>
		<div class="btn_bottom">
			<button type="submit" class="btn btn-primary">保存</button>
		</div>
		</form>
	</body>
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
</html>