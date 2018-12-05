 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<script type="text/javascript" src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>课程设计选题系统</title>
	<style type="text/css">
        #iframeTop{
            width: 100%;
            height: 60px;
        }
        #iframeLeft{
            width: 15%;
            height: 700px;
            float: left;
        }
        #iframeContent{
            width: 84%;
            height: 700px;
        }
    </style>
</head>
<body>
<div>
    <iframe id="iframeTop" name="iframeTop" frameborder="0" src="top.jsp"></iframe>
    <iframe id="iframeLeft" name="iframeLeft" frameborder="0" src="left.jsp"></iframe>
    <iframe id="iframeContent" name="iframeContent" frameborder="0" src="content.jsp"></iframe>
</div>
</body>
</html>