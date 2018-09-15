<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List"%>
<%@page import="wedding.dao.impl.UserDAOImpl"%>
<%@page import="wedding.entity.User" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 集合遍历 -->
	
	<%
		UserDAOImpl dao = new UserDAOImpl();
		List<User> users = dao.selectAllUsers();
		pageContext.setAttribute("users", users);
	%>
	<c:forEach var="user" items="${users}">
		<p>手机号：${user.user_tel},密码${user.user_password}</p>
	</c:forEach>
	
	
</body>
</html>