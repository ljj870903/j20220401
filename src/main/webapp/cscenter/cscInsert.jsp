
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		
		
		<div class="col-lg-8 col-md-8 mx-auto">
			<form action="cscInsertPro.do" method="post">
				<input type="hidden" name="pageNum" value="${pageNum }">
				<table class="table table-striped" style="text-align: center;">
					<thead>
						<tr>
							<th colspan="2" style="font-size: 25px; padding: 20px;">1:1 문의하기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="20%">제목</td>
							<td><input
								type="text" name="cs_title" class="form-control" 
								required="required"></td>
						</tr>
						<tr>
							<td>유형</td>
							<td>
								<select class="form-select" aria-label="Default select example" name="cs_category">
								  <option selected>선택해주세요</option>
								  <option value="1">개인정보</option>
								  <option value="2">예약관련건</option>
								  <option value="3">펫시터 지원</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea class="form-control" required="required" rows="8"
									style="resize: none;" name="cs_content" placeholder="내용을 입력해주세요"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<div style="display: inline-block; float: left;">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='cscPList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
				</div>
				<div style="display: inline-block; float: right;">
					<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">문의하기</button>
				</div>
				
			</form>
			</div>
		
		
		
		
<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
</div>
	</div>
	<jsp:include page="../css/footer.jsp"></jsp:include>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<style>s
		.navbar a:hover{
			color: white;
		}
		.footer a:hover{
			color: white;
		}
	</style>
</body>
</html>