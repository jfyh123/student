 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        #iframeTop{
            width: 100%;
            height: 80px;
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
<body>
<div>
    <iframe id="iframeTop" name="iframeTop" frameborder="0" src="top.jsp"></iframe>
    <iframe id="iframeLeft" name="iframeLeft" frameborder="0" src="left.jsp"></iframe>
    <iframe id="iframeContent" name="iframeContent" frameborder="0" src="view/content.html"></iframe>
</div>
</body>
</html>