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
				class="nav_user_name"><span>${userdate.nick_name}</span></a>
			<a class="btn btn-danger btn-sm nav_user_exit" onclick="exit()">退出</a>
		</div>
	</div>
	<!-- center -->
	<div class="navbar-fixed-left center">
		<!-- menu -->
		<div class="nav_left">
			<c:if test="${userdate.type==0}">
				<ul id="menu">
		           <li value="/welcome.jsp" class="select">
		           	<a href="#"><span>学生菜单</span></a>
		           </li>
		           <li value="user/information">
		           	<a href="#"><span>学生信息</span></a>
		           </li>
		           <li value="student/electiveCourse">
		           	<a href="#"><span>学生选课</span></a>
		           </li>
		           <li value="student/showCourse">
		           	<a href="#"><span>学生选题</span></a>
		           </li>
		           <li value="student/showCourseGrade">
		           	<a href="#"><span>成绩查询</span></a>
		           </li>
		           <li value="student/showCourseTeacher">
		           	<a href="#"><span>留言</span></a>
		           </li>
		       </ul>
	       </c:if>
	       <c:if test="${userdate.type==1}">
				<ul id="menu">
		           <li value="/welcome.jsp" class="select">
		           	<a href="#"><span>老师菜单</span></a>
		           </li>
		           <li value="user/information">
		           	<a href="#"><span>老师信息</span></a>
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
			<iframe  runat="server" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" 
				src="${pageContext.request.contextPath}/welcome.jsp" id="selectPage"></iframe>
		</div>
	</div>
	<script type="text/javascript">
		$("#menu li a").click(function(data) {
			var BasePath = "<%=basePath%>";
			$("#menu li").removeClass("select");
			$(this).parent().addClass("select");
			var choseValue = $('.select').attr("value");
			document.getElementById("selectPage").src=BasePath+choseValue;
		});
		
		function exit(){
			var BasePath = "<%=basePath%>";
			layer.confirm('是否退出登录？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
					$.ajax({
	 		            url:"${pageContext.request.contextPath}/user/loginOut",
	 		            type:"post",
	 		            success:function(res){
	 		            	window.location.href=BasePath+"/user/login"; 
	 		            },
	 		            error:function(res){
	 		            	layer.msg("系统错误");
	 		            }
	 		        });
				}, function(){
					
				});
		}
		</script>
	</body>
</html>