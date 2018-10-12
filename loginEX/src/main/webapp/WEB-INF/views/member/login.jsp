<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			if(userId == "") {
				alert("아이디를 입력하세요");
				$("#userId").focus();
				return;
			}
			if(userPw == "") {
				alert("비밀번호를 입력");
				$("#userPw").focus();
				return
			}
			
			document.form1.action="${path}/member/loginCheck.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>

<form name="form1" method="post">
	<table border="1" width="400px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId", id="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="userPw", id="userPw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnLogin">로그인</button>
			<c:if test="${msg == 'failure'}">
				<div style="color: red">
					아이디 또는 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${msg == 'logout' }">
				<div style="color:red">
					로그아웃 되었습니다.
				</div>
			</c:if>
			</td>
		</tr>
	</table>
</form>
</body>
</html>