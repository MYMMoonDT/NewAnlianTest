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
						<h3 class="panel-title">查看项目档案</h3>
					</div>
					<div class="panel-body panel-project-doc">
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">1.项目录入</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;合同评审记录
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">2.项目下达</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;工作任务单
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">3.项目前期准备</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;客户资料登记单
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;现场调查记录
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;评价方案
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;评价方案审核记录
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;检测通知单
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;采样方案
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">4.检测环节</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;实验仪器安排表
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">5.实验环节</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;送样收样记录
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">6.数据处理</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;实验室分析原始记录
								</a>
							</div>
							<div class="col-md-3">
								<a href="javascript:void(0);" class="project-doc-link">
									<span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;数据处理过程记录
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">7.报告书编制</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">8.报告书初审</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">9.报告书评审</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">10.报告书发放</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="label label-primary">11.项目验收</label>
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