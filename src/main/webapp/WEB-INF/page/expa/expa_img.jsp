<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<img src="<%=basePath %>expa/findImg.do?processDefId=${processDefId }" />
<!-- 给执行的节点加边框 -->
<div style="position: absolute;border: 2px solid red; left: ${actimpl.x+5}px;top:${actimpl.y+5}px;width:${actimpl.width}px;height:${actimpl.height}px;"></div>

</body>
</html>