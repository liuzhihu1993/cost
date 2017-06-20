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
<title>用户添加</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/validator/jquery.validator.css">
<script type="text/javascript" src="res/validator/jquery.validator.js"></script>
<script type="text/javascript" src="res/validator/local/zh-CN.js"></script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理2</li>
			<li>报销单</li>
	
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
	<form action="expa/add.do" method="post"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}"
		class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expenseName"
							placeholder="请输入报销原因" data-rule="报销原因:required;" />
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销金额</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expenseTotal"
							placeholder="请输入报销金额" data-rule="报销金额:required;" />
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
						<textarea rows="" class="form-control" name="expenseDesc" cols=""></textarea>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="提交报销单" class="btn btn-success" />
			</div>
		</div>
	</form>

</body>
</html>