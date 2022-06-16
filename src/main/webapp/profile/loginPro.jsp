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
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("로그인 되었습니다.");
			location.href="loginMain.do?"; //로그인된 메인 페이지로 이동
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
			location.href="loginForm.do?"; //로그인 페이지 이동
		</script>
	</c:if>
	<c:if test="${result == -1 }">
		<script type="text/javascript">
			alert("존재하지 않는 계정 입니다.");
			location.href="loginForm.do?"; //로그인 페이지 이동
		</script>
	</c:if>
</body>
</html>