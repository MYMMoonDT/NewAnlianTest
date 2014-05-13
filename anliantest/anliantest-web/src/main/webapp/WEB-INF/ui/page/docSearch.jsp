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
						<h3 class="panel-title">档案全文搜索</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="row">
								<div class="col-md-10">
	        						<input type="text" class="form-control" placeholder="输入搜索文档关键字">
	      						</div>
	      						<div class="col-md-2">
	      							<button type="submit" class="btn btn-primary">搜&nbsp;索</button>
	      						</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-primary">
								  <div class="panel-heading">文档名称: 《工作场所有害因素职业接触限值 第1部分:化学有害因素》</div>
								  <div class="panel-body">
								     	文档内容: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
								  </div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-primary">
								  <div class="panel-heading">文档名称: 《工作场所有害因素职业接触限值 第1部分:化学有害因素》</div>
								  <div class="panel-body">
								     	文档内容: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
								  </div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-primary">
								  <div class="panel-heading">文档名称: 《工作场所有害因素职业接触限值 第1部分:化学有害因素》</div>
								  <div class="panel-body">
								     	文档内容: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
								  </div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-primary">
								  <div class="panel-heading">文档名称: 《工作场所有害因素职业接触限值 第1部分:化学有害因素》</div>
								  <div class="panel-body">
								     	文档内容: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
								  </div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<ul class="pagination pull-left">
								  <li><a href="#">&laquo;</a></li>
								  <li><a href="#">1</a></li>
								  <li><a href="#">2</a></li>
								  <li><a href="#">3</a></li>
								  <li><a href="#">4</a></li>
								  <li><a href="#">5</a></li>
								  <li><a href="#">&raquo;</a></li>
								</ul>
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