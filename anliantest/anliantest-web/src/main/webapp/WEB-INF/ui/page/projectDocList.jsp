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
<link rel="stylesheet" href="${context}/ui/resources/plugins/DataTables-1.9.4/media/css/jquery.dataTables.css">
<link rel="stylesheet" href="${context}/ui/resources/plugins/DataTables-1.9.4/media/css/datatables.css">
<link rel="stylesheet" href="${context}/ui/resources/css/base.css">

<script src="${context}/ui/resources/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${context}/ui/resources/bootstrap3/js/bootstrap.min.js"></script>
<script src="${context}/ui/resources/plugins/DataTables-1.9.4/media/js/jquery.dataTables.min.js"></script>
<script src="${context}/ui/resources/plugins/DataTables-1.9.4/media/js/datatables.js"></script>
<script>
	var oTable;
	$(function(){
		oTable = $('#projectListTable').dataTable({
			"sPaginationType": "bs_full",
			"oLanguage": {
				"sProcessing":   "处理中...",
			    "sLengthMenu":   "_MENU_ 记录/页",
			    "sZeroRecords":  "没有匹配的记录",
			    "sInfo":         "显示第 _START_ 至 _END_ 项记录，共 _TOTAL_ 项",
			    "sInfoEmpty":    "显示第 0 至 0 项记录，共 0 项",
			    "sInfoFiltered": "(由 _MAX_ 项记录过滤)",
			    "sInfoPostFix":  "",
			    "sSearch":       "",
			    "sUrl":          "",
			    "oPaginate": {
			        "sFirst":    "首页",
			        "sPrevious": "上页",
			        "sNext":     "下页",
			        "sLast":     "末页"
			    }
	        }
		});
		$('.datatable').each(function(){
		    var datatable = $(this);
		    var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
		    search_input.attr('placeholder', 'Search');
		    search_input.addClass('form-control input-sm');
		    var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
		    length_sel.addClass('form-control input-sm');
		});
		
		
		$(document).on("click", "#projectListTable tbody tr", function( e ) {
	        if ( $(this).hasClass('row_selected') ) {
	            $(this).removeClass('row_selected');
	        }
	        else {
	            oTable.$('tr.row_selected').removeClass('row_selected');
	            $(this).addClass('row_selected');
	        }
	    });
	    /* Add a click handler for the delete row */
	    $('#deleteBtn').click( function() {
	        var anSelected = fnGetSelected( oTable );
	        if ( anSelected.length !== 0 ) {
	            oTable.fnDeleteRow( anSelected[0] );
	        }
	    } );
	    $('#viewBtn').click(function(){
	    	var anSelected = fnGetSelected( oTable );
	    	if(anSelected.length == 0){
	    		alert("请选择需要查看的项目");
	    	}else{
	    		var context = $("#webContext").val();
	    		//var projectId = $(anSelected[0]).find(".projectId").text();
		    	window.location.href = context + "/document/project/view";
	    	}
	    });
	});
	function fnGetSelected( oTableLocal )
	{
	    return oTableLocal.$('tr.row_selected');
	}
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
					<c:param name="nav">document</c:param>
				</c:import>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">项目档案管理</h3>
					</div>
				  	<div class="panel-body">
				  		<div class="row">
				  			<div class="col-sm-12">
						  		<div class="btn-group">
						  		  <a id="viewBtn" href="javascript:void(0);" class="btn btn-primary" role="button">查看</a>
						  		  <a id="deleteBtn" href="javascript:void(0);" class="btn btn-primary" role="button">删除</a>
								</div>
								<div class="btn-group pull-right">
						  		  <a id="importBtn" href="javascript:void(0);" class="btn btn-primary" role="button">导入</a>
						  		  <a id="exportBtn" href="javascript:void(0);" class="btn btn-primary" role="button">导出</a>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="dataTableContainer">
									<table id="projectListTable" class="datatable table table-striped table-bordered">
									    <thead>
									        <tr>
									            <th>项目编号</th>
									            <th>项目名称</th>
									            <th>项目类型</th>
									            <th>业务负责人</th>
									            <th>项目负责人</th>
									            <th>创建时间</th>
									        </tr>
									    </thead>
									    <tbody>
									        <tr>
									        	<td>2013-KP-015</td>
									        	<td>浙江侨朋化工有限公司化工行业整治提升项目职业病危害控制效果评价报告书</td>
									        	<td>建设项目职业病危害控制效果评价</td>
									        	<td>王勇</td>
									        	<td>石繁</td>
									        	<td>2014-5-5</td>
									        </tr>
									        <tr>
									        	<td>2013-KP-015</td>
									        	<td>浙江侨朋化工有限公司化工行业整治提升项目职业病危害控制效果评价报告书</td>
									        	<td>建设项目职业病危害控制效果评价</td>
									        	<td>王勇</td>
									        	<td>石繁</td>
									        	<td>2014-5-5</td>
									        </tr>
									        <tr>
									        	<td>2013-KP-015</td>
									        	<td>浙江侨朋化工有限公司化工行业整治提升项目职业病危害控制效果评价报告书</td>
									        	<td>建设项目职业病危害控制效果评价</td>
									        	<td>王勇</td>
									        	<td>石繁</td>
									        	<td>2014-5-5</td>
									        </tr>
									        <tr>
									        	<td>2013-KP-015</td>
									        	<td>浙江侨朋化工有限公司化工行业整治提升项目职业病危害控制效果评价报告书</td>
									        	<td>建设项目职业病危害控制效果评价</td>
									        	<td>王勇</td>
									        	<td>石繁</td>
									        	<td>2014-5-5</td>
									        </tr>
									    </tbody>
									</table>
								</div>
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
		<input id="webContext" type="hidden" value="${context}"/>
	</div>
</body>
</html>