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
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Danh sách thành viên</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
					<a href="<%=CONTEXT_PATH + PathConfig.USER_ADD%>"
						class="btn btn-sm btn-success">Thêm mới</a>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /row -->
			<div class="row">
				<div class="col-sm-12">
					<div class="white-box">
						<div class="table-responsive">
							<table class="table" id="example">
								<thead>
									<tr>
										<th>STT</th>
										<th>Full Name</th>
										<th>Email</th>
										<th>Role</th>
										<th>#</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${ users }">
										<tr>
											<td>${ user.id }</td>
											<td>${ user.fullname }</td>
											<td>${ user.email }</td>
											<td>${ user.role_description }</td>
											<td><a href="<%= CONTEXT_PATH + PathConfig.USER_EDIT %>?id=${ user.id }" class="btn btn-sm btn-primary">Sửa</a> <a
												href="<%= CONTEXT_PATH + PathConfig.USER_REMOVE %>?id=${ user.id }" class="btn btn-sm btn-danger">Xóa</a> <a
												href="<%= CONTEXT_PATH + PathConfig.USER_DETAIL %>?id=${ user.id }" class="btn btn-sm btn-info">Xem</a>
											</td>
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