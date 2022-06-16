<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<c:if test="${id != null}">
		<script>
			alert("회원님의 아이디는  ${id} 입니다.");
			location.href="loginForm.do?"; //로그인 화면 이동
		</script>
	</c:if>
	<c:if test="${id == null}">
		<script>
			alert("가입되지 않은 정보 입니다.");
			history.go(-1);                //아이디 찾기 이동
		</script>
	</c:if>
</body>
</html>