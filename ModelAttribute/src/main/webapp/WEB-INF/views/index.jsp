<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	String context = request.getContextPath();
%>
<form action="<%=context%>/studentView" method="post">
 �̸� : <input type="text" name="name">
 ���� : <input type=text name="age">
 �г� : <input type="text" name="classNum">
 �� : <input type="text" name="gradeNum">
 <input type="submit" value="����">
</form>
</body>
</html>