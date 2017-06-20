<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>


</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>${assignee }</li>

		</ul>
	</div>
			<div class="alert alert-warning alert-dismissible"
			style="display: ${info==null?'none':'block' };" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div align="center" style="color: red;">${info }</div>
		</div>
	<form method="post" id="f1" class="form-inline">

		<div class="row" style="padding: 15px;">
			<table class="table">
				<tr>
					<td>任务编号</td>
					<td>报销人</td>
					<td>报销原因</td>
					<td>报销时间</td>
					<td>报销金额</td>
					<td>操作</td>
				</tr>

				<c:forEach items="${list }" var="ea">
					<tr>
						<td>${ea.taskId }</td>
						<td>${ea.expa.userName }</td>
						<td>${ea.expa.expenseName }</td>
						<td><fmt:formatDate value="${ea.createTime }" type="both"/> </td>
						<td>${ea.expa.expenseTotal }</td>
						<td>
						<c:if test="${type=='manager'}">
							<a href="expa/loadManager.do?taskId=${ea.taskId }&createTime=${ea.createTime }">经理审批</a>
						</c:if>
						<c:if test="${type=='finance'}">
							<a href="expa/loadFinance.do?taskId=${ea.taskId }&createTime=${ea.createTime }">财务审批</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</form>
</body>
</html>