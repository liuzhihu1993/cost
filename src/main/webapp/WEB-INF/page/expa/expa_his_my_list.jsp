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
			<li>报销查询</li>

		</ul>
	</div>

	<form method="post" id="f1" class="form-inline">

		<div class="row" style="padding: 15px;">
			<table class="table">
				<tr>
					<td>流程实例ID</td>
					<!-- <td>流程定义ID</td> -->
					<td>开始时间</td>
					<td>结束时间</td>
					<td>状态</td>
					<td>报销人</td>
					<td>报销原因</td>
					<td>报销金额</td>
					<td>报销详情</td>
			
					<td>经理审核状态</td>
					<td>经理审核人</td>
					<td>经理审核描述</td>
					<td>财务审核状态</td>
					<td>财务审核人</td>
					<td>财务审核描述</td>
					<td>操作</td>
				</tr>

				<c:forEach items="${tlist }" var="ea">
					<tr>
						<td>${ea.processInstanceId }</td>
					<%-- 	<td>${ea.processDefinitionId }</td> --%>
						<td>
						<fmt:formatDate value="${ea.startTime }" type="both" />
						</td>
						<td>
						<fmt:formatDate value="${ea.endTime }" type="both" />
						</td>
							<td>
							<c:if test="${ea.mark=='1'}">
								<a href="javascript:void(0)" class="btn btn-success btn-xs">执行完毕</a>
							</c:if>
								<c:if test="${ea.mark=='2'}">
								<a href="javascript:void(0)" class="btn btn-warning btn-xs">执行中</a>
							</c:if>
							
							</td>
					<td>${ea.expa.userName }</td>
					<td>${ea.expa.expenseName }</td>
					<td>${ea.expa.expenseTotal }</td>
					<td>${ea.expa.expenseDesc }</td>
					<td>
					<c:if test="${ea.expa.managerMark=='1'}">
								<a href="javascript:void(0)" class="btn btn-success btn-xs">审核通过</a>
							</c:if>
				<c:if test="${ea.expa.managerMark=='0'}">
								<a href="javascript:void(0)" class="btn btn-danger btn-xs">审核不通过</a>
							</c:if>
					
					</td>
					<td>${ea.expa.managerName }</td>
					<td>${ea.expa.managerDesc }</td>
					<td>
							<c:if test="${ea.expa.financeMark=='1'}">
								<a href="javascript:void(0)" class="btn btn-success btn-xs">审核通过</a>
							</c:if>
							<c:if test="${ea.expa.financeMark=='0'}">
								<a href="javascript:void(0)" class="btn btn-danger btn-xs">审核不通过</a>
							</c:if>
							<c:if test="${ea.expa.financeMark=='2'}">
								<a href="javascript:void(0)" class="btn btn-warning btn-xs">作废</a>
							</c:if>
					</td>
					<td>${ea.expa.financeName }</td>
					<td>${ea.expa.financeDesc }</td>
					<td><a href="expa/showImg.do?processInstanceId=${ea.processInstanceId }&processDefinitionId=${ea.processDefinitionId }">查看</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</form>
</body>
</html>