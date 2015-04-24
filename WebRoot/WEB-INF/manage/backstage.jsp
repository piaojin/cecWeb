<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'back.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath%>css/backstage.css"/>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/clock2.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jQueryRotate.2.2.js"></script>
  

  </head>
  
  <body>
    <div class="navbar">
        计算机工程学院后台管理
        <span class="menu">欢迎回来，管理员<a href="#">注销</a></span>
    </div>
    <div class="contain">
        <div class="side">
            <div id="centered">
                <div id="html5-clock" ></div>
            </div>
            <ul>
                <li class="visible"><a href="artManage-toArtManage" target="main">文章管理</a></li>
                <li><a href="artManage-toArtManage" target="main">用户管理</a></li>
                <li><a href="artManage-toArtManage" target="main">栏目管理</a></li>
                <li><a href="artManage-toArtManage" target="main">什么功能</a></li>
                <li><a href="artManage-toArtManage" target="main">什么功能</a></li>
            </ul>
        </div>
        <iframe src="artManage-toArtManage" name="main" class="main">您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。</iframe>
    </div>
    <script src="<%=basePath%>js/backstage.js" type="text/javascript"></script>
  </body>
</html>
