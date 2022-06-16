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
				<form action="cscUpdatePro.do?pageNum=${pageNum }&cs_num=${cs_num}&startNum=${startNum}" method="post">
					<table class="table table-striped" style="text-align: center;">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 25px; padding: 20px;">문의내역 수정하기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="20%">글번호</td>
								<td>${startNum }</td>
							</tr>
							<tr>
								<td>유형</td>
								<td>
									<c:if test="${cscenter.cs_category=='1' }">개인정보</c:if>
									<c:if test="${cscenter.cs_category=='2' }">예약관련건</c:if>
									<c:if test="${cscenter.cs_category=='3' }">펫시터 지원</c:if>
								</td>
							</tr>
							<tr>
								<td>문의 제목</td>
								<td><input type="text" name="cs_title" value="${cscenter.cs_title }" class="form-control"></td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${cscenter.cs_date }</td>
							</tr>
							<tr>
								<td>질문 내용</td>
								<td><textarea class="form-control" rows="5" style="resize: none;" name="cs_content">${cscenter.cs_content }</textarea></td>
							</tr>
						</tbody>
					</table>
					
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscPList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
					</div>
					<div style="display: inline-block; float: right;">
						<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">수정하기</button>
					</div>
				</form>
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