<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="left">
        <ul>
            <li class="select">
            	<a href="#"><span>全部文件</span></a>
            </li>
            <li>
            	<a href="#"><span>图片</span></a>
            </li>
            <li>
            	<a href="#"><span>文档</span></a>
            </li>
            <li>
            	<a href="#"><span>视频</span></a>
            </li>
            <li>
            	<a href="#"><span>其他</span></a>
            </li>
        </ul>
    </div>
</body>

<style>
ul{
	margin:0px;
	padding:0px;
	list-style-type: none;
	text-align: center;
}
li{
	padding: 12px 0px;
}
a{
	font-size:14px;
	color:#424e67;
}
a:-webkit-any-link {
	text-decoration:none;
}
.select{
	background-color: #999;
	opacity:0.7;
}
.select a{
	color:#06c;
}
.left{
	width:200px;
	background:#F3F8FF;
	height:650px;
    bottom: 66px;
    z-index: 0;
}
</style>
</html>