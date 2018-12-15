<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<script type="text/javascript" src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="static/css/other/left.css"/>
</head>
	<c:if test="">
	       <ul>
	           <li class="select">
	           	<a href="#"><span>学生菜单</span></a>
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
       <c:if test="">
		<ul>
           <li class="select">
           	<a href="#"><span>教师菜单</span></a>
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
       
       
<script type="text/javascript">
	$(function(){
	    initData();
	    alert("loading menu");
	});
	function initData(){
        $.ajax({
            type:'GET',
            dataType: 'json',
            url:'',
            data:'',
            success:function(res){
                
            },
            error:function(){
                //alert("发生错误");
            }
        });
    }
</script>

</html>