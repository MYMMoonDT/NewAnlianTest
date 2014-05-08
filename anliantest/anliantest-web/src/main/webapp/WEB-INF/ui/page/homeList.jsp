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
<script src="${context}/ui/resources/js/jquery-ddSlick/jquery.ddslick.min.js"></script>

<script>
	$(function(){
		var currentTaskId = null;
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
		$(".btn-assign-business-employee").click(function(){
			var context = $("#webContext").val();
			var url = context + "/employeeList";
			currentTaskId = getTaskId($(this));
			$.ajax(url,{
				type: "GET"
			})
			.done(function(result){
				if(result.result == "success"){
					var ddData = [];
					for(var i = 0; i < result.employeeList.length; i++){
						var ddDataItem = {};
						ddDataItem.text = result.employeeList[i].employeeName;
						ddDataItem.value = result.employeeList[i].employeeId;
						ddDataItem.description = result.employeeList[i].employeeTitle;
						ddDataItem.imageSrc = context + result.employeeList[i].employeeAvatar;
						ddData.push(ddDataItem);
					}
					$('#employeeDropdown').ddslick({
					    data:ddData,
					    width:300,
					    selectText: "未指定",
					    imagePosition:"left"
					});
				}
			})
			.fail(function(){
				alert("error");
			})
			.always(function(){
				
			});
			$("#assignBusinessEmployeeModal").modal();
		});
		$(".btn-assign-business-employee-confirm").click(function(){
			var ddData = $('#employeeDropdown').data('ddslick');
			if(ddData.selectedData != null){
				var context = $("#webContext").val();
				var employeeId = ddData.selectedData.value;
				var data = {
					"employeeId" : employeeId,
					"taskId" : currentTaskId
				};
				var url = context + "/project/doAssign";
				$.ajax(url,{
					type: "POST",
					data: data
				})
				.done(function(result){
					console.log(result);
				})
				.fail(function(){
					alert("error");
				})
				.always(function(){
					window.location.reload();
				});
			}
		});
		$(".btn-create-consumer-resource").click(function(){
			var context = $("#webContext").val();
			var url = context + "/consumerResource/create";
			var taskId = getTaskId($(this));
			window.location.href = context + "/consumerResource/create?taskId=" + taskId;
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
												  	<c:when test="${taskItem.taskType == '指定项目负责人'}">
												  		<td><button class="btn btn-primary btn-assign-business-employee">指定</button></td>
												  	</c:when>
												  	<c:when test="${taskItem.taskType == '创建客户资料登记单'}">
												  		<td><button class="btn btn-primary btn-create-consumer-resource">创建</button></td>
												  	</c:when>
					  							</c:choose>	
					  						</tr>
					  					</tbody>
					  				</table>
					  				<input type="hidden" value="${taskItem.taskId}" class="taskId"/>
					  			</div>
					  		</div>
				        </c:forEach>
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
	<div class="modal fade" id="assignBusinessEmployeeModal" tabindex="-1" role="dialog" aria-labelledby="assignBusinessEmployeeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="assignBusinessEmployeeModalLabel">指定项目负责人</h4>
				</div>
				<div class="modal-body">
					<div id="employeeDropdown"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary btn-assign-business-employee-confirm">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>