<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL标签</h1>
	<!-- 输出文字到页面中 -->
	<c:out value="学习JSTL标签"></c:out>
	<c:set var="name" value="大佬"></c:set>
	<br>
	<c:out value="I am ${name}"></c:out>
	<!-- if判断 -->
	<c:if test="${name=='天文'}">
		<h1>${name}是大帅比</h1>
	</c:if>
	<!-- 多重if判断 -->
	<c:choose>
		<c:when test="${name=='天文' }">
			<h2>天文，你好</h2>
		</c:when>
		<c:when test="${name=='大佬' }">
			<h2>大佬，你好</h2>
		</c:when>
		<c:otherwise>
			<h2>请问你是？</h2>
		</c:otherwise>
	</c:choose>
	
	<!-- 固定次数的循环 -->
	<c:forEach var="i" begin="10" end="20" step="1">
		<p style="font-size:${i}px">这是段落${i}</p>
	</c:forEach>
	
</body>
</html>