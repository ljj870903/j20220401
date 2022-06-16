<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/section.css?">

<title>구해줘 집사</title>
<style type="text/css">
.div.img {
	border-radius: 70%;
}
</style>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div style="width: 100vw; height: 400; background: #f5dcd1;">
		<img alt="" src="${context }/fileSave/pet2.gif" height="400"
			style="display: block; margin: 0 auto;">
	</div>
	<div class="container">
			<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->

			<script type="text/javascript">
				$(function() {
					$("#sit_start").timepicker({
						timeFormat : 'HH:mm p',
						interval : 60,
						defaultTime : '12',
						startTime : '00:00',
						dynamic : false,
						dropdown : true,
						scrollbar : true
					});
				});
				$(function() {
					$("#sit_end").timepicker({
						timeFormat : 'HH:mm p',
						interval : 60,
						defaultTime : '13',
						startTime : '00:00',
						dynamic : false,
						dropdown : true,
						scrollbar : true
					});
				});
			</script>
			
			<c:if test="${mem_num==0 }">
				<script type="text/javascript">
					alert("로그인을 해주세요");
					location.href = "main.do";
				</script>
				
			</c:if>
			<c:if test="${totCnt >0 }">
				<div id="msg1" style="text-align: center;">
					<c:forEach var="info" items="${list}">
						<img src="${context }/fileSave/${info.pet_photo}" width="300"
							height="300" style="border-radius: 33%; margin-top: 40px;">
						<br>
					</c:forEach>
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
				    		<li class="page-item active" style="margin-left: 2px; margin-right: 2px; margin-top: 10px;"><button type="button" class="btn btn-primary" id="sum${i }">${i }</button></li>	
				    	<script type="text/javascript">
							$(function() {
								$('#sum${i}').click(function() {
									var sendData = "pageNum=" + ${i};
									$.ajax({
										type : 'get',
										url : 'resInsertForm1.do',
										dataType : 'text',
										data : sendData,
										success : function(data) {
											$('#msg1').html(data);
										}
									});
								});
							});
						</script>
					</c:forEach>
					<c:if test="${endPage>pageCnt }">
					    <li class="page-item">
					      <a class="page-link" href="resList.do?pageNum=${startPage+blockSize }" aria-label="다음">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:if>
				  </ul>
				<div>
					<button type="button" class="btn btn-outline-primary btn-lg" style="display: block; margin: auto;"
						onclick="location.href='petInsertForm.do'">펫 추가하기</button>
				</div>


				<div class="col-lg-5 col-md-8 mx-auto" style="margin-bottom: 50px;">
					<hr class="my-4">
					<h1 class="fw-bolder" id="head1">예약하기</h1>
					<form class="row g-3" action="resInsertPro.do?mem_num=${mem_num }" id="frm1" method="post">
						<div class="col-12">
							<label for="sitDate" class="form-label">방문 날짜</label> <input
								type="date" name="sit_date" min="${sysdate }" value="${sysdate }" class="
								form-control" id="sitDate" required>
						</div>
						<div class="col-12">
							<label for="sitTime" class="form-label">돌봄 시간</label>
							<div class="input-group" id="sitTime">
								<input type="text" class="form-control" name="sit_start" id="sit_start">
							<div class="input-group-text">~</div>
								<input type="text" class="form-control" name="sit_end" id="sit_end">
							</div>
						</div>

						<div class="my-3">
							<label for="request" class="form-label">상세 요청사항</label>
							<textarea class="form-control" id="request" rows="5"
								style="resize: none;" name="request" required="required" placeholder="ex) 사람을 좋아해서 막 따라가요"></textarea>
						</div>

						<button type="submit" class="btn btn-primary btn-lg">예약하기</button>

					</form>
				</div>
				
			</c:if>	
			<c:if test="${totCnt ==0 }">
				<div class="col-lg-5 col-md-8 mx-auto" style="text-align: center; margin: 30px;" >
					<h1 class="fw-bolder" style="margin-bottom: 100px;">펫을 먼저 등록해주세요</h1>
					<button type="button" class="btn btn-outline-primary btn-lg" style="display: block; margin: auto;"
						onclick="location.href='petInsertForm.do'">펫 추가하기</button>
				</div>
			</c:if>
				
				

			<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	</div>
	<jsp:include page="../css/footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<style>
.navbar a:hover {
	color: white;
}

.footer a:hover {
	color: white;
}
</style>
</body>
</html>