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
 이름 : <input type="text" name="name">
 나이 : <input type=text name="age">
 학년 : <input type="text" name="classNum">
 반 : <input type="text" name="gradeNum">
 <input type="submit" value="전송">
</form>
</body>
</html>