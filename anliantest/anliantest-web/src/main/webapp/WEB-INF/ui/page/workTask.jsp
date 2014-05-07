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
						<h3 class="panel-title">创建工作任务单</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="${context}/workTask/doCreate" method="POST">
							<div class="form-group">
							  <label for="projectName">项目名称</label>
							  <input type="text" class="form-control" id="projectName" name="projectName" value="${CURRENT_PROJECT_INFO.projectName}" disabled>
							</div>
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum" value="${CURRENT_PROJECT_INFO.projectNum}" disabled>
							</div>
							<div class="form-group">
							  <label for="taskIssuedEmployee">项目下达者</label>
							  <input type="text" class="form-control" id="taskIssuedEmployee" name="taskIssuedEmployee" value="${EMPLOYEE_CONTEXT.employeeName}" disabled>
							  <input type="hidden" id="taskIssuedEmployeeId" name="taskIssuedEmployeeId" value="${EMPLOYEE_CONTEXT.employeeId}">
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>组别</th>
												<th>工作内容</th>
												<th>工作时限</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>评价组</td>
												<td>
													<textarea id="evaluateWorkContent" name="evaluateWorkContent" class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea id="evaluateWorkTimeLimit" name="evaluateWorkTimeLimit" class="form-control" rows="5"></textarea>
												</td>
											</tr>
											<tr>
												<td>检测组</td>
												<td>
													<textarea id="detectWorkContent" name="detectWorkContent" class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea id="detectWorkTimeLimit" name="detectWorkTimeLimit" class="form-control" rows="5"></textarea>
												</td>
											</tr>
											<tr>
												<td>质控组</td>
												<td>
													<textarea id="qualityWorkContent" name="qualityWorkContent" class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea id="qualityWorkTimeLimit" name="qualityWorkTimeLimit" class="form-control" rows="5"></textarea>
												</td>
											</tr>
											<tr>
												<td>行政组</td>
												<td>
													<textarea id="adminWorkContent" name="adminWorkContent" class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea id="adminWorkTimeLimit" name="adminWorkTimeLimit" class="form-control" rows="5"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
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