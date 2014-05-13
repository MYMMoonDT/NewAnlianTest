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
						<h3 class="panel-title">创建行业标准档案</h3>
					</div>
				  	<div class="panel-body">
				  		<form role="form" action="${context}/document/standard/doCreate" method="POST">
				  			<div class="form-group">
							  	<label for="standardNum">行业标准编号</label>
							  	<input type="text" class="form-control" id="standardNum" name="standardNum">
							</div>
							<div class="form-group">
							  	<label for="standardName">行业标准名称</label>
							  	<input type="text" class="form-control" id="standardName" name="standardName">
							</div>
							<div class="form-group">
							  	<label for="standardFile">行业标准文件</label>
							  	<input type="file" class="form-control" id="standardFile" name="standardFile">
							</div>
				  			<button type="submit" class="btn btn-primary">创建</button>
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