<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
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
			
			
			
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px; text-align: center;">나의 예약 현황</h1>
		
		<div class="col-lg-8 col-md-8 mx-auto">
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='resInsertForm.do'" style="margin-bottom: 10px;">예약하기</button>
			<table class="table table-striped table table-hover" style="margin-top: 30px; text-align: center;">
				<thead class="table-secondary">
					<tr>
						<td>지역</td>
						<td>돌봄 날짜</td>
						<td>시작 시간</td>
						<td>종료 시간</td>
						<td>진행 상태</td>
					</tr>
				</thead>
				<tbody>
				<c:if test="${totCnt >0}">
					<c:forEach var="Reservation" items="${list }">
					<tr onclick="location.href='content.do?res_num=${Reservation.res_num }&pageNum=${pageNum}&mem_num=${mem_num}'" style="cursor: pointer;">
						<td>${Reservation.address }</td>
						<td>${Reservation.sit_date }</td>
						<td>${Reservation.sit_start }시</td>
						<td>${Reservation.sit_end }시</td>
						<c:if test="${Reservation.res_st=='펫시터예약완료' }">
							<td style="color: blue;">집사 구했다</td>
						</c:if>
						<c:if test="${Reservation.res_st=='예약요청' }">
							<td style="color: red;">집사 구해줘</td>
						</c:if>
					</tr>
					</c:forEach>
					</c:if>
					<c:forEach var="Reservation2" items="${list2 }">
					<tr onclick="location.href='content.do?res_num=${Reservation2.res_num }&pageNum=${pageNum}&mem_num=${mem_num}'" style="cursor: pointer;">
					<td>${Reservation2.address }</td>
						<td>${Reservation2.sit_date }</td>
						<td>${Reservation2.sit_start }시</td>
						<td>${Reservation2.sit_end }시</td>
						<c:if test="${Reservation2.res_st=='펫시터예약완료' }">
							<td style="color: green;">내가 집사</td>
						</c:if>
					</tr>
					</c:forEach>
				<c:if test="${totCnt ==0 }">
					<td colspan="5">예약 내역이 없습니다</td>
				</c:if>
				</tbody>
			</table>
		</div>
		
		<ul class="pagination" style="justify-content: center;">
	    <c:if test="${startPage > blockSize }">
		    <li class="page-item">
		      <a class="page-link" href="resList.do?pageNum=${startPage-blockSize }" aria-label="이전">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:if>
	    <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    	<c:if test="${currentPage==i }">
	    		<li class="page-item active"><a class="page-link" href="resList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
	    	<c:if test="${currentPage!=i }">
				<li class="page-item"><a class="page-link" href="resList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
		</c:forEach>
		<c:if test="${endPage>pageCnt }">
		    <li class="page-item">
		      <a class="page-link" href="resList.do?pageNum=${startPage+blockSize }" aria-label="다음">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		</c:if>
	  </ul>
			
			
			
			
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