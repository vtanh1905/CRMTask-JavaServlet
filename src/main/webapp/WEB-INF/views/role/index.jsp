<%@page import="java.util.ArrayList"%>
<%@page import="com.vtanh1905.entity.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.vtanh1905.config.PathConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglib.jsp"%>
<%@ include file="/WEB-INF/views/commons/constants.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Role> roles = (ArrayList<Role>) request.getAttribute("roles");
		String messageError = (String)request.getAttribute("messageError");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Danh sách quyền</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
					<a href="<%=CONTEXT_PATH + PathConfig.ROLE_ADD%>"
						class="btn btn-sm btn-success">Thêm mới</a>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /row -->
			<div class="row">
				<div class="col-sm-12">
					<% if(messageError != null) { %>
								<div class="alert alert-danger" role="alert">${ messageError }</div>
					<% } %>
					<div class="white-box">
						<div class="table-responsive">
							<table class="table" id="example">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên Quyền</th>
										<th>Mô Tả</th>
										<th>Hành Động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="role" items="${roles}">
										<tr>
											<td>${ role.id }</td>
											<td>${ role.name }</td>
											<td>${ role.description }</td>
											<td><a href="<%=CONTEXT_PATH + PathConfig.ROLE_EDIT%>?id=${role.id}" class="btn btn-sm btn-primary">Sửa</a> <a
												href="<%=CONTEXT_PATH + PathConfig.ROLE_REMOVE%>?id=${role.id}" class="btn btn-sm btn-danger">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
</body>
</html>