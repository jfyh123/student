 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<script type="text/javascript" src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="static/css/other/login.css"/>
<title>课程设计选题系统</title>
	<style type="text/css">
		body {
			margin-left: auto;
			margin-right: auto;
			margin-top: 200px;
			background-image: url("static/images/bg1.jpg");
		}
	</style>
</head>
<body>
	<div class="navbar-fixed-top nav_top">
		<div class="nav_logo">
			<img class="pic_logo" src="static/images/book.png">
			<a class="nav_logo_text" href="#"><span>课程设计选题系统</span></a>
		</div>
	</div>
	<div class="container">
	<div class="bg_login">
		<div class="lg_tiele">
			<span>账号密码登录</span>
		</div>
		<form  action="user/login" method="post">
			<div class="login">
				<!--下面是用户名输入框-->
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input
						id="uname" name="uname" type="text" class="form-control" placeholder="用户名"
						aria-describedby="basic-addon1">
				</div>
				<br>
				<!--下面是密码输入框-->
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input type="password"
						id="pwd" name="pwd" type="text" class="form-control" placeholder="密码"
						aria-describedby="basic-addon1">
				</div>
				<br>
				<!--下面是登陆按钮,包括颜色控制-->
				<div>
					<button type="submit" class="btn btn-lg btn-info btn-block">登录</button>
				</div>
			</div>
		</form>
		<div class="lg_bottom">
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	
</script>
