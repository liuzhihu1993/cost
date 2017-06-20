<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限变更</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script src="res/js/highcharts.js" type="text/javascript"></script>
<script src="res/js/jquery.highchartTable.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('table.highchart').highchartTable();
	});
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报表管理</li>
			<li>报销报表</li>
		</ul>
	</div>


	<div class="row" style="padding: 15px;">
		<table class="highchart" data-graph-container-before="1"
			data-graph-type="pie" data-graph-height="350"
			style="display: none">
			<thead>
				<tr>
					<th>费用名称</th>
					<th>报销金额</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="s">
					<tr>
						<td>${s.cost_name }</td>
						<td>${s.total }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>