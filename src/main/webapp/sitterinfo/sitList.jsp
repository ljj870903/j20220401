<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
<jsp:include page="../css/header.jsp"></jsp:include>

        <div class="container">
        	<div></div>
            <div>
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	
	
	<div class="col-lg-8 col-md-8 mx-auto">
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px;">펫시터 현황 조회</h1>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<td>번호</td><td>이름</td><td>아이디</td><td>생년월일</td><td>성별</td><td>주소</td><td>상태</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="profile" items="${list }">
			<tr onclick="location.href='sitSelect.do?mem_num1=${profile.mem_num }&pageNum=${currentPage}'" style="cursor: pointer;">
				<td>${startNum }</td>
				<td>${profile.name }</td>
				<td>${profile.id }</td>
				<td>${profile.birth }</td>
				<c:choose>
					<c:when test="${profile.gender=='M' }"><td>남자</td></c:when>
					<c:otherwise><td>여자</td></c:otherwise>
				</c:choose>
				<td>${profile.address }</td>
				<c:choose>
					<c:when test="${profile.grade=='1' }"><td style="color: red;">승인 대기</td></c:when>
					<c:otherwise><td style="color: blue;">등록 완료</td></c:otherwise>
				</c:choose>
			</tr>
			<c:set var="startNum" value="${startNum-1 }"/>
			</c:forEach>
		</tbody>
	</table>
	
	
	<ul class="pagination" style="justify-content: center;">
	    <c:if test="${startPage > blockSize }">
		    <li class="page-item">
		      <a class="page-link" href="sitList.do?pageNum=${startPage-blockSize }" aria-label="이전">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:if>
	    <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    	<c:if test="${currentPage==i }">
	    		<li class="page-item active"><a class="page-link" href="sitList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
	    	<c:if test="${currentPage!=i }">
				<li class="page-item"><a class="page-link" href="sitList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
		</c:forEach>
		<c:if test="${endPage>pageCnt }">
		    <li class="page-item">
		      <a class="page-link" href="sitList.do?pageNum=${startPage+blockSize }" aria-label="다음">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		</c:if>
	  </ul>
	
	</div>

<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
            </div>
        	<div></div>
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