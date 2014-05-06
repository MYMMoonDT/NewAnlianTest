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
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${context}/ui/resources/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${context}/ui/resources/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${context}/ui/resources/css/base.css">

<script src="${context}/ui/resources/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${context}/ui/resources/bootstrap3/js/bootstrap.min.js"></script>
<script>
	$(function(){
		function getTaskId(parent){
			while(!parent.hasClass("panel-task")){
				parent = parent.parent();
			}
			var taskId = parent.find(".taskId").val();
			return taskId;
		}
		$(".btn-sign-contract-review").click(function(){
			var context = $("#webContext").val();
			var url = context + "/contractReview/doSign";
			var taskId = getTaskId($(this));
			var data = {
				"taskId" : taskId
			};
			var button = $(this);
			$.ajax(url,{
				type : "POST",
				data : data
			})
			.done(function(result){
				if(result.result == "success"){
					button.text("已签字");
					button.attr("disabled","disabled");
				}else{
					alert("error");
				}
			})
			.fail(function(){
				alert("error");
			})
			.always(function(){
				
			});
		});
		$(".btn-create-work-task").click(function(){
			var context = $("#webContext").val();
			var url = context + "/workTask/create";
			var taskId = getTaskId($(this));
			window.location.href = context + "/workTask/create?taskId=" + taskId;
		});
	});
</script>
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
					<c:param name="nav">home</c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">待办事宜</h3>
					</div>
				  	<div class="panel-body">
				  		<c:forEach var="taskItem" items="${taskList}">
				  			<div class="panel panel-primary">
					  			<div class="panel-body panel-task">
					  				<table class="table">
					  					<thead>
					  						<tr>
					  							<th>项目名称</th>
					  							<th>项目进度</th>
					  							<th>待办事宜</th>
					  							<th>操作</th>
					  						</tr>
					  					</thead>
					  					<tbody>
					  						<tr>
					  							<td><c:out value="${taskItem.projectInfo.projectName}"/></td>
					  							<td><c:out value="${taskItem.projectInfo.projectStatus}"/></td>
					  							<td><c:out value="${taskItem.taskType}"/></td>
					  							<c:choose>
					  								<c:when test="${taskItem.taskType == '合同评审记录签字'}">
												  		<td><button class="btn btn-primary btn-sign-contract-review">签字</button></td>
												  	</c:when>
												  	<c:when test="${taskItem.taskType == '创建工作任务单'}">
												  		<td><button class="btn btn-primary btn-create-work-task">创建</button></td>
												  	</c:when>
					  							</c:choose>	
					  						</tr>
					  					</tbody>
					  				</table>
					  				<input type="hidden" value="${taskItem.taskId}" class="taskId"/>
					  			</div>
					  		</div>
				        </c:forEach>
				  		<%-- <div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>1.项目录入</td>
				  							<td>合同评审表签字</td>
				  							<td>
				  								<button class="btn btn-primary">签字</button>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div>
				  		<div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>2.项目下达</td>
				  							<td>创建工作任务单</td>
				  							<td>
				  								<a href="${context}/workTask/create" class="btn btn-primary" role="button">创建</a>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div>
				  		<div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>3.项目前期准备</td>
				  							<td>创建客户资料登记单</td>
				  							<td>
				  								<a href="${context}/consumerResource/create" class="btn btn-primary" role="button">创建</a>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div>
				  		<div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>3.项目前期准备</td>
				  							<td>创建现场调查表</td>
				  							<td>
				  								<a href="${context}/fieldSurvey/create" class="btn btn-primary" role="button">创建</a>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div>
				  		<div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>3.项目前期准备</td>
				  							<td>评价方案审核记录</td>
				  							<td>
				  								<a href="${context}/evaluatePlanReview/create" class="btn btn-primary" role="button">创建</a>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div>
				  		<div class="panel panel-primary">
				  			<div class="panel-body">
				  				<table class="table">
				  					<thead>
				  						<tr>
				  							<th>项目名称</th>
				  							<th>项目进度</th>
				  							<th>待办事宜</th>
				  							<th>操作</th>
				  						</tr>
				  					</thead>
				  					<tbody>
				  						<tr>
				  							<td>浙江侨朋化工有限公司整治提升项目职业病危害控制效果评价</td>
				  							<td>3.项目前期准备</td>
				  							<td>创建检测通知单</td>
				  							<td>
				  								<a href="${context}/detectionNotice/create" class="btn btn-primary" role="button">创建</a>
				  							</td>
				  						</tr>
				  					</tbody>
				  				</table>
				  			</div>
				  		</div> --%>
				  	</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<c:import url="../component/footer.jsp"></c:import>
			</div>
		</div>
		<input id="webContext" type="hidden" value="${context}"/>
	</div>
</body>
</html>