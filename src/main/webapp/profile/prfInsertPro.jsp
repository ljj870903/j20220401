<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0}">
		<script type="text/javascript">

			alert("회원가입 성공");
			location.href="loginForm.do?"; //로그인 페이지로 이동
		</script>
	</c:if>
	<c:if test="${result == 0}">
		<script type="text/javascript">
			alert("회원가입 실패");
			location.href="prfInsertForm.do?"; //회원가입 페이지로 이동
		</script>
	</c:if>
</body>
</html>