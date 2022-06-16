<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
String context = request.getContextPath();
%>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	    <div>
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->


<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px; text-align: center;">나의 반려동물 목록</h1>
	
	<div class="col-lg-8 col-md-8 mx-auto">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='petInsertForm.do?pet_num=${petinfo.pet_num}'">펫 등록하기</button>
		<table class="table table-striped table table-hover" style="margin-top: 30px; text-align: center;">
			<thead class="table-secondary">
				<tr>
					<td>이름</td>
					<td>성별</td>
					<td>품종</td>
					<td>나이</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="petinfo" items="${petinfoList }">
				<tr onclick="location.href='petContent.do?pet_num=${petinfo.pet_num}'" style="cursor: pointer;">
					<td>${petinfo.pet_name}</td>
					<td>
						<c:if test="${petinfo.pet_gender=='M' }">남자</c:if>
						<c:if test="${petinfo.pet_gender=='F' }">여자</c:if>
					</td>
					<td>${petinfo.pet_type}</td>
					<td>${petinfo.pet_age}살</td>
				</tr>
				<c:set var="startNum" value="${startNum-1 }"/>
				</c:forEach>
			</tbody>
		
		</table>
	</div>
	
<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	    </div>
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
</html>
