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
<script src="${context}/ui/resources/js/jquery-tmpl/jquery.tmpl.min.js"></script>
<script src="${context}/ui/resources/js/jquery-ddSlick/jquery.ddslick.min.js"></script>
<script>
	$(function(){
		var currentBtn = null;
		$(".btn-add-consumer-resource-item").click(function(){
			var ID = $("#consumer-resource-tbody").children().length;
			ID = "[" + ID + "]";
			var consumerResourceList = "consumerResourceList" + ID;
			var data = {
				"consumerResourceList" : consumerResourceList	
			};
			$("#consumer-resource-item").tmpl(data).appendTo("#consumer-resource-tbody");
		});
		$("#consumer-resource-tbody").on("click",".btn-assign",function(){
			currentBtn = $(this);
			var context = $("#webContext").val();
			var url = context + "/employeeList";
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
			$("#assignEmployeeModal").modal();
		});
		$(".btn-assign-employee-confirm").click(function(){
			var ddData = $('#employeeDropdown').data('ddslick');
			if(ddData.selectedData != null){
				var input = currentBtn.parent().find("input");
				input.val(ddData.selectedData.value);
				currentBtn.text(ddData.selectedData.text);
				currentBtn.attr("disabled","disabled");
				currentBtn.removeClass("btn-primary").addClass("btn-default");
				$("#assignEmployeeModal").modal("hide");
				currentBtn = null;
			}
		});
	});
</script>
<script id="consumer-resource-item" type="text/x-jquery-tmpl">
<tr>
	<td>
		<input type="text" class="form-control" id="{{html consumerResourceList}}.resourceName" name="{{html consumerResourceList}}.resourceName">
	</td>
	<td>
		<input type="date" class="form-control" id="{{html consumerResourceList}}.submitTime" name="{{html consumerResourceList}}.submitTime">
	</td>
	<td>
		<input type="number" class="form-control" id="{{html consumerResourceList}}.resourceQuantity" name="{{html consumerResourceList}}.resourceQuantity">
	</td>
	<td>
		<input type="hidden" id="{{html consumerResourceList}}.resourceReceiverId" name="{{html consumerResourceList}}.resourceReceiverId" value="-1">
		<button type="button" class="btn btn-primary btn-assign">指定</button>
	</td>
	<td>
		<input type="date" class="form-control" id="{{html consumerResourceList}}.returnTime" name="{{html consumerResourceList}}.returnTime">
	</td>
	<td>
		<input type="hidden" id="{{html consumerResourceList}}.resourceReturnerId" name="{{html consumerResourceList}}.resourceReturnerId" value="-1">
		<button type="button" class="btn btn-primary btn-assign">指定</button>
	</td>
</tr>
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
					<c:param name="nav">project</c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">创建客户资料登记单</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="${context}/consumerResource/doCreate" method="POST">
							<div class="form-group">
							  <label for="tableNum">表码</label>
							  <input type="text" class="form-control" id="tableNum" name="tableNum" value="ALJC/JL32-02" disabled>
							</div>
							<div class="form-group">
							  <label for="companyName">客户名称</label>
							  <input type="text" class="form-control" id="companyName" name="companyName" value="${CURRENT_PROJECT_INFO.companyName}" disabled>
							</div>
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum" value="${CURRENT_PROJECT_INFO.projectNum}" disabled>
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-primary btn-add-consumer-resource-item">添加</button>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>提交评价资料名称</th>
												<th>提交日期</th>
												<th>数量</th>
												<th>接收人</th>
												<th>返还日期</th>
												<th>返还人</th>
											</tr>
										</thead>
										<tbody id="consumer-resource-tbody">
											<tr>
												<td>
													<input type="text" class="form-control" id="consumerResourceList[0].resourceName" name="consumerResourceList[0].resourceName">
												</td>
												<td>
													<input type="date" class="form-control" id="consumerResourceList[0].submitTime" name="consumerResourceList[0].submitTime">
												</td>
												<td>
													<input type="number" class="form-control" id="consumerResourceList[0].resourceQuantity" name="consumerResourceList[0].resourceQuantity">
												</td>
												<td>
													<input type="hidden" id="consumerResourceList[0].resourceReceiverId" name="consumerResourceList[0].resourceReceiverId" value="-1">
													<button type="button" class="btn btn-primary btn-assign">指定</button>
												</td>
												<td>
													<input type="date" class="form-control" id="consumerResourceList[0].returnTime" name="consumerResourceList[0].returnTime">
												</td>
												<td>
													<input type="hidden" id="consumerResourceList[0].resourceReturnerId" name="consumerResourceList[0].resourceReturnerId" value="-1">
													<button type="button" class="btn btn-primary btn-assign">指定</button>
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
		<input id="webContext" type="hidden" value="${context}"/>
	</div>
	<div class="modal fade" id="assignEmployeeModal" tabindex="-1" role="dialog" aria-labelledby="assignEmployeeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="assignEmployeeModalLabel">指定人员</h4>
				</div>
				<div class="modal-body">
					<div id="employeeDropdown"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary btn-assign-employee-confirm">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>