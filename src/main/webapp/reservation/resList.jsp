<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<c:if test="${mem_num==0 }">
		<script type="text/javascript">
			alert("로그인을 해주세요");
			location.href="main.do";
		</script>
	</c:if>
	<c:if test="${grade=='1' }">
		<script type="text/javascript">
			alert("펫시터가 아닙니다")
			location.href="main.do";
		</script>
	</c:if>
	
	<jsp:include page="../css/header.jsp"></jsp:include>

	<div class="container">
		<div>
	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
			
			
			<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px;">예약 신청 게시판</h1>
	
				<div class="col-lg-8 col-md-8 mx-auto">
				<table class="table table-striped table table-hover" style="text-align: center;">
				<thead class="table-dark">
					<tr>
						<td width="20%">지역</td>
						<td width="20%">돌봄 날짜</td>
						<td width="20%">시작 시간</td>
						<td width="20%">종료 시간</td>
						<td width="20%">진행 상태</td>
					</tr>
				</thead>
				<tbody>
				<c:if test="${totCnt >0 }">
					<c:forEach var="Reservation" items="${list }">
					<tr onclick="location.href='content.do?res_num=${Reservation.res_num }&pageNum=${pageNum}'" style="cursor: pointer;">
						<td>${Reservation.address }</td>
						<td>${Reservation.sit_date }</td>
						<td>${Reservation.sit_start }시</td>
						<td>${Reservation.sit_end }시</td>
						<td>${Reservation.res_st}</td>
					</tr>
					</c:forEach>
				</c:if>
				<c:if test="${totCnt ==0 }">
					<tr>
						<td colspan="5">데이터가 없습니다</td>
					</tr>
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
		    		<li class="page-item active"><a class="page-link" href="resList.do?pageNum=${i}&mem_num=${mem_num}">${i }</a></li>	
		    	</c:if>
		    	<c:if test="${currentPage!=i }">
					<li class="page-item"><a class="page-link" href="resList.do?pageNum=${i}&mem_num=${mem_num}">${i }</a></li>	
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