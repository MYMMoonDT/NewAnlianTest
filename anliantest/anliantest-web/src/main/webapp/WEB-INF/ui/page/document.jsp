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
<title>档案管理</title>
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
					<c:param name="nav">document</c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">档案管理</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3">
								<a href="${context}/document/employee/list" class="document-icon-container">
									<span class="glyphicon glyphicon-user"></span>
									<span class="title">人事档案管理</span>
								</a>
							</div>
							<div class="col-md-3">
								<a href="#" class="document-icon-container">
									<span class="glyphicon glyphicon-folder-open"></span>
									<span class="title">项目档案管理</span>
								</a>
							</div>
							<div class="col-md-3">
								<a href="#" class="document-icon-container">
									<span class="glyphicon glyphicon-tasks"></span>
									<span class="title">法律法规档案管理</span>
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="#" class="document-icon-container">
									<span class="glyphicon glyphicon-book"></span>
									<span class="title">行业标准档案管理</span>
								</a>
							</div>
							<div class="col-md-3">
								<a href="#" class="document-icon-container">
									<span class="glyphicon glyphicon-search"></span>
									<span class="title">档案全文搜索</span>
								</a>
							</div>
						</div>
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