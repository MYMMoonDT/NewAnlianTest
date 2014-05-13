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
						<h3 class="panel-title">创建法律法规档案</h3>
					</div>
				  	<div class="panel-body">
				  		<form role="form" action="${context}/document/law/doCreate" method="POST">
				  			<div class="form-group">
							  	<label for="lawNum">法律法规编号</label>
							  	<input type="text" class="form-control" id="lawNum" name="lawNum">
							</div>
							<div class="form-group">
							  	<label for="lawName">法律法规名称</label>
							  	<input type="text" class="form-control" id="lawName" name="lawName">
							</div>
							<div class="form-group">
							  	<label for="lawPublishUnit">发布单位</label>
							  	<input type="text" class="form-control" id="lawPublishUnit" name="lawPublishUnit">
							</div>
							<div class="form-group">
							  	<label for="lawPublishTime">发布时间</label>
							  	<input type="date" class="form-control" id="lawPublishTime" name="lawPublishTime">
							</div>
							<div class="form-group">
							  	<label for="lawFile">法律法规文件</label>
							  	<input type="file" class="form-control" id="lawFile" name="lawFile">
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