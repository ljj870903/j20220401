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

			<div class="col-lg-4 col-md-8 mx-auto">
				<form action="admUpdatePro.do?pageNum=${pageNum}" method="post">
					<table class="table table-striped" style="text-align: center;">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 25px; padding: 20px;">회원등급 수정</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="30%">아이디</td>
								<td>
									${profile.id }
									<input type="hidden" name="id" required="required" value="${profile.id }">	
								</td>
							</tr>
							<tr>
								<td>회원이름</td>
								<td>${profile.name }</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>${profile.gender }</td>
							</tr>
							<tr>
								<td>E-mail</td>
								<td>${profile.email }</td>
							</tr>
							<tr>
								<td>연락처</td>
								<td>${profile.phone }</td>
							</tr>
							<tr>
								<td>주소</td>
								<td>${profile.address }</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>${profile.birth }</td>
							</tr>
							<tr>
								<td>회원가입일</td>
								<td>${profile.join_date }</td>
							</tr>
							<tr>
								<td>등급</td>
								<td>
									<select class="form-select" name="grade">
										<c:if test="${profile.grade=='1' }">
											<option value="1" selected>일반회원</option>
											<option value="2">펫시터</option>
											<option value="A">관리자</option>
										</c:if>
										<c:if test="${profile.grade=='2' }">
											<option value="1">일반회원</option>
											<option value="2" selected>펫시터</option>
											<option value="A">관리자</option>
										</c:if>
										<c:if test="${profile.grade=='A' }">
											<option value="1">일반회원</option>
											<option value="2">펫시터</option>
											<option value="A" selected>관리자</option>
										</c:if>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='admMain.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
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