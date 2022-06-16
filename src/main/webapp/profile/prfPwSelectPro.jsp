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
	<c:if test="${pw != null}">
		<script type="text/javascript">
			alert("회원님의 비밀번호  ${pw} 입니다.");
			location.href="loginForm.do?";       //로그인 페이지 이동
		</script>
	</c:if>
	<c:if test="${pw == null}">
		<script type="text/javascript">
			alert("가입되지 않은 정보 입니다.");
			history.go(-1);						//이전페이지로 이동
		</script>
	</c:if>
</body>
</html>