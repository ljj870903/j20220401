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
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
				
				
	<div class="col-lg-7 col-md-8 mx-auto">
		<table class="table" style="text-align: center;">
			<thead>
				<tr>
					<th colspan="2" style="font-size: 25px; padding: 20px;">문의내역</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="20%">문의 번호</td>
					<td>${startNum }</td>
				</tr>
				<tr>
					<td>유형</td>
					<td>
						<c:if test="${cscenter.cs_category=='1'}">개인정보</c:if>
						<c:if test="${cscenter.cs_category=='2'}">예약관련건</c:if>
						<c:if test="${cscenter.cs_category=='3'}">펫시터 지원</c:if>
					</td>
				</tr>
				<tr>
					<td>문의 제목</td>
					<td>${cscenter.cs_title}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${cscenter.cs_date}</td>
				</tr>
				<tr>
					<td>질문 내용</td>
					<td style="height: 100px;">${cscenter.cs_content}</td>
				</tr>
				<c:if test="${cscenter.cs_status=='Y' }">
					<tr>
						<td style="background: #FAECC5;">답변 제목</td>
						<td style="background: #FAECC5;">${reply.cs_title}</td>
					</tr>
					<tr>
						<td style="background: #ede0bb;">관리자 답변 내용</td>
						<td style="height: 100px; background: #ede0bb;">${reply.cs_content}</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	
		<div style="display: inline-block; float: left;">
			<c:if test="${grade=='A' }">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
			</c:if>
			<c:if test="${grade!='A' }">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscPList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
			</c:if>
		</div>
		<div style="display: inline-block; float: right;">
			<c:if test="${grade=='A' }">
				<c:if test="${cscenter.cs_status=='N' }">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscWriteForm.do?cs_num=${cs_num}&pageNum=${pageNum }'" style="margin-bottom: 10px;">답변하기</button>
				</c:if>
				<c:if test="${cscenter.cs_status=='Y' }">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscReUpdateForm.do?cs_num=${cs_num}&pageNum=${pageNum }'" style="margin-bottom: 10px;">답변 수정하기</button>
				</c:if>
			</c:if>
			<c:if test="${cscenter.mem_num==mem_num }">
				<c:if test="${cscenter.cs_status=='N' }">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscUpdateForm.do?cs_num=${cs_num}&pageNum=${pageNum }&startNum=${startNum }'" style="margin-bottom: 10px;">수정</button>
				</c:if>
				<button type="button" class="btn btn-outline-secondary" onclick="chk()" style="margin-bottom: 10px;">삭제</button>
			</c:if>
			<script type="text/javascript">
				function chk(){
					let check = confirm("정말로 삭제하시겠습니까?");
					if(check==true){
						location.href="cscDelete.do?pageNum=${pageNum}&cs_num=${cs_num }&startNum=${startNum }";
					}
				}
			</script>
		</div>
		</div>
				
				
				
			
<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
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