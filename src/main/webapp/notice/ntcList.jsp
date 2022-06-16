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
	
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px;">공지 사항</h1>
	
	<div class="col-lg-8 col-md-8 mx-auto">
	<c:if test="${grade=='A' }">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscInsert.do" style="margin-bottom: 10px;">글쓰기</button>
	</c:if>
	<table class="table table-striped table table-hover">
	<thead class="table-dark">
		<tr>
			<td width="10%" style="text-align: center;">글번호</td><td width="50%" style="text-align: center;">제목</td>
			<td width="20%" style="text-align: center;">작성일</td><td width="20%" style="text-align: center;">조회수</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="notice" items="${list }">
		<tr onclick="location.href='ntcContent.do?n_num=${notice.n_num}&pageNum=${currentPage}&startNum=${startNum }'" style="cursor: pointer;">
			<td style="text-align: center;">${startNum }</td>
			<td>${notice.n_title }</td>
			<td style="text-align: center;">${notice.n_date }</td>
			<td style="text-align: center;">${notice.n_view }</td>
		</tr>
		<c:set var="startNum" value="${startNum-1 }"/>
		</c:forEach>
	</tbody>
	
	</table>
	</div>
	
	  <ul class="pagination" style="justify-content: center;">
	    <c:if test="${startPage > blockSize }">
		    <li class="page-item">
		      <a class="page-link" href="ntcList.do?pageNum=${startPage-blockSize }" aria-label="이전">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:if>
	    <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    	<c:if test="${currentPage==i }">
	    		<li class="page-item active"><a class="page-link" href="ntcList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
	    	<c:if test="${currentPage!=i }">
				<li class="page-item"><a class="page-link" href="ntcList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
		</c:forEach>
		<c:if test="${endPage<pageCnt }">
		    <li class="page-item">
		      <a class="page-link" href="ntcList.do?pageNum=${startPage+blockSize }" aria-label="다음">
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