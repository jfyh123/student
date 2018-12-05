 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<script type="text/javascript" src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程设计选题系统</title>
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
		<form  action="LoginServlet" method="post">
			<div class="login">
				<!--下面是用户名输入框-->
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input
						id="username" name="username" type="text" class="form-control" placeholder="用户名"
						aria-describedby="basic-addon1">
				</div>
				<br>
				<!--下面是密码输入框-->
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input type="password"
						id="password" name="password" type="text" class="form-control" placeholder="密码"
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
 <style type="text/css">
body {
	margin-left: auto;
	margin-right: auto;
	margin-top: 200px;
	background-image: url("static/images/bg1.jpg");
}
.nav_top{
	height:60px;
}
.nav_logo{
    float: left;
    margin-left:30px;
    height: 44px;
    width: 190x;
    padding:15px;
}
.pic_logo{
	width:40px;
	height: 40px;
}
.nav_logo_text{
	text-decoration: none;
	font-weight:600;
    font-size: 20px;
	color:#424e67;
}
a:hover {
	text-decoration:none;
}
a:focus {
	text-decoration:none;
}
.bg_login{
	float:right;
	background:#FFF;
	width:350px;
	height:410px;
	position:relative;
	-webkit-border-radius: 5px;
}
.lg_tiele{
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
	font-size:20px;
	font-weight:900;
	width:80%;
}
.login{
	margin-left: auto;
	margin-right: auto;
	padding-top:60px;
	width:80%;
}
.lg_bottom{
	height:65px;
	width:100%;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
	position: absolute;
	background:#F3F8FF;
    bottom: 0;
    left: 0;
    right: 0;
}
</style>