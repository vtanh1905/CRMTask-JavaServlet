<%@page import="com.vtanh1905.entity.User"%>
<% 
	final String CONTEXT_PATH = request.getContextPath();
	final User USERLOGIN = (User)request.getSession().getAttribute("userLogin");
%>