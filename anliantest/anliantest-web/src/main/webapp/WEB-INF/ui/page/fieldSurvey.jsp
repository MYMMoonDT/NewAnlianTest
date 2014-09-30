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
						<h3 class="panel-title">创建现场调查表</h3>
					</div>
					<div class="panel-body">
						<form role="form" enctype=”multipart/form-data” action="${context}/fieldSurvey/doCreate">
							<div class="form-group">
							  <label for="tableNum">表码</label>
							  <input type="text" class="form-control" id="tableNum" name="tableNum" value="ALJC/JL32-13" disabled>
							</div>
							<div class="form-group">
							  <label for="projectName">项目名称</label>
							  <input type="text" class="form-control" id="projectName" name="projectName" value="${CURRENT_PROJECT_INFO.projectName}" disabled>
							</div>
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum" value="${CURRENT_PROJECT_INFO.projectNum}" disabled>
							</div>
							<div class="form-group">
							  <label for="companyName">客户名称</label>
							  <input type="text" class="form-control" id="companyName" name="companyName" value="${CURRENT_PROJECT_INFO.companyName}" disabled>
							</div>
							<div class="form-group">
							  <label for="companyAddress">客户地址</label>
							  <input type="text" class="form-control" id="companyAddress" name="companyAddress" value="${CURRENT_PROJECT_INFO.companyAddress}" disabled>
							</div>
							<div class="form-group">
							  <label for="companyType">客户单位类型</label>
							  <input type="text" class="form-control" id="companyType" name="companyType">
							</div>
							<div class="form-group">
							  <label for="companyIndustry">客户所属行业</label>
							  <input type="text" class="form-control" id="companyIndustry" name="companyIndustry">
							</div>
							<label>客户员工数量</label>
							<div class="row">
								<div class="col-sm-2">
									<div class="form-group">
										<label for="manageEmployeeNum" class="control-label">管理人员</label>
										<input type="number" class="form-control" id="companyManagerNum" name="companyManagerNum" value="0">
									</div>
								</div>
								<div class="col-sm-2">
									<div class="form-group">	
										<label for="productEmployeeNum" class="control-label">生产人员</label>
										<input type="number" class="form-control" id="companyEmployeeNum" name="companyEmployeeNum" value="0">
									</div>
								</div>
							</div>
							<label>客户单位内部职业卫生管理部门</label>
							<div class="form-group">
								<label class="radio-inline">
							  		<input type="radio" name="companySanitationIsExist" id="isHaveHealthDepartmentT" value="1" checked> 有
								</label>
								<label class="radio-inline">
							  		<input type="radio" name="companySanitationIsExist" id="isHaveHealthDepartmentF" value="0"> 无
								</label>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
									  <label for="healthDepartmentName">部门名称</label>
									  <input type="text" class="form-control" id="companySanitationName" name="companySanitationName">
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
									  <label for="healthDepartmentNum">人数</label>
									  <input type="text" class="form-control" id="companySanitationNum" name="companySanitationNum">
									</div>
								</div>
							</div>
							<label>联系人</label>
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>联系人</th>
												<th>工作部门</th>
												<th>联系电话</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" class="form-control" name="contactPerson1" id="contactPerson1"></td>
												<td><input type="text" class="form-control" name="workDepartment1" id="workDepartment1"></td>
												<td><input type="text" class="form-control" name="contactTel1" id="contactTel1"></td>
											</tr>
											<tr>
												<td><input type="text" class="form-control" name="contactPerson2" id="contactPerson2"></td>
												<td><input type="text" class="form-control" name="workDepartment2" id="workDepartment2"></td>
												<td><input type="text" class="form-control" name="contactTel2" id="contactTel2"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<label>产品</label>
							<div class="row">
								<div class="col-sm-8">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>产品名称</th>
												<th>年产量</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" class="form-control" name="productName1" id="productName1"></td>
												<td><input type="text" class="form-control" name="productQuantity1" id="productQuantity1"></td>
											</tr>
											<tr>
												<td><input type="text" class="form-control" name="productName2" id="productName2"></td>
												<td><input type="text" class="form-control" name="productQuantity2" id="productQuantity2"></td>
											</tr>
											<tr>
												<td><input type="text" class="form-control" name="productName3" id="productName3"></td>
												<td><input type="text" class="form-control" name="productQuantity3" id="productQuantity3"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="form-group">
								<label for="companySupportResource">客户单位提供的资料</label>
								<textarea class="form-control" rows="5" name="companyProvideResource" id="companyProvideResource"></textarea>
							</div>
							<div class="form-group">
								<label for="totalProcess">总工艺流程</label>
								<textarea class="form-control" rows="5" name="totalProcess" id="totalProcess"></textarea>
							</div>
							<div class="form-group">
								<label for="materialList">原辅材料清单</label>
								<textarea class="form-control" rows="5" name="materialList" id="materialList"></textarea>
							</div>
							<div class="form-group">
    							<label for="projectFloorPlan">建设项目总平面布局图</label>
    							<input type="file" id="projectFloorPlan">
    						</div>
    						<div class="form-group">
							  <label for="investigator">调查人员</label>
							  <input type="text" class="form-control" id="investigator" name="investigator">
							</div>
							<div class="form-group">
							  <label for="accompany">陪同人员</label>
							  <input type="text" class="form-control" id="accompany" name="accompany">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">创建</button>
							</div>
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