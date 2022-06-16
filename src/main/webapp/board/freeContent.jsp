<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/section.css?">
<title>구해줘 집사</title>

<script type="text/javascript">
		
		function del(){
			if(confirm("정말로 삭제 하시겠습니까?")){
				location.href="boardDeletePro.do?free_num=${board.free_num}&pageNum=${pageNum}&b_category=${board.b_category}";
			}
		}
		
		//${reply.free_num},${pageNum1},${board.b_category}free_num=${board.free_num}
		function deleteCheck2(reply_free_num, b_category,free_num ) {
			 if (confirm("댓글을 삭제하시겠습니까?") == true){    //확인
				location.href="replyDeletePro.do?reply_free_num="+reply_free_num+"&b_category="+b_category+"&free_num="+free_num;
				return true;
			 }else{   //취소
	
			     return false;
	
			 }
	
		}

</script>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>

	<div class="container">
			<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
			<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
			
	<c:if test="${mem_num!=null&&grade!=null }">	
		<script type="text/javascript">
			$(function(){
				$('#recoBox').click(function(){
					if(confirm("이 글을 추천하시겠습니까")){
						location.href="recommendPro.do?free_num=${board.free_num}&pageNum=${pageNum}";
					}
				});
			});
		</script>
	</c:if>
	<c:if test="${mem_num==null||grade==null }">	
		<script type="text/javascript">
			$(function(){
				$('#recoBox').click(function(){
					alert("추천을 하려면 로그인 해야 합니다");
				});
			});
		</script>
	</c:if>
	
	
	<div class="col-lg-8 col-md-8 mx-auto">
	
	<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 25px; padding: 20px;">자유게시판</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">제목</td>
						<td>${board.b_title }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${board.id }</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${board.b_date }</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${board.b_view }</td>
					</tr>
					<c:if test="${board.b_photo!=null }">
						<tr>
							<td>사진</td>
							<td><img src="${context }/fileSave/${board.b_photo}" width="90%"></td>
						</tr>
					</c:if>
					<tr>
						<td>내용</td>
						<td style="height: 100px;">${board.b_content }</td>
					</tr>
				</tbody>
			</table>
			
			<div>
				<div id="recoBox" style="border: 1px solid grey; display: flex; width: 100px; height: 50px; border-radius: 6px; justify-content: center; align-items: center; cursor: pointer; margin: 0 auto;">
					<div style="display: block;">
						<img id="recoImg" alt="" src="${context }/fileSave/thumbs.png" width="25px" style="display: inline; vertical-align: sub; margin-right: 2px;">
						<font size="4" color="blue">${board.b_rc_cnt }</font>
					</div>
				</div>
			</div>
			
			<c:if test="${grade=='1'||grade=='2'||grade=='A' }">
				<div style="margin-top: 20px;">
					<form action="boardReplyPro.do">
						<div class="input-group">
						<input type="hidden" name="pageNum" value="${pageNum}"> <input
							type="hidden" name="b_category" value="${board.b_category}">
							<input type="hidden" name="mem_num" value="${mem_num}"> <input
							type="hidden" name="free_num" value="${board.free_num}"> <input
							type="hidden" name="ref" value="${board.ref }"> <input
							type="hidden" name="re_level" value="${board.re_level}"> <input
							type="hidden" name="re_step" value="${board.re_step}">
						  <input type="text" placeholder="댓글을 입력하세요" name="b_content" class="form-control" id="replyWriteForm" aria-label="replyWrite">
						  <button class="btn btn-outline-secondary" type="submit">확인</button>
						</div>
					</form>
				</div>
			</c:if>
			
			<div style="margin-top: 20px;" id="msg">
			<table class="table table-striped">
				<c:if test="${replyList!=null }">
					<thead class="table-secondary">
						<tr>
							<td>작성자</td><td>날짜</td><td>내용</td><td>&nbsp</td>
						</tr>
					</thead>
				</c:if>
				<tbody>
				<c:forEach var="reply" items="${replyList }">
				<tr>
					<td width="15%">${reply.id }</td>
					<td width="15%">${reply.b_date }</td>
					<td id="td${reply.free_num }" width="50%">${reply.b_content }</td>
					<td width="20%">
						<c:if test="${reply.mem_num==mem_num }">
							<button type="button" class="btn btn-outline-secondary btn-sm" id="bt${reply.free_num }">수정</button>
							<script type="text/javascript">
								$(function(){
									$('#bt${reply.free_num}').click(function(){
										var sendData = "free_num="+${reply.free_num};
										$.ajax({
											type:'get',
											url:'freeReUpdate.do',
											dataType:'text',
											data:sendData,
											success:function(data){
												$('#td${reply.free_num}').html(data);
											}
										});
									});
	
								});
							</script>
						</c:if>
						<c:if test="${reply.mem_num==mem_num||grade=='A' }">
							<button type="button" class="btn btn-outline-secondary btn-sm"
							onclick="deleteCheck2(${reply.free_num},${board.b_category},${board.free_num})">삭제</button>
						</c:if>
					</td>
				</tr>
			
			</c:forEach>
			</tbody>
			</table>
			</div>
	
	<div style="display: inline-block; float: left;">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='boardList.do?pageNum=${pageNum}&b_category=${board.b_category}'" style="margin-bottom: 10px;">목록</button>
	</div>
	<div style="display: inline-block; float: right;">
		<c:if test="${board.mem_num==mem_num }">
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='boardUpdateForm.do?free_num=${board.free_num}&pageNum=${pageNum}'" style="margin-bottom: 10px;">수정</button>
		</c:if>
		<c:if test="${board.mem_num==mem_num||grade=='A' }">
			<button type="button" class="btn btn-outline-secondary" onclick="del()" style="margin-bottom: 10px;">삭제</button>
		</c:if>
	
	</div>
			
		</div>
			
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