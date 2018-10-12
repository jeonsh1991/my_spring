<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<c:if test="${msg == 'success' }">
	<h2>${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h2>
</c:if>
</body>
</html>
