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
						<h3 class="panel-title">创建合同评审表</h3>
					</div>
				  	<div class="panel-body">
				  		<form role="form" action="${context}/contractreview/doCreate">
				  			<div class="form-group">
							  <label for="tableNum">表码</label>
							  <input type="text" class="form-control" id="tableNum" name="tableNum" value="ALJC/JL07-03" disabled>
							</div>
							<div class="form-group">
							  <label for="projectName">项目名称</label>
							  <input type="text" class="form-control" id="projectName" name="projectName">
							</div>
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum">
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>部门</th>
												<th>重点评审内容</th>
												<th>评审意见摘要</th>
												<th>签字</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>评价部</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<span class="label label-default">未签字</span>
												</td>
												<td></td>
											</tr>
											<tr>
												<td>检测部</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<span class="label label-default">未签字</span>
												</td>
												<td></td>
											</tr>
											<tr>
												<td>行政部</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<span class="label label-default">未签字</span>
												</td>
												<td></td>
											</tr>
											<tr>
												<td>质控部</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<span class="label label-default">未签字</span>
												</td>
												<td></td>
											</tr>
											<tr>
												<td>总经理</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<textarea class="form-control" rows="5"></textarea>
												</td>
												<td>
													<span class="label label-default">未签字</span>
												</td>
												<td></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="form-group">
							  <label>技术负责人签字: </label>
							  <span class="label label-default">未签字</span>
							</div>
				  			<button type="submit" class="btn btn-primary">完成</button>
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