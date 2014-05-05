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
<link rel="stylesheet" href="${context}/ui/resources/plugins/Buttons/css/buttons.css">
<link rel="stylesheet" href="${context}/ui/resources/css/base.css">

<script src="${context}/ui/resources/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${context}/ui/resources/bootstrap3/js/bootstrap.min.js"></script>
<script src="${context}/ui/resources/plugins/Buttons/js/buttons.js"></script>
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
						<h3 class="panel-title">查看/修改项目</h3>
					</div>
				  	<div class="panel-body">
						<form role="form" action="${context}/project/doEdit" method="POST">
							<div class="form-group">
								<label>项目进度</label>
								<div class="project-process-container">
									<div class="row process-row">
										<div class="col-sm-2">
				  							<a href="javascript:void(0);" class="button button-action button-circle">1.项目录入</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-action button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-highlight button-circle">2.项目下达</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">3.项目前期准备</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-3">
							  				<a href="javascript:void(0);" class="button button-circle">4.检测环节</a>
							  			</div>
									</div>
									<div class="row process-row">
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">5.实验环节</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">6.数据处理</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">7.报告书编制</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  		</div>
							  		<div class="row process-row">
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">8.报告书初审</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">9.报告书评审</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">10.报告书发放</a>
							  			</div>
							  			<div class="col-sm-1">
							  				<a href="javascript:void(0);" class="button button-pill"></a>
							  			</div>
							  			<div class="col-sm-2">
							  				<a href="javascript:void(0);" class="button button-circle">11.项目验收</a>
							  			</div>
							  		</div>
								</div>
							</div>
							<div class="form-group">
							  <label for="projectNum">项目编号</label>
							  <input type="text" class="form-control" id="projectNum" name="projectNum" value="${project.projectNum}">
							  <input type="hidden" id="projectId" name="projectId" value="${project.projectId}">
							</div>
							<div class="form-group">
							  <label for="projectName">项目名称</label>
							  <input type="text" class="form-control" id="projectName" name="projectName" value="${project.projectName}">
							</div>
							<div class="form-group">
							  <label for="projectType">项目类型</label>
							  <!-- <select class="form-control" id="projectType" name="projectType">
							  	<option value="建设项目职业病危害控制效果评价">建设项目职业病危害控制效果评价</option>
							  </select> -->
							  <input type="text" class="form-control" id="projectType" name="projectType" value="${project.projectType}" disabled>
							</div>
							<div class="form-group">
							  <label for="companyName">企业名称</label>
							  <input type="text" class="form-control" id="companyName" name="companyName" value="${project.companyName}">
							</div>
							<div class="form-group">
							  <label for="companyAddress">企业地址</label>
							  <input type="text" class="form-control" id="companyAddress" name="companyAddress" value="${project.companyAddress}">
							</div>
							<div class="form-group">
							  <label for="contactPerson">联系人</label>
							  <input type="text" class="form-control" id="contactPerson" name="contactPerson" value="${project.contactPerson}">
							</div>
							<div class="form-group">
							  <label for="contactTel">联系电话</label>
							  <input type="text" class="form-control" id="contactTel" name="contactTel" value="${project.contactTel}">
							</div>
							<div class="form-group">
							  <label for="businessEmployee">业务负责人</label>
							  <!-- <select class="form-control" id="businessEmployee" name="businessEmployee"></select> -->
							  <input type="text" class="form-control" id="businessEmployee" name="businessEmployee" value="${project.employeeInfoByBusinessEmployeeId.employeeName}" disabled>
							</div>
							<div class="form-group">
							  <label for="contractAmount">合同额</label>
							  <input type="text" class="form-control" id="contractAmount" name="contractAmount" value="${project.contractAmount}">
							</div>
							<button type="submit" class="btn btn-primary">保存</button>
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