<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String context = request.getContextPath();
%>
<form action="<%=context%>/studentView" method="post">
 ÀÌ¸§ : <input type="text" name="name">
 ³ªÀÌ : <input type=text name="age">
 ÇÐ³â : <input type="text" name="classNum">
 ¹Ý : <input type="text" name="gradeNum">
 <input type="submit" value="Àü¼Û">
</form>
</body>
</html>
