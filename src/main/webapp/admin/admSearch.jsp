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
           <!-- p 태그 전부 지우고 진행해주세요 -->
			<div>
				<h2>관리자용</h2>
				<div style="display: flex;">
                    <div>
                        <div>펫시터 지원</div>
                        <div onclick="location.href='sitList.do'" style="cursor: pointer;">${sitterCnt}건</div>
                    </div>
                    <div>
                        <div>1:1 직접문의</div>
                        <div>건</div>
                    </div>
                </div>
                <table class="table">
                	<thead class="table-dark">
	                	<tr>
	                		<th>ID</th><th>회원이름</th><th>연락처</th><th>회원등급</th>
	                	</tr>
                	</thead>
                	<c:if test="${schCnt > 0 }">
                		<tbody>
	                		<c:forEach var="profile" items="${searchlist }">
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
                <div style="text-align: center;">
					<c:if test="${startPage > blockSize }">
						 <a href="admMain.do?pageNum=${startPage-blockSize }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="admMain.do?pageNum=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${endPage > pageCnt }">
						 <a href="admMain.do?pageNum=${startPage+blockSize }">[다음]</a>
					</c:if>
				</div>
				<form action="admSearch.do" method="post">
       				<input type='search' name='keyword' placeholder='이름 또는 아이디를 입력하세요.'>
       				<input type="submit" value="확인">
   				</form>
			</div>
			<!-- &mem_num=${mem_num} -->
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