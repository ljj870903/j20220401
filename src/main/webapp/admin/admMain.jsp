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
	
	
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px; text-align: center;">관리자 페이지</h1>	
	
	<div class="col-lg-8 col-md-8 mx-auto">
	
	<div style="text-align: center; margin-bottom: 100px;">
		<c:if test="${sitterCnt>0 }">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='sitList.do'" style="width: 200px; height: 50px; display: inline-block;">
			  펫시터 지원 <span class="badge bg-secondary">${sitterCnt}건</span>
			</button>
		</c:if>
		<c:if test="${sitterCnt==0 }">
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='sitList.do'" style="width: 200px; height: 50px; display: inline-block;">
			  펫시터 현황
			</button>
		</c:if>
		<c:if test="${requestCnt>0 }">
			<button type="button" class="btn btn-primary btn-lg" onclick="location.href='cscList.do'" style="width: 200px; height: 50px; display: inline-block;">
			  1:1 문의요청<span class="badge bg-secondary">${requestCnt }건</span>
			</button>
		</c:if>
		<c:if test="${requestCnt==0 }">
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='cscList.do'" style="width: 200px; height: 50px; display: inline-block;">
			  1:1 문의 내역
			</button>
		</c:if>
	</div>
	
	
	<form action="admSearch.do" method="post">
		
			<div class="input-group mb-3" style="width: 40%;">
			  <input type="search" name="keyword" class="form-control" placeholder="이름 또는 아이디를 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2">
			  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">확인</button>
			</div>
		</form>
	
	
	         <table class="table">
	         	<thead class="table-dark">
	         		<tr>
	         			<th>ID</th><th>회원이름</th><th>연락처</th><th>회원등급</th>
	         		</tr>
	         	</thead>
	         	<c:if test="${totCnt > 0 }">
	         		<tbody>
		         		<c:forEach var="profile" items="${list }">
		         			<tr onclick="location.href='admUpdateForm.do?id=${profile.id}&pageNum=${currentPage}'" style="cursor: pointer;">
		          				<td>${profile.id }</td>
		          				<td>${profile.name }</td>
		          				<td>${profile.phone }</td>
		          				<td>
		          					<c:choose>
										<c:when test="${profile.grade eq '1'}">일반회원</c:when>
										<c:when test="${profile.grade eq '2'}">펫시터</c:when>
										<c:otherwise>관리자</c:otherwise>
									</c:choose>
		          				</td>
		          			</tr>
		         		</c:forEach>
	         		</tbody>
	         	</c:if>
	         </table>
	         
	         <c:if test="${keyword==null }">
	         <ul class="pagination" style="justify-content: center;">
			    <c:if test="${startPage > blockSize }">
				    <li class="page-item">
				      <a class="page-link" href="admMain.do?pageNum=${startPage-blockSize }" aria-label="이전">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach var="i" begin="${startPage }" end="${endPage }">
			    	<c:if test="${currentPage==i }">
			    		<li class="page-item active"><a class="page-link" href="admMain.do?pageNum=${i}">${i }</a></li>	
			    	</c:if>
			    	<c:if test="${currentPage!=i }">
						<li class="page-item"><a class="page-link" href="admMain.do?pageNum=${i}">${i }</a></li>	
			    	</c:if>
				</c:forEach>
				<c:if test="${endPage>pageCnt }">
				    <li class="page-item">
				      <a class="page-link" href="admMain.do?pageNum=${startPage+blockSize }" aria-label="다음">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				</c:if>
			  </ul>
			  </c:if>
			  
			  <c:if test="${keyword!=null }">
	         <ul class="pagination" style="justify-content: center;">
			    <c:if test="${startPage > blockSize }">
				    <li class="page-item">
				      <a class="page-link" href="admSearch.do?pageNum=${startPage-blockSize }&keyword=${keyword}" aria-label="이전">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach var="i" begin="${startPage }" end="${endPage }">
			    	<c:if test="${currentPage==i }">
			    		<li class="page-item active"><a class="page-link" href="admSearch.do?pageNum=${i}&keyword=${keyword}">${i }</a></li>	
			    	</c:if>
			    	<c:if test="${currentPage!=i }">
						<li class="page-item"><a class="page-link" href="admSearch.do?pageNum=${i}&keyword=${keyword}">${i }</a></li>	
			    	</c:if>
				</c:forEach>
				<c:if test="${endPage>pageCnt }">
				    <li class="page-item">
				      <a class="page-link" href="admSearch.do?pageNum=${startPage+blockSize }&keyword=${keyword}" aria-label="다음">
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