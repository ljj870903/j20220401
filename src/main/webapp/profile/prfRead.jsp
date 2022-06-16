<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<c:if test="${id    != null }"><!--로그인 체크-->
<c:if test="${grade == 'A'  }"><!--권한 체크  -->
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
		<form action="prfReadPro.do">
			<table class="table" style="text-align: center;">
				<thead class="table-dark"><tr><th>회원번호</th><th>아이디</th><th>이름</th><th>이메일</th><th>연락처</th><th>주소</th><th>등급</th></tr></thead>
				<tbody>
					<c:forEach var="profile" items="${list }">
							<tr>
								<td>${profile.mem_num }</td>
								<td>${profile.id }</td>
								<td>${profile.name }</td>
								<td>${profile.email }</td>
								<td>${profile.phone }</td>
								<td>${profile.address }</td>
								<td>
									<c:if test="${profile.grade == 'A' }">관리자</c:if>
									<c:if test="${profile.grade == '1' }">일반회원</c:if>
									<c:if test="${profile.grade == '2' }">펫시터</c:if>
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>	
        </form>
	</div>
	
	<jsp:include page="../css/footer.jsp"></jsp:include>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<style>
		.navbar a:hover{
			color: white;
		}
		.footer a:hover{
			color: white;
		}
	</style>
</body>
</c:if>
<c:if test="${grade != 'A' }">
	<script type="text/javascript">
		alert("접근 권환이 없습니다.");
		history.go(-1);
	</script>
</c:if><!--권한 체크 -->
</c:if>
<c:if test="${id == null }">
	<script type="text/javascript">
		alert("로그인이 필요합니다..");
		location.href="loginForm.do?";
	</script>
</c:if><!--로그인 체크  -->
</html>