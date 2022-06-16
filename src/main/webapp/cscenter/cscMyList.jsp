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
	    <div>
	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	<div>
		<h2>문의내역</h2>
	         <table class="table">
	         	<thead class="table-dark">
	         		<tr>
	         			<th>NO</th><th>유형</th><th>제목</th><th>작성일자</th>
	         		</tr>
	         	</thead>
	         	<c:if test="${myqCnt >0 }">
	         		<tbody>
		         		<c:forEach var="Cscenter" items="${list }">
			         			<tr onclick="location.href='cscRead.do?cs_num=${Cscenter.cs_num}&pageNum=${currentPage}'" style="cursor: pointer;">
			          				<td>${startNum }</td>
			          				<td>
			          					<c:choose>
											<c:when test="${Cscenter.cs_category eq '1'}">개인정보</c:when>
											<c:when test="${Cscenter.cs_category eq '2'}">예약관련</c:when>
											<c:when test="${Cscenter.cs_category eq '3'}">펫시터 지원</c:when>
											<c:otherwise>관리자</c:otherwise>
										</c:choose>
			          				</td>
			          				<td>${Cscenter.cs_title }</td>
			          				<td>${Cscenter.cs_date }</td>
			 		          	</tr>
			 		          	<c:set var="startNum" value="${startNum - 1 }" />
		         		</c:forEach>
	         		</tbody>
	         	</c:if>
	         	
         		<c:if test="${myqCnt == 0 }">
					<tr>
						<td colspan=7>문의된 내역이 없습니다.</td>
					</tr>
				</c:if>
	         	
	         </table>
	         <div style="text-align: center;">
				<c:if test="${startPage > blockSize }">
					<a href="cscMyList.do?pageNum=${startPage-blockSize }">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="cscMyList.do?pageNum=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${endPage > pageCnt }">
					<a href="cscMyList.do?pageNum=${startPage+blockSize }">[다음]</a>
				</c:if>
			</div>
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