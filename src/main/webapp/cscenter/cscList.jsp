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
	<c:if test="${mem_num==null||grade==null }">
		<script type="text/javascript">
			alert("로그인 해주시기 바랍니다");
			location.href="loginForm.do";
		</script>
	</c:if>
	
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px; text-align: center;">
		1:1 문의 내역
	</h1>	
	<div class="col-lg-8 col-md-8 mx-auto">
			<c:if test="${grade=='1'||grade=='2' }">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscInsert.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">문의하기</button>
			</c:if>
	         <table class="table">
	         	<thead class="table-dark">
	         		<tr>
	         			<th>No.</th><th>유형</th><th>제목</th><th>작성일자</th><th>답변 상태</th>
	         		</tr>
	         	</thead>
	         	<c:if test="${totCnt > 0 }">
	         		<tbody>
		         		<c:forEach var="Cscenter" items="${list }">
		         			<tr onclick="location.href='cscRead.do?cs_num=${Cscenter.cs_num}&pageNum=${currentPage}&startNum=${startNum }'" style="cursor: pointer;">
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
		          					<c:if test="${Cscenter.cs_status=='N' }">
			          				<td style="color: red; text-align: center;">
		          						대기
		          					</td>
		          					</c:if>
		          					<c:if test="${Cscenter.cs_status=='Y' }">
		          					<td style="color: blue; text-align: center;">
		          						완료
			          				</td>
		          					</c:if>
		 		          	</tr>
		 		          	<c:set var="startNum" value="${startNum - 1 }" />
		         		</c:forEach>
	         		</tbody>
	         	</c:if>
	         	
         		<c:if test="${totCnt == 0 }">
					<tr>
						<td colspan="5" style="text-align: center;">문의된 내역이 없습니다</td>
					</tr>
				</c:if>
	         </table>
	         
	         <c:if test="${grade=='1'||grade=='2' }">
	         	 <ul class="pagination" style="justify-content: center;">
				    <c:if test="${startPage > blockSize }">
					    <li class="page-item">
					      <a class="page-link" href="cscPList.do?pageNum=${startPage-blockSize }" aria-label="이전">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <c:forEach var="i" begin="${startPage }" end="${endPage }">
				    	<c:if test="${currentPage==i }">
				    		<li class="page-item active"><a class="page-link" href="cscPList.do?pageNum=${i}">${i }</a></li>	
				    	</c:if>
				    	<c:if test="${currentPage!=i }">
							<li class="page-item"><a class="page-link" href="cscPList.do?pageNum=${i}">${i }</a></li>	
				    	</c:if>
					</c:forEach>
					<c:if test="${endPage<pageCnt }">
					    <li class="page-item">
					      <a class="page-link" href="cscPList.do?pageNum=${startPage+blockSize }" aria-label="다음">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:if>
				  </ul>
	         </c:if>
	         <c:if test="${grade=='A' }">
		         <ul class="pagination" style="justify-content: center;">
				    <c:if test="${startPage > blockSize }">
					    <li class="page-item">
					      <a class="page-link" href="cscList.do?pageNum=${startPage-blockSize }" aria-label="이전">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <c:forEach var="i" begin="${startPage }" end="${endPage }">
				    	<c:if test="${currentPage==i }">
				    		<li class="page-item active"><a class="page-link" href="cscList.do?pageNum=${i}">${i }</a></li>	
				    	</c:if>
				    	<c:if test="${currentPage!=i }">
							<li class="page-item"><a class="page-link" href="cscList.do?pageNum=${i}">${i }</a></li>	
				    	</c:if>
					</c:forEach>
					<c:if test="${endPage<pageCnt }">
					    <li class="page-item">
					      <a class="page-link" href="cscList.do?pageNum=${startPage+blockSize }" aria-label="다음">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:if>
				  </ul>
	         </c:if>
	         
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