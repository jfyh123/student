<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/other/index.css"/>
	<title>课程设计选题系统</title>
</head>
	<body>
	<!-- top -->
	<div class="navbar navbar-fixed-top nav_top">
		<div class="nav_logo">
			<img class="pic_logo" src="${pageContext.request.contextPath}/static/images/book.png"> <a
				class="nav_logo_text" href="#"><span>课程设计选题系统</span></a>
		</div>
		<div class="nav_user">
			<img class="pic_user" src="${pageContext.request.contextPath}/static/images/user.png"> <a
				class="nav_user_name"><span>${userdate.uname}</span></a>
			<button type="button" class="btn btn-danger btn-sm nav_user_exit">退出</button>
		</div>
	</div>
	<!-- center -->
	<div class="navbar-fixed-left center">
		<!-- menu -->
		<div class="nav_left">
			<c:if test="${userdate.type==0}">
				<ul>
		           <li class="select">
		           	<a><span>学生菜单</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>个人信息</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>学生选题</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>成绩查询</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>留言</span></a>
		           </li>
		       </ul>
	       </c:if>
	       <c:if test="${userdate.type==1}">
				<ul>
		           <li class="select">
		           	<a><span>老师菜单</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>个人信息</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>上报题目</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>成绩提交</span></a>
		           </li>
		           <li>
		           	<a href="#"><span>留言</span></a>
		           </li>
		       </ul>
	       </c:if>
       </div>
       <!-- content -->
		<div class="content">
			
		</div>
	</div>
	
	</body>
</html>