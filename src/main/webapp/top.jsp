<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<script type="text/javascript" src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="nav_top">
		<div class="nav_logo">
			<img class="pic_logo" src="static/images/book.png"> <a
				class="nav_logo_text" href="#"><span>课程设计选题系统</span></a>
		</div>
		<div class="nav_user">
			<img class="pic_user" src="static/images/user.png"> <a
				class="nav_user_name" href="#"><span>admin</span></a>
			<button type="button" class="btn btn-danger btn-sm nav_user_exit">退出</button>
		</div>
	</div>
</body>
<style>
body{
	background:#F3F8FF;
}
.nav_top{
	margin-top:20px;
	height:60px;
}
.nav_logo{
	float:left;
	margin-left:20px;
}
.nav_logo_text{
	margin-left:15px;
	font-weight:600;
	font-size: 18px;
}
.nav_user{
	margin-top: 5px;
	float:right;
	width:230px;
	font-size: 14px;
}
.pic_logo{
	width:45px;
	height:45px;
}
.pic_user{
	width: 35px;
	height: 35px;
	display:inline-block;
}
.nav_user_name{
	margin-left:5px;
	font-size:18px;
	display:inline-block;
	vertical-align:middle;
}
.nav_user_exit{
	margin-left:60px;
}
</style>
</html>