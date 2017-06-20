<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程定义查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>


</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>流程定义管理</li>

		</ul>
	</div>
	<form method="post" id="f1" class="form-inline">

		<div class="row" style="padding: 15px;">
			<table class="table">
				<tr>
					<td>id(key:version:deploymentId)</td>
					<td>name</td>
					<td>key</td>
					<td>version</td>
					<td>deploymentId</td>
				</tr>

				<c:forEach items="${list }" var="pd">
					<tr>
						<td>${pd.id }</td>
						<td>${pd.name }</td>
						<td>${pd.key }</td>
						<td>${pd.version }</td>
						<td>${pd.deploymentId }</td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</form>
</body>
</html>