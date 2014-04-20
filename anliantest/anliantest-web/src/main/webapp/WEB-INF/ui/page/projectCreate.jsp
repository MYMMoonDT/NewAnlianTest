<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>项目管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${context}/ui/resources/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${context}/ui/resources/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${context}/ui/resources/css/base.css">

<script src="${context}/ui/resources/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${context}/ui/resources/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<c:import url="../component/header.jsp"></c:import>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<c:import url="../component/left.jsp">
					<c:param name="nav">project</c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">创建项目</h3>
					</div>
				  	<div class="panel-body">
						<form role="form" action="${context}/project/doCreate">
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum">
							</div>
							<div class="form-group">
							  <label for="projectName">项目名称</label>
							  <input type="text" class="form-control" id="projectName" name="projectName">
							</div>
							<div class="form-group">
							  <label for="projectType">项目类型</label>
							  <select class="form-control" id="projectType" name="projectType">
							  	<option value="建设项目职业病危害控制效果评价">建设项目职业病危害控制效果评价</option>
							  </select>
							</div>
							<div class="form-group">
							  <label for="companyName">企业名称</label>
							  <input type="text" class="form-control" id="companyName" name="companyName">
							</div>
							<div class="form-group">
							  <label for="companyAddress">企业地址</label>
							  <input type="text" class="form-control" id="companyAddress" name="companyAddress">
							</div>
							<div class="form-group">
							  <label for="contactPerson">联系人</label>
							  <input type="text" class="form-control" id="contactPerson" name="contactPerson">
							</div>
							<div class="form-group">
							  <label for="contactTel">联系电话</label>
							  <input type="text" class="form-control" id="contactTel" name="contactTel">
							</div>
							<div class="form-group">
							  <label for="businessEmployee">业务负责人</label>
							  <select class="form-control" id="businessEmployee" name="businessEmployee"></select>
							</div>
							<div class="form-group">
							  <label for="contractAmount">合同额</label>
							  <input type="text" class="form-control" id="contractAmount" name="contractAmount">
							</div>
							<button type="submit" class="btn btn-primary">下一步</button>
						</form>
				  	</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<c:import url="../component/footer.jsp"></c:import>
			</div>
		</div>
	</div>
</body>
</html>