<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			alert("회원정보 변경에 성공 했습니다.")
			location.href="main.do?";          //메인페이지로 이동
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("회원정보 변경에 실패 했습니다.")
			location.href="prfUpdateForm.do?"; //회원정보변경 페이지로 이동
		</script>
	</c:if>
</body>
</html>